package com.example.javabasic.sample.middleware.poi.template;

import org.apache.poi.xwpf.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author cph
 * @date 2019/3/11
 */
public class Template {

    private XWPFDocument document;

    public XWPFDocument getDocument() {
        return document;
    }

    public void setDocument(XWPFDocument document) {
        this.document = document;
    }

    public Template(FileInputStream fileInputStream) throws IOException {
        document = new XWPFDocument(fileInputStream);
    }

    /**
     * 文档替换
     *
     * @param dataMap
     */
    public void replaceDocumnet(Map dataMap) {

        //获取模板所有对象（段落+表格）
        List<IBodyElement> bodyElementList = document.getBodyElements();
        //标记模板对象个数
        int size = bodyElementList.size();
        //当前操作的段落对象索引
        int curP = 0;
        //当前操作的表格对象索引
        int curT = 0;

        for (int i = 0; i < size; i++) {
            IBodyElement body = bodyElementList.get(i);
            if (BodyElementType.TABLE.equals(body.getElementType())) {
                //处理表格
                List<XWPFTable> tableList = body.getBody().getTables();
                XWPFTable table = tableList.get(curT);
                if (table != null) {
                    List<XWPFTableCell> tableCellList = table.getRows().get(0).getTableCells();
                    String tableText = table.getText();
                    if (tableText.indexOf("##{foreach") > -1) {
                        //查找到##{foreach标签，该表格需要循环处理
                        if (tableCellList.size() != 2) {
                            System.out.println("模板错误");
                        }

                    } else if (tableText.indexOf("{") > -1) {
                        //未找到##{foreach标签，查找到普通替换数据{}标签，该表格仅需要简单替换

                    } else {
                        //未找到任何标签，该表格是一个静态表格，仅需复制一个
                        addTableInDocFooter(table, null, null, 0);
                    }

                    curT++;
                }

            } else if (BodyElementType.PARAGRAPH.equals(body.getElementType())) {
                //处理段落
                XWPFParagraph paragraph = body.getBody().getParagraphArray(curP);
                if (paragraph != null) {

                    addParagraphInDocFooter(paragraph, dataMap, 0);

                    curP++;
                }

            } else {
                System.out.println("模板文件错误：含有不支持的内容");
            }
        }

        //模板处理完毕后删除原始模板内容
        for (int i = 0; i < size; i++) {
            document.removeBodyElement(0);
        }

    }

    /**
     * @param templateTable 模板表格
     * @param list          循环数据集
     * @param map           不循环数据集
     * @param flag          0-静态表格 1-表格整体循环 2-表格内部行循环 3-表格不循环仅简单替换标签
     */
    public void addTableInDocFooter(XWPFTable templateTable, List<Map<String, Object>> list, Map<String, Object> map, int flag) {
        if (flag == 0) {
            //静态表格

            //获取模板表格所有行
            List<XWPFTableRow> tableRowList = templateTable.getRows();

            //创建新表格，默认一行一列
            XWPFTable newCreateTable = document.createTable();

            for (int j = 0; j < tableRowList.size(); j++) {
                XWPFTableRow newCreateRow = newCreateTable.createRow();
                copyTableRow(newCreateRow, tableRowList.get(j));
            }

            //移除模板表格标识行
            newCreateTable.removeRow(0);
            //添加回车换行
            document.createParagraph();


        } else if (flag == 1) {
            //表格整体循环

        } else if (flag == 2) {
            //表格内部行循环

        } else if (flag == 3) {
            //表格不循环仅替换标签

        }

    }

    /**
     * 根据 模板段落 和 数据 在文档末尾生成新段落
     *
     * @param paragraph
     * @param dataMap
     * @param flag      0-不循环替换，1-循环替换
     */
    public void addParagraphInDocFooter(XWPFParagraph paragraph, Map dataMap, int flag) {
        if (flag == 0) {
            //创建新段落
            XWPFParagraph createParagraph = document.createParagraph();
            //设置段落样式
            createParagraph.getCTP().setPPr(paragraph.getCTP().getPPr());
            //移除原始内容
            for (int j = 0; j < createParagraph.getRuns().size(); j++) {
                createParagraph.removeRun(j);
            }
            //添加Run标签
            for (XWPFRun run : paragraph.getRuns()) {
                XWPFRun newRun = createParagraph.createRun();
                newRun.getCTR().setRPr(run.getCTR().getRPr());
                newRun.setText(run.text());
            }
            //进行数据替换
            replaceParagraph(createParagraph, dataMap);

        } else if (flag == 1) {

        }
    }

    /**
     * 复制模板表格的行
     *
     * @param newRow
     * @param templateRow
     */
    public void copyTableRow(XWPFTableRow newRow, XWPFTableRow templateRow) {
        //模板行的列数
        int templateRowCellSize = templateRow.getTableCells().size();

        //为新加行添加与模板行相同的列数
        for (int k = 0; k < templateRowCellSize - 1; k++) {
            newRow.addNewTableCell();
        }

        //复制行样式
        newRow.getCtRow().setTrPr(templateRow.getCtRow().getTrPr());

        //复制单元格
        for (int q = 0; q < newRow.getTableCells().size(); q++) {
            copyTableCell(newRow.getCell(q), templateRow.getCell(q));
        }
    }

    /**
     * 复制模板表格的列
     *
     * @param newCell
     * @param templateCell
     */
    public void copyTableCell(XWPFTableCell newCell, XWPFTableCell templateCell) {
        //设置列样式
        newCell.getCTTc().setTcPr(templateCell.getCTTc().getTcPr());

        //删除新加列的原始段落
        for (int p = 0; p < newCell.getParagraphs().size(); p++) {
            newCell.removeParagraph(p);
        }

        //在新加列中添加新段落
        for (XWPFParagraph templateParagraph : templateCell.getParagraphs()) {
            XWPFParagraph newParagraph = newCell.addParagraph();
            copyParagraph(newParagraph, templateParagraph);
        }
    }

    /**
     * 复制模板表格段落
     *
     * @param newParagraph
     * @param templateParagraph
     */
    public void copyParagraph(XWPFParagraph newParagraph, XWPFParagraph templateParagraph) {
        //设置段落样式
        newParagraph.getCTP().setPPr(templateParagraph.getCTP().getPPr());

        //删除新加段落的原始Run
        for (int s = 0; s < newParagraph.getRuns().size(); s++) {
            newParagraph.removeRun(s);
        }

        //在新加段落中添加新Run
        for (XWPFRun templateRun : templateParagraph.getRuns()) {
            XWPFRun newRun = newParagraph.createRun();
            copyRun(newRun, templateRun);
        }
    }

    /**
     * 复制模板表格Run
     *
     * @param newRun
     * @param templateRun
     */
    public void copyRun(XWPFRun newRun, XWPFRun templateRun) {
        //设置Run样式
        newRun.getCTR().setRPr(templateRun.getCTR().getRPr());
        //设置内容
        newRun.setText(templateRun.text());
    }

    /**
     * 替换段落内的变量{name}、{date}等
     *
     * @param createParagraph
     * @param dataMap
     */
    public void replaceParagraph(XWPFParagraph createParagraph, Map dataMap) {
        List<XWPFRun> runList = createParagraph.getRuns();
        String createParagraphText = createParagraph.getText();
        String regEx = "\\{.+?\\}";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(createParagraphText);

        if (matcher.find()) {
            int beginRunIndex = createParagraph.searchText("{", new PositionInParagraph()).getBeginRun();
            int endRunIndex = createParagraph.searchText("}", new PositionInParagraph()).getEndRun();
            StringBuffer key = new StringBuffer();

            if (beginRunIndex == endRunIndex) {
                XWPFRun beginRun = runList.get(beginRunIndex);
                String beginRunText = beginRun.text();

                int beginIndex = beginRunText.indexOf("{");
                int endIndex = beginRunText.indexOf("}");
                int length = beginRunText.length();

                if (beginIndex == 0 && endIndex == length - 1) {
                    //标签只有{**}在单个Run内
                    XWPFRun insertNewRun = createParagraph.insertNewRun(beginRunIndex);
                    insertNewRun.getCTR().setRPr(beginRun.getCTR().getRPr());
                    key.append(beginRunText.substring(1, endIndex));
                    insertNewRun.setText(getValueByKey(key.toString(), dataMap));
                    createParagraph.removeRun(beginRunIndex + 1);
                } else {
                    //标签{**}前后有内容，替换key后需要加上前后文本
                    XWPFRun insertNewRun = createParagraph.insertNewRun(beginRunIndex);
                    insertNewRun.getCTR().setRPr(beginRun.getCTR().getRPr());
                    key.append(beginRunText.substring(beginRunText.indexOf("{") + 1, beginRunText.indexOf("}")));
                    String textString = beginRunText.substring(0, beginIndex) + getValueByKey(key.toString(), dataMap)
                            + beginRunText.substring(endIndex + 1);
                    insertNewRun.setText(textString);
                    createParagraph.removeRun(beginRunIndex + 1);
                }
            } else {
                //标签{**}被分到多个Run内
                XWPFRun beginRun = runList.get(beginRunIndex);
                String beginRunText = beginRun.text();
                int beginIndex = beginRunText.indexOf("{");
                if (beginRunText.length() > 1) {
                    key.append(beginRunText.substring(beginIndex + 1));
                }
                //需要移除的Run
                ArrayList<Integer> removeRunList = new ArrayList<>();
                for (int i = beginRunIndex + 1; i < endRunIndex; i++) {
                    XWPFRun run = runList.get(i);
                    String runText = run.text();
                    key.append(runText);
                    removeRunList.add(i);
                }

                // 获取endRun中的key值
                XWPFRun endRun = runList.get(endRunIndex);
                String endRunText = endRun.text();
                int endIndex = endRunText.indexOf("}");
                //run中**}或者**}**
                if (endRunText.length() > 1 && endIndex != 0) {
                    key.append(endRunText.substring(0, endIndex));
                }

                /*
                 * 开始标签
                 */
                if (beginRunText.length() == 2) {
                    XWPFRun insertNewRun = createParagraph.insertNewRun(beginRunIndex);
                    insertNewRun.getCTR().setRPr(beginRun.getCTR().getRPr());
                    // 设置文本
                    insertNewRun.setText(getValueByKey(key.toString(), dataMap));
                    //移除原始Run
                    createParagraph.removeRun(beginRunIndex + 1);
                } else {
                    XWPFRun insertNewRun = createParagraph.insertNewRun(beginRunIndex);
                    insertNewRun.getCTR().setRPr(beginRun.getCTR().getRPr());
                    // 设置文本
                    String textString = beginRunText.substring(0, beginRunText.indexOf("{")) + getValueByKey(key.toString(), dataMap);
                    insertNewRun.setText(textString);
                    createParagraph.removeRun(beginRunIndex + 1);
                }

                /*
                 * 结束标签
                 */
                if (beginRunText.length() == 1) {
                    // run标签内文本只有}
                    XWPFRun insertNewRun = createParagraph.insertNewRun(endRunIndex);
                    insertNewRun.getCTR().setRPr(endRun.getCTR().getRPr());
                    // 设置文本
                    insertNewRun.setText("");
                    //移除原始Run
                    createParagraph.removeRun(endRunIndex + 1);
                } else {
                    // 该run标签为**}**或者 }** 或者**}，替换key后，还需要加上原始key后的文本
                    XWPFRun insertNewRun = createParagraph.insertNewRun(endRunIndex);
                    insertNewRun.getCTR().setRPr(endRun.getCTR().getRPr());
                    // 设置文本
                    String textString = endRunText.substring(endRunText.indexOf("}") + 1);
                    insertNewRun.setText(textString);
                    //移除原始的run
                    createParagraph.removeRun(endRunIndex + 1);
                }

                /*
                 * 处理中间的run标签
                 */
                for (int i = 0; i < removeRunList.size(); i++) {
                    //原始Run
                    XWPFRun xWPFRun = runList.get(removeRunList.get(i));
                    XWPFRun insertNewRun = createParagraph.insertNewRun(removeRunList.get(i));
                    insertNewRun.getCTR().setRPr(xWPFRun.getCTR().getRPr());
                    insertNewRun.setText("");
                    //移除原始
                    createParagraph.removeRun(removeRunList.get(i) + 1);
                }
            }

            replaceParagraph(createParagraph, dataMap);

        }
    }

    /**
     * @param key
     * @param map
     * @return
     */
    public String getValueByKey(String key, Map<String, Object> map) {
        String value = "";
        if (key != null) {
            try {
                value = map.get(key) != null ? map.get(key).toString() : "";
            } catch (Exception e) {
                System.out.println("key=" + key);
                e.printStackTrace();
            }
        }
        return value;
    }


}

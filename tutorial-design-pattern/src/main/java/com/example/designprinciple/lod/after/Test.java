package com.example.designprinciple.lod.after;

/**
 * @author cph
 * @date 2019/11/16
 */
public class Test {
    public static void main(String[] args) {
        Boss boss = new Boss();
        TeamLeader teamLeader = new TeamLeader();
        boss.commandCheckNum(teamLeader);

        //这种代码结构中，boss无需关心courses，只要teamLeader给出最终结果就行
        //符合迪米特法则即最少知道法则
    }
}

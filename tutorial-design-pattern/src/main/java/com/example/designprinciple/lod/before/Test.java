package com.example.designprinciple.lod.before;

/**
 * @author cph
 * @date 2019/11/16
 */
public class Test {
    public static void main(String[] args) {
        Boss boss = new Boss();
        TeamLeader teamLeader = new TeamLeader();
        boss.commandCheckNum(teamLeader);

        //boss只要想teamLeader给出最终结果，boss本身无需与course产生直接交流
        //违背迪米特法则
    }
}

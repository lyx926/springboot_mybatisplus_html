package com.example.book_crud.service;

import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class ExcelTest {
    public static void main(String[] args) {

        ExcelReader sheetA = ExcelUtil.getReader("C:\\Users\\Administrator\\Desktop\\2023新护士资质准入(含自然编码) - 副本.xlsx", 0);
        ExcelReader sheetB = ExcelUtil.getReader("C:\\Users\\Administrator\\Desktop\\2023新护士资质准入(含自然编码) - 副本.xlsx", 1);
        ExcelReader sheetC = ExcelUtil.getReader("C:\\Users\\Administrator\\Desktop\\2023新护士资质准入(含自然编码) - 副本.xlsx", 2);

        List<Map<String, Object>> readAllA = sheetA.readAll();

        List<Map<String, Object>> readAllB = sheetB.readAll();
        List<Map<String, Object>> readAllC = sheetC.readAll();

        int nums = 1;
        for (Map<String, Object> name : readAllC) {
            // {小儿内科重症F15东病区=急诊神经外科NICU病区, 杜雪=路源广, 3801=3843}

            for (Map<String, Object> dept : readAllB) {
                // {产科F9东病区=疼痛科东十病区, 146=38}
                if (StrUtil.equals(name.get("科室").toString(), dept.get("科室").toString())) {
                    String nurseNumber = "";
                    for (Map<String, Object> number : readAllA) {
                        if (StrUtil.equals(number.get("自然编码").toString(), name.get("账号").toString())) {
                            nurseNumber = number.get("护士证号").toString();
                        }
                    }
//                    System.out.println(nurseNumber);
                    String sql = "\n" +
                            "INSERT INTO traindb.dbo.person ( personName, personLogin, passWord, departmentId, headPic, birthday,\n" +
                            "lastLoginTime, personType, isTeacher, isInside, personLevel, onlineTime, specialize,\n" +
                            "intro, isDel, addPersonId, addDateTime, delPersonId, delDateTime, identityno, nation,\n" +
                            "sex, duty, workday, qualification, email, nurseno, establish, worktime, namePinYin,\n" +
                            "personLevelId, qualificationId, educationId, flag)\n" +
                            "VALUES ( N'" + name.get("名字") + "', N'" + name.get("账号") + "', N'UWxobHB4QDIwMjI=', " + dept.get("部门") + ", null, N'97-10-16', N'2023-07-23 20:38:54', 1, 0, 1, N'N1',\n" +
                            "31, N'护理', N'', 0, 22, N'2023-07-22 21:58:09', null, null, N'370321199710160918', N'汉', 1, N'护士',\n" +
                            "N'20-9-1', N'护士', N'1101412044@qq.com', N'" + nurseNumber + "', 0, N'23-4-15', N'djb', 2, 0, 0, null);\n";
                    System.out.println(sql);
                    System.out.println(nums++);
                }
            }

        }


    }
}

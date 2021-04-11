package com.example.intentdandata;

import java.util.ArrayList;

public class ClassData {
    private static String[] title = new
            String[]{"Breaking Bad","Game of Thrones","The Office"};

    private static int[] thumbnail = new
            int[]{R.drawable.bb,R.drawable.got,R.drawable.to};

    public static ArrayList<ClassModel> getListData() {
        ClassModel classModel = null;
        ArrayList<ClassModel> list = new ArrayList<>();
        for (int i = 0; i <title.length; i++) {
            classModel = new ClassModel();
            classModel.setImageSeries(thumbnail[i]);
            classModel.setNameSeries(title[i]);
            list.add(classModel);
        }
        return list;
    }
}

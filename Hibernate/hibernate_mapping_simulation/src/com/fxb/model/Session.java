package com.fxb.model;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/24 0024.
 */
public class Session {
    String tableName = "_student";
    Map<String,String> columnField = new HashMap<String, String>();
    String[] methodNames;

    public Session(){
        columnField.put("_id","id");
        columnField.put("_name","name");
        columnField.put("_age","age");
        methodNames = new String[columnField.size()];
    }

    public void save(Student student) throws Exception{
        String sql = createSQL();

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/hibernate","root","");
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for(int i=0;i<methodNames.length;i++){
            Method m = student.getClass().getMethod(methodNames[i]);
            Class r = m.getReturnType();
            if(r.getName().equals("java.lang.String")){
                String returnValue = (String)m.invoke(student);
                preparedStatement.setString(i+1,returnValue);
            }
            if(r.getName().equals("int")){
                Integer returnValue = (Integer) m.invoke(student);
                preparedStatement.setInt(i+1,returnValue);
            }
        }
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }

    public String createSQL(){
        String string1 = "";
        int index = 0;
        for(String s:columnField.keySet()){
            methodNames[index] = "get" + Character.toUpperCase(columnField.get(s).charAt(0)) + columnField.get(s).substring(1);
            string1 += s + ",";
            index ++;
        }
        string1 = string1.substring(0,string1.length()-1);
        System.out.println(string1);

        String string2 = "";
        for(int i=0;i<columnField.size();i++){
            string2 += "?,";
        }
        string2 = string2.substring(0,string2.length()-1);
        System.out.println(string2);
        String sql = "insert into" + tableName + "(" +string1 + ")" + "values" + "(" +string2 + ")";
        return sql;
    }
}

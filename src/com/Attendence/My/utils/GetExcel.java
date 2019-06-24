package com.Attendence.My.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetExcel {
    public static StringBuffer getExcel(String tablename, List<String> colname, JSONArray DataMap){

        StringBuffer sb = new StringBuffer();
        sb.append("<table><tr>");
        for (int i = 0; i < colname.size(); i++) {
            sb.append("<td>" + colname.get(i) + "</td>");
        }
        sb.append("</tr>");

//        sb.append("<table><tr><td>用户名称</td><td>邮箱地址</td></tr>");

        sb.append("<tbody>");
        for (int i = 0; i < DataMap.size() ; i++) {
            JSONObject js = DataMap.getJSONObject(i);

            sb.append("<tr>");
            for (int j = 0; j < js.size(); j++) {
                sb.append("<td>");
                sb.append(js.get(colname.get(j)));
                sb.append("</td>");
            }
            sb.append("</tr>");

        }
        sb.append("</tbody>");
        sb.append("</table>");
//        for (String key : map.keySet()) {
//            sb.append("<tr><td>").append(key).append("</td><td>").append(map.get(key)).append("</td></tr>");
//        }
        return sb;
    }
}

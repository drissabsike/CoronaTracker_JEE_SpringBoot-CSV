<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.google.gson.*"%>
<%@page import="fusioncharts.FusionCharts"%>

<%
    // Establish a connection to the database
    Class.forName("com.mysql.cj.jdbc.Driver"); 
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/analytics?serverTimezone=UTC", "root", "");
    %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creating Charts with Data from a Database - fusioncharts.com</title>
<!--     Step 1: Include the `fusioncharts.js` file. This file is needed to
        render the chart. Ensure that the path to this JS file is correct.
        Otherwise, it may lead to JavaScript errors.
-->
        <script src="../scripts/fusioncharts.js"></script>
    </head>
    <body>
         <div id="chart"></div>
<!--    Step 2: Include the `FusionCharts.java` file as a package in your
        project.

        Step 3:Include the package in the file where you want to show
        FusionCharts.

-->
    

<!--

        Step 4: Create a chart object using the FusionCharts JAVA class
        constructor. Syntax for the constructor:
        `FusionCharts("type of chart", "unique chart id", "width of chart",
                        "height of chart", "div id to render the chart",
                        "data format", "data source")`
-->
        <%
         /*
            google-gson

            Gson is a Java library facilitating conversion of Java objects
            into their JSON representation and
            JSON strings into their equivalant Java objects.
            Gson can also work with arbitrary Java objects
            including the pre-existing ones that
            you may not have the source-code for.
            Read the note below this code for more details on the google-gson library.
         */

            Gson gson = new Gson();


            // Form the SQL query that returns the top 10 most populous countries
            String sql="SELECT Name, Population FROM Country ORDER BY Population DESC LIMIT 10";

            // Execute the query
            PreparedStatement pt=con.prepareStatement(sql);
            ResultSet rs=pt.executeQuery();

            // The 'chartobj' map object holds the chart attributes and data.
            Map<String, String> chartobj = new HashMap<String, String>();

            chartobj.put("caption", "Top 10 most populous countries");
            chartobj.put("showValues", "0");
            chartobj.put("theme", "zune");

            // Push the data into the array using map object.
            ArrayList arrData = new ArrayList();
            while(rs.next()) {
                Map<String, String> lv = new HashMap<String, String>();
                lv.put("label", rs.getString("Name"));
                lv.put("value", rs.getString("Population"));
                arrData.add(lv);
            }

            //close the connection.
            rs.close();

            //create 'dataMap' map object to make a complete FC datasource.
             Map<String, String> dataMap = new LinkedHashMap<String, String>();
        /*
            gson.toJson() the data to retrieve the string containing the
            JSON representation of the data in the array.
        */
             dataMap.put("chart", gson.toJson(chartobj));
             dataMap.put("data", gson.toJson(arrData));

             FusionCharts columnChart= new FusionCharts(
                        //type of chart
                        "column2d",
                        //unique chart ID
                        "chart1",
                        //width and height of the chart
                        "700","400",
                        //div ID of the chart container
                        "chart",
                        //data format
                        "json",
                        //data source
                        gson.toJson(dataMap)
                    );

            %>

<!--    Step 5: Render the chart    -->
            <%=columnChart.render()%>

    </body>
</html>
<!DOCTYPE HTML>
<#assign action = "Add">
<html>
    <head>
        <meta charset="UTF-8" />
        <#include "/header.ftl">
        <link rel="stylesheet" type="text/css" href="/css/style.css"/>
    </head>
    <body>
        <a href="/products">Back to Product List</a>
        <br/>
        <#if errorMessage?has_content>
            <div class="error">${errorMessage}</div>
        </#if>
        <form action="${'/products/' + 'add'}" name="product" method="POST">
            <table border="1">
                <tr>
                    <td>Name</td>
                    <td>:</td>
                    <td><input type="text" name="name" value="" /></td>    
                </tr>
                <tr>
                    <td>Units</td>
                    <td>:</td>
                    <td><input type="number" name="units" value="" /></td>              
                </tr>    				            
            </table>
            <input type="submit" value="Create" />
        </form>
    </body>
</html>
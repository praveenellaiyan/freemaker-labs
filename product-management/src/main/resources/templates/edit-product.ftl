<!DOCTYPE HTML>
<#assign action = "Edit">
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
        <form action="${'/products/' + product.name + '/edit'}" name="product" method="POST">
            <table border="0">
                <tr>
                    <td>Name</td>
                    <td>:</td>
                    <td>${product.name}</td>             
                </tr>
                
                <tr>
                    <td>Created At</td>
                    <td>:</td>
                    <td><input type="text" name="createdAt" value="${(product.createdAt)!''}" readonly/></td>             
                </tr>
                
                <tr>
                    <td>Units</td>
                    <td>:</td>
                    <td><input type="number" name="units" value="${(product.units)!''}" /></td>              
                </tr>    
                
				            
            </table>
            <input type="submit" value="Update" />
        </form>
    </body>
</html>
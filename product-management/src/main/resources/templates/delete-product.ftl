<!DOCTYPE HTML>
<#assign action = "Delete">
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
        <form action="${'/products/' + product.name + '/delete'}" method="POST">
            <table border="1">
                <tr>
                    <td>Name</td>
                    <td>:</td>
                    <td>${product.name}</td>             
                </tr>
                
                <tr>
                    <td>Units</td>
                    <td>:</td>
                    <td>${product.units}</td>              
                </tr>
                
                <tr>
                    <td>Created At</td>
                    <td>:</td>
                    <td>${product.createdAt}</td>             
                </tr>                   
                
                 <tr>
                    <td>Updated At</td>
                    <td>:</td>
                    <td>${(product.updatedAt)!""}</td>             
                </tr>                
				            
            </table>
            <input type="submit" value="Confirm" />
        </form>
    </body>
</html>
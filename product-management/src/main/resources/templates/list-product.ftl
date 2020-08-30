<!DOCTYPE HTML>
<#assign action = "List">
<html>
    <head>
        <meta charset="UTF-8" />
        <#include "/header.ftl">
        <link rel="stylesheet" type="text/css" href="/css/style.css"/>
    </head>
    <body>
        <div>
            <nobr>
                <a href="/products/add">Add Product</a> |
                <a href="/">Home</a>
            </nobr>
        </div>
        
        <#if errorMessage?has_content>
            <div class="error">${errorMessage}</div>
        </#if>
        
        <br/><br/>
        <div>
            <table border="1">
                <tr>
                    <th>Name</th>
                    <th>Units</th>
                    <th>Created At</th>
                    <th>Updated At</th>
                    <th colspan="2">Action</th>                    
                </tr>
                <#list products as product>
                    <tr>
                        <td>${product.name}</a></td> 
                        <td><#if (product.units >0)>${product.units}<#else>Out of stock</#if></td>
                        <td>${(product.createdAt)}</td>
                        <td>${(product.updatedAt)!"Not Updated"}</td>
                        <td><a href="${'products/' + product.name + '/edit'}">Edit</a></td>
                        <td><a href="${'products/' + product.name + '/delete'}">Delete</a></td>
                    </tr>
                </#list>
            </table>          
        </div>
        <br/><br/>
    </body>
</html>
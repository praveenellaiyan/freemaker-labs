# FREEMAKER TEMPLATE

## What is FreeMaker Template?
FreeMarker is a Java-based template engine focused on generation of dynamic web pages.

## Why FreeMaker Template?
- No dependency on servlets or HTTP or HTML.
- Supoorts various Template loaders.
  - ClassTemplateLoader
  - FileTemplateLoader
  - StringTemplateLoader
  - URLTemplateLoader
  - WebappTemplateLoader
- Automatic object wrapping.
- Xml processing
- Auto-escaping and output formats
- Easy to leverage custom tags.
- Supports JSP tag library.
- Does support MVC (Model View Controller) pattern.

## Where we can use FreeMaker Template?
- Dynamic web application
- Non-web application
- Working with rendering text based Output [i.e. Email, HTML web pages, Config files etc.]
## How it works?
````
    TEMPLATE + DATA-MODEL = OUTPUT
````
Templates were written in the simple FreeMarker Template Language (FTL). FreeMarker displays the data which usually generated via 
general-purpose programming language (like Java) using the templates.
![freemkaer-flow](https://user-images.githubusercontent.com/36845597/90971412-94258f80-e52d-11ea-88c6-ab920729947f.jpg)

## FreeMaker Template Concepts
#### FTL Tags
Tags are instructions to FreeMarker and it won't rendered in output. The name of these tags & user-defined tags starts with # and @ respectively.
#### Directives
Instructions to FreeMarker used in templates. They are invoked by FTL tags.
````
<#list Games as game>...</#list>
<#import path_of_template as hash>
<#include path>
<#assign name=name_value type=type_value ... N>
````
Below are the types of Directives.<br>
> Predefined directive : Directive defined by FreeMarker. Example- if, list, include<br>
> User-defined directive : Directive that is defined by the user.

#### Expressions
#### Interpolation
#### Namespace
#### Node Variables
#### Object-Wrappers
#### Configurations
#### XML Processing

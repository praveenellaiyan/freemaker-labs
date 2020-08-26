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
### FTL Tags
Tags are instructions to FreeMarker and it won't rendered in output. The name of these tags & user-defined tags starts with # and @ respectively.
### [Directives](https://freemarker.apache.org/docs/ref_directives.html)
Instructions to FreeMarker used in templates. They are invoked by FTL tags.
````
<#list Games as game>...</#list>
<#import path_of_template as hash>
<#include path>
<#assign name=name_value type=type_value ... N>

<#macro mobile brand type>
  <p>${brand} does have ${type} model phone!</p>
</#macro>
<@mobile brand="nokia" type="gaming" />
````
Below are the types of Directives.<br>
> Predefined directive : Directive defined by FreeMarker. Example- if, list, include<br>
> User-defined directive : Directive that is defined by the user.

### [Expressions](https://freemarker.apache.org/docs/dgui_template_exp.html#exp_cheatsheet)
**Strings** String literals were enclosed in `'` or `"`. If at all string value contains quotes/braces etc then appropriate [escape sequence](https://freemarker.apache.org/docs/dgui_template_exp.html#dgui_template_exp_direct_string) is it should be used.
> "\"quoted\" text" OR '\"quoted\" text'

**[Numbers](https://freemarker.apache.org/docs/dgui_template_exp.html#dgui_template_exp_direct_string)** Numerical value represented without quoutes. Scientific notation is not supported yet.
> 0.5, -2, 7.9, -2.5

**[Booleans](https://freemarker.apache.org/docs/dgui_template_exp.html#dgui_template_exp_direct_boolean)** Boolean values are `true` or `false` and it should be represented without quotes.
> true, false

**[Sequences](https://freemarker.apache.org/docs/dgui_template_exp.html#dgui_template_exp_direct_seuqence)** Subvariables without have name separated by comma. It is enclosed in square brackets.
> ["bat", "ball", "ground"]

**[Ranges](https://freemarker.apache.org/docs/dgui_template_exp.html#dgui_template_exp_direct_ranges)** Ranges are like sequences, but they are created by specifying the range of whole numbers which it can contain. It is mainly used for iterating over numbers, slicing strings/sequences.
> <#assign cricket = ["bat", "ball", "ground", "audience"]> <br>
<#list cricket[0..1] as item>${item}</#list>

**[Hashes](https://freemarker.apache.org/docs/dgui_template_exp.html#dgui_template_exp_direct_hash)** Key/Value pairs separated by comma enclosed in curly braces `{}`. Keys must be string and value can be of any type.
> { "series": "Game of thrones", "favourite": "Drogon", "scenes": 10 }

**[Built-ins](https://freemarker.apache.org/docs/dgui_template_exp.html#dgui_template_exp_builtin)** Functions that are added to the objects. Templates doesn't depend on the type of the underlying objects is one of the pros of FreeMaker.
> player?upper_case <br> player?length <br> bowlers?size <br> player.keeper?string("Y", "N") <br> player?filter(it -> it.allrounder)

### Interpolation
Used to evaluate the expression and convert it to string. By default the result would be automatically converted if return type is number, date/time, date-time value. If return type is boolean/sequence etc., then result needs to be manually converted.
> ${expression} <br> ${IsBooelan?string("yes", "no")}.

### Namespace
A set of template-made variables like [function, macro etc] is called a namespace. Namespace is used to avoid accidental name conflicts.
> <#import "/lib/mobile.ftl" as m><br>
Mobile wholesale...<br>
<@m.mobile brand="nokia" type="gaming" />

#### Namespace Lifecycle
Namespace is identified by the path used in the import directive.
Multiple import will create the namespace and run the template for only the first invocation. Following imports are assigned the same namespace to the variable specified.
Each template processing job has its own private set of namespaces and exists only for the short period until main template is rendered.

#### Node Variables
#### Object-Wrappers
#### Configurations
#### XML Processing

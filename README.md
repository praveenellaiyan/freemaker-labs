# FREEMAKER TEMPLATE

## What is FreeMaker Template?
FreeMarker is a Java-based template engine focused on generation of dynamic web pages.

## Why FreeMaker Template?
- No dependency on servlets or HTTP or HTML.
- Supoorts various Template loaders.
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

### [Interpolation](https://freemarker.apache.org/docs/dgui_template_valueinsertion.html)
Used to evaluate the expression and convert it to string. By default the result would be automatically converted if return type is number, date/time, date-time value. If return type is boolean/sequence etc., then result needs to be manually converted.
> ${expression} <br> ${IsBooelan?string("yes", "no")}.

### [Namespace](https://freemarker.apache.org/docs/dgui_misc_namespace.html)
A set of template-made variables like [function, macro etc] is called a namespace. Namespace is used to avoid accidental name conflicts.
> <#import "/lib/mobile.ftl" as m><br>
Mobile wholesale...<br>
<@m.mobile brand="nokia" type="gaming" />

#### Namespace Lifecycle
Namespace is identified by the path used in the import directive.
Multiple import will create the namespace and run the template for only the first invocation. Following imports are assigned the same namespace to the variable specified.
Each template processing job has its own private set of namespaces and exists only for the short period until main template is rendered.

### [Object-Wrappers](https://freemarker.apache.org/docs/pgui_datamodel_objectWrapper.html)
Mapping between Java objects and FTL's type done by ObjectWrapper. By default the configuration setting for object wrapper is DefaultObjectWrapper and it address most basic java types like List, Map, Sting etc. For customisation it is recommed to implement wrapper functionality by extending DefaultObjectWrapper.

### [Configurations](https://freemarker.apache.org/docs/pgui_config.html)
Configuration deals with common global, application level settings, shared variables and creation and caching template instances.

**Settings** drives the behavior of freemaker. There are three layers of settings. Default will be from top most layer which is configuration and it can be overriden by subsequent layers template and environment.
|Level|Layer|
|---|---|
|1|Configuration|
|2|Template|
|3|Environment|

**Template Loaders** Responsible for loading ftl template provided abstract path like `/template/faq.ftl`. FreeMaker supports various types of template loaders, accordingly template will be located for rendering. This is also configured via configuration.
|Type|
|---|
|ClassTemplateLoader|
|FileTemplateLoader|
|StringTemplateLoader|
|URLTemplateLoader|
|WebappTemplateLoader|

**Error Handling** Exception could occur in certain scenario while configuration or loading template or IOExceptions. FreeMaker lets you to configure ExceptionHandling mechanism by defining custom implementation of TemplateExceptionHandler to handle runtime error gracefully. 

**Auto Escaping** By default template doesn't associated to any output format so no auto escaping is performed. However it can be configured provided `recognize_standard_file_extensions = true` via configuration so that auto-escaping is dealt accordingly.
|Extension|Output Format|
|---|---|
|.ftlh|HTML|
|.ftlx|XML|

### [XML Processing](https://freemarker.apache.org/docs/xgui.html)
Freemaker also supports transforming XML data into textual files [eg. HTML].

**[Node Variables](https://freemarker.apache.org/docs/pgui_datamodel_node.html)**
Represents node in a tree structure and primarily to handle XML documents. Node properties can be utilized either by methods of TemplateNodeModel `getChildNodes()`, `getChildNodes()` or node [built-ins](https://freemarker.apache.org/docs/ref_builtins_node.html) or visit & recurse macros.

There are two ways to process the XML
- [Imperative Processing](https://freemarker.apache.org/docs/xgui_imperative.html) - Define Freemaker template instance to traverse through different kind/level of nodes.
- [Declarative Processing](https://freemarker.apache.org/docs/xgui_declarative.html) - Define how to handle the different kind of nodes and then freemaker traverse the tree of different kinds. Vital in case of complex XML schema.


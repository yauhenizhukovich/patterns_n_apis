<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html
PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:app="java:com.gauss.forms.web.ApplicationContainer">
<head>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/colorscheme.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/form.pack.css">

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="robots" content="index, follow"/>
    <title>Oracle Web Forms :: BInitForm Form</title>
    <meta name="description"
          content="frevvo Live Forms Designer leverages Ajax technologies to create rich, dynamic forms without writing a single line of code. You can easily create amazing forms using just a web browser"/>
    <meta name="keywords"
          content="frevvo forms, web forms, online forms, html forms, business forms, forms builder, ajax forms builder, eforms, e-forms, live forms, forms processor, forms server"/>
    <meta id="frevvo.context" content="/frevvo"/>
</head>
<body id="page-form"
      class="frevvo-app print embed s-pilcrow "
      onKeyPress="return WindowUtil.disableEnter(event);">
<c:if test="${not empty bi}">
<div id="wrapper">
    <div id="container" class="clearfix">
        <table id="threecolumn" cellpadding="0" cellspacing="0" border="0">
            <tbody>
            <tr>
                <td id="left-cell" valign="top">
                    <div id="left" class="column">
                        <div id="left-content">
                            <div id="f-toolbox" class="f-toolbox"><input id="_hidden_focus_dude"
                                                                         style="position:absolute; left:-4000px;"/>
                            </div>
                        </div>
                        <div id="left-overlay" style="display:none"></div>
                    </div>
                </td>
                <td id="center-cell" valign="top">
                    <div id="center" class="column">
                        <div id="center-content" class="clearfix"><span style="display:none;"
                                                                        id="csrf.secret.key"></span>
                            <table id="form-container-table" cellspacing="0" cellpadding="0" border="0">
                                <tr>
                                    <td>
                                        <div id="form-container" ow="1200px" style="width:1200px"
                                             class="form-container s-locale-rus,ru   s-authenticated  s-print clearfix l-width-custom l-control-vertical s-printable   ">
                                            <div id="frevvo-form-header" class="f-form-header">
                                                <div id="f-form-use-warning" class="clearfix" style="display:none;">
                                                    <span></span></div>
                                                <div id="f-form-tb" class="f-form-tb s-prepend clearfix"><a href="#"
                                                                                                            title="Save this form"
                                                                                                            class="f-tb-save fontawesome icon-save"><span
                                                        id="f-form-tb-save-span">save</span></a><a
                                                        class="f-tb-print fontawesome icon-print"
                                                        target="_BKKe0CWlEeuNPa1IYPTRDw"
                                                        href="?print=true&amp;embed=true&amp;format=html"
                                                        title="Print this form"><span
                                                        id="f-form-tb-print-span">print</span></a><span
                                                        class="f-tb-status"></span><a class="f-tb-logout" href="#"
                                                                                      title="Logout"
                                                                                      style="display:none;"><span
                                                        id="f-form-tb-logout-span"></span></a></div>
                                            </div>
                                            <form id="3ec208ba-c61b-4323-bcd9-8ae8405c370e" method="post"
                                                  autocomplete="off"
                                                  class="f-form"
                                                  enctype="multipart/form-data"
                                                  style=""><input type="hidden" name="formAction"/><input
                                                    id="_referrer_url" type="hidden" name="_referrer_url"/><input
                                                    type="hidden" name="formTypeId" value="_BKKe0CWlEeuNPa1IYPTRDw"
                                                    disabled="disabled"/>
                                                <div id="h-form" class="h-form clearfix"><span
                                                        class="f-name">BInitForm</span><span class="f-description">Edit the form to change this description.</span><span
                                                        class="f-theme"></span><span class="f-form-controlLayout">vertical</span>
                                                </div>
                                                <div class="c-form clearfix">
                                                    <div class="f-control  f-group s-valid s-linked Group clearfix  s-expanded "
                                                         id="root-control"
                                                         extId="RootControl">
                                                        <div class="c-group clearfix">
                                                            <span class="f-info"
                                                                                            style="display:none;">Перетащите элементы управления из палитры в форму.</span>
                                                            <div class="f-control  f-section  s-valid  s-linked Section clearfix  s-expanded _BQESgSWlEeuNPa1IYPTRDw s-typed  s-not-signable "
                                                                 style=""
                                                                 id="_G24KACWlEeuNPa1IYPTRDw"
                                                                 extId="businessInitiative"
                                                                 cname="businessInitiative">
                                                                <div class="h-section clearfix s-not-expandable"
                                                                     title=""><span class="f-expand"></span><span
                                                                        class="f-add fontawesome icon-plus-sign"></span><span
                                                                        class="f-remove fontawesome icon-minus-sign"></span><span
                                                                        class="f-label" style="font-size:large;"><label><strong>Бизнес инициатива</strong></label><span
                                                                        class="f-required"></span><span
                                                                        class="f-help fontawesome icon-info-sign "></span><div
                                                                        class="f-helpcontent" style="display:none">
                                                                  <div class="c-helpcontent"></div>
                                                               </div></span><span class="f-status"
                                                                                  style="display:none;"><span>(n)</span></span>
                                                                </div>
                                                                  <div class="c-section clearfix"><span class="f-info"
                                                                                                      style="display:none;">Перетащите элементы управления из палитры или формы.</span>
                                                                    <div class="f-control  f-section  s-valid  s-linked Section clearfix  s-expanded _BQESgSWlEeuNPa1IYPTRDw s-typed  s-not-signable "
                                                                         style=""
                                                                         id="_G24KBCWlEeuNPa1IYPTRDw"
                                                                         extId="commonBlock"
                                                                         cname="commonBlock">
                                                                        <div class="h-section clearfix s-not-expandable"
                                                                             title=""><span
                                                                                class="f-expand"></span><span
                                                                                class="f-add fontawesome icon-plus-sign"></span><span
                                                                                class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                class="f-label" style=""><label><strong>Общее</strong></label><span
                                                                                class="f-required"></span><span
                                                                                class="f-help fontawesome icon-info-sign "></span><div
                                                                                class="f-helpcontent"
                                                                                style="display:none">
                                                                        <div class="c-helpcontent"></div>
                                                                     </div></span><span class="f-status"
                                                                                        style="display:none;"><span>(n)</span></span>
                                                                        </div>
                                                                        <div class="c-section clearfix"><span
                                                                                class="f-info" style="display:none;">Перетащите элементы управления из палитры или формы.</span>
                                                                            <div class="f-control Six columns  f-input  s-valid  s-linked Text  s-disabled _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                 style=""
                                                                                 id="_G24KCCWlEeuNPa1IYPTRDw"
                                                                                 extId="productDeveloperDept"
                                                                                 cname="productDeveloperDept"
                                                                                 title=""><span
                                                                                    class="f-add fontawesome icon-plus-sign"></span><span
                                                                                    class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                    class="f-label" style=""><label
                                                                                    for="w75044aab1b1b1b1">Подразделение-разработчик Продукта</label><span
                                                                                    class="f-required"></span><span
                                                                                    class="f-help fontawesome icon-info-sign "></span><div
                                                                                    class="f-helpcontent"
                                                                                    style="display:none">
                                                                           <div class="c-helpcontent"></div>
                                                                        </div></span>
                                                                                <aside class="decorator fontawesome icon-edit"></aside>
                                                                                <div class="decorator facade" style=""><pre
                                                                                        id="w75044aab1b1b1b1"
                                                                                        name="productDeveloperDept"
                                                                                        class="input wrap"
                                                                                        wrap="virtual"
                                                                                        style=""
                                                                                        type="text">security</pre>
                                                                                </div>
                                                                                <aside class="decorator fontawesome"></aside>
                                                                                <span class="f-status"
                                                                                      style="display:none;"><span>(n)</span></span>
                                                                            </div>
                                                                            <div class="f-control Six columns  f-input  s-valid  s-linked Text  s-disabled _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                 style=""
                                                                                 id="_G24KDiWlEeuNPa1IYPTRDw"
                                                                                 extId="biStatus"
                                                                                 cname="biStatus"
                                                                                 title=""><span
                                                                                    class="f-add fontawesome icon-plus-sign"></span><span
                                                                                    class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                    class="f-label" style=""><label
                                                                                    for="w75044aab1b1b1b2">Статус БИ</label><span
                                                                                    class="f-required"></span><span
                                                                                    class="f-help fontawesome icon-info-sign "></span><div
                                                                                    class="f-helpcontent"
                                                                                    style="display:none">
                                                                           <div class="c-helpcontent"></div>
                                                                        </div></span>
                                                                                <aside class="decorator fontawesome icon-edit"></aside>
                                                                                <div class="decorator facade" style=""><pre
                                                                                        id="w75044aab1b1b1b2"
                                                                                        name="biStatus"
                                                                                        class="input wrap"
                                                                                        wrap="virtual"
                                                                                        style=""
                                                                                        type="text">${bi.biStatus}</pre>
                                                                                </div>
                                                                                <aside class="decorator fontawesome"></aside>
                                                                                <span class="f-status"
                                                                                      style="display:none;"><span>(n)</span></span>
                                                                            </div>
                                                                            <div class="f-control Six columns  f-input  s-valid  s-linked Text  s-disabled _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                 style=""
                                                                                 id="_G24KCiWlEeuNPa1IYPTRDw"
                                                                                 extId="productDeveloperFIO"
                                                                                 cname="productDeveloperFIO"
                                                                                 title=""><span
                                                                                    class="f-add fontawesome icon-plus-sign"></span><span
                                                                                    class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                    class="f-label" style=""><label
                                                                                    for="w75044aab1b1b1b3">ФИО работника-разработчик Продукта</label><span
                                                                                    class="f-required"></span><span
                                                                                    class="f-help fontawesome icon-info-sign "></span><div
                                                                                    class="f-helpcontent"
                                                                                    style="display:none">
                                                                           <div class="c-helpcontent"></div>
                                                                        </div></span>
                                                                                <aside class="decorator fontawesome icon-edit"></aside>
                                                                                <div class="decorator facade" style=""><pre
                                                                                        id="w75044aab1b1b1b3"
                                                                                        name="productDeveloperFIO"
                                                                                        class="input wrap"
                                                                                        wrap="virtual"
                                                                                        style=""
                                                                                        type="text">${bi.productDeveloperFio}</pre>
                                                                                </div>
                                                                                <aside class="decorator fontawesome"></aside>
                                                                                <span class="f-status"
                                                                                      style="display:none;"><span>(n)</span></span>
                                                                            </div>
                                                                            <div class="f-control Three columns  f-input  s-valid  s-linked Date s-new-line _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                 style=""
                                                                                 id="_G24KDCWlEeuNPa1IYPTRDw"
                                                                                 extId="biDate"
                                                                                 cname="biDate"
                                                                                 title=""><span
                                                                                    class="f-add fontawesome icon-plus-sign"></span><span
                                                                                    class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                    class="f-label" style=""><label
                                                                                    for="w75044aab1b1b1b4">Дата создания БИ</label><span
                                                                                    class="f-required"></span><span
                                                                                    class="f-help fontawesome icon-info-sign "></span><div
                                                                                    class="f-helpcontent"
                                                                                    style="display:none">
                                                                           <div class="c-helpcontent"></div>
                                                                        </div></span>
                                                                                <div class="decorator facade" style=""><pre
                                                                                        id="w75044aab1b1b1b4"
                                                                                        name="biDate" class="input wrap"
                                                                                        wrap="virtual" style=""
                                                                                        type="text">${bi.biDate}</pre>
                                                                                </div>
                                                                                <span class="f-status"
                                                                                      style="display:none;"><span>(n)</span></span>
                                                                            </div>
                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Text _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                 style=""
                                                                                 id="_G24KBiWlEeuNPa1IYPTRDw"
                                                                                 extId="idBI"
                                                                                 cname="idBI"
                                                                                 title=""><span
                                                                                    class="f-add fontawesome icon-plus-sign"></span><span
                                                                                    class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                    class="f-label" style=""><label
                                                                                    for="w75044aab1b1b1b5">Id BI</label><span
                                                                                    class="f-required"></span><span
                                                                                    class="f-help fontawesome icon-info-sign "></span><div
                                                                                    class="f-helpcontent"
                                                                                    style="display:none">
                                                                           <div class="c-helpcontent"></div>
                                                                        </div></span>
                                                                                <aside class="decorator fontawesome icon-edit"></aside>
                                                                                <div class="decorator facade" style=""><pre
                                                                                        id="w75044aab1b1b1b5"
                                                                                        name="idBI" class="input wrap"
                                                                                        wrap="virtual" style=""
                                                                                        type="text">${bi.idBi}</pre>
                                                                                </div>
                                                                                <aside class="decorator fontawesome"></aside>
                                                                                <span class="f-status"
                                                                                      style="display:none;"><span>(n)</span></span>
                                                                            </div>
                                                                        </div>
                                                                        <div class="b-droppable clearfix"></div>
                                                                    </div>
                                                                    <div class="f-control  f-switch s-valid s-linked Tabs clearfix "
                                                                         style=""
                                                                         id="_06UBZSWlEeuNPa1IYPTRDw_06UBaSWlEeuNPa1IYPTRDw"
                                                                         cname="Tabs949">
                                                                        <div class="h-switch clearfix ">
                                                                            <div class="h-case  s-valid  s-linked clearfix   s-selected  s-first-tab "
                                                                                 style="width:15%;"
                                                                                 onclick="ch1()"

                                                                                 extId="part1"
                                                                                 title=""><span
                                                                                    class="f-add fontawesome icon-plus-sign"></span><span
                                                                                    class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                    class="f-expand"></span><span
                                                                                    class="f-label" style="color:blue;"><label><strong>Часть 1</strong></label><span
                                                                                    class="f-required"></span><span
                                                                                    class="f-help fontawesome icon-info-sign "></span><div
                                                                                    class="f-helpcontent"
                                                                                    style="display:none">
                                                                           <div class="c-helpcontent"></div>
                                                                        </div></span></div>
                                                                            <div class="h-case  s-valid  s-linked clearfix   s-selected  s-first-tab "
                                                                                 style="width:15%;"
                                                                                 onclick="oznakomlenie()"
                                                                                 extId="part1"
                                                                                 title=""><span
                                                                                    class="f-add fontawesome icon-plus-sign"></span><span
                                                                                    class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                    class="f-expand"></span><span
                                                                                    class="f-label" style="color:blue;"><label><strong>Ознакомление</strong></label><span
                                                                                    class="f-required"></span><span
                                                                                    class="f-help fontawesome icon-info-sign "></span><div
                                                                                    class="f-helpcontent"
                                                                                    style="display:none">
                                                                           <div class="c-helpcontent"></div>
                                                                        </div></span></div>
                                                                            <div class="h-case  s-valid  s-linked clearfix   s-selected  s-first-tab "
                                                                                 style="width:15%;"
                                                                                 onclick="ch2()"
                                                                                 extId="part1"
                                                                                 title=""><span
                                                                                    class="f-add fontawesome icon-plus-sign"></span><span
                                                                                    class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                    class="f-expand"></span><span
                                                                                    class="f-label" style="color:blue;"><label><strong>Часть 2</strong></label><span
                                                                                    class="f-required"></span><span
                                                                                    class="f-help fontawesome icon-info-sign "></span><div
                                                                                    class="f-helpcontent"
                                                                                    style="display:none">
                                                                           <div class="c-helpcontent"></div>
                                                                        </div></span></div>
                                                                            <div class="h-case  s-valid  s-linked clearfix   s-selected  s-first-tab "
                                                                                 style="width:15%;"
                                                                                 onclick="soglasovanieR()"
                                                                                 extId="part1"
                                                                                 title=""><span
                                                                                    class="f-add fontawesome icon-plus-sign"></span><span
                                                                                    class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                    class="f-expand"></span><span
                                                                                    class="f-label" style="color:blue;"><label><strong>Согласование Руков</strong></label><span
                                                                                    class="f-required"></span><span
                                                                                    class="f-help fontawesome icon-info-sign "></span><div
                                                                                    class="f-helpcontent"
                                                                                    style="display:none">
                                                                           <div class="c-helpcontent"></div>
                                                                        </div></span></div>
                                                                            <div class="h-case  s-valid  s-linked clearfix   s-selected  s-first-tab "
                                                                                 style="width:15%;"
                                                                                 onclick="soglasovanie()"
                                                                                 extId="part1"
                                                                                 title=""><span
                                                                                    class="f-add fontawesome icon-plus-sign"></span><span
                                                                                    class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                    class="f-expand"></span><span
                                                                                    class="f-label" style="color:blue;"><label><strong>Согласование</strong></label><span
                                                                                    class="f-required"></span><span
                                                                                    class="f-help fontawesome icon-info-sign "></span><div
                                                                                    class="f-helpcontent"
                                                                                    style="display:none">
                                                                           <div class="c-helpcontent"></div>
                                                                        </div></span></div>
                                                                            <div class="h-case  s-valid  s-linked clearfix   s-selected  s-first-tab "
                                                                                 style="width:15%;"
                                                                                 onclick="utverjdenie()"
                                                                                 extId="part1"
                                                                                 title=""><span
                                                                                    class="f-add fontawesome icon-plus-sign"></span><span
                                                                                    class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                    class="f-expand"></span><span
                                                                                    class="f-label" style="color:blue;"><label><strong>Утверждение</strong></label><span
                                                                                    class="f-required"></span><span
                                                                                    class="f-help fontawesome icon-info-sign "></span><div
                                                                                    class="f-helpcontent"
                                                                                    style="display:none">
                                                                           <div class="c-helpcontent"></div>
                                                                        </div></span></div>


                                                                        </div>
                                                                        <div class="c-switch" name="q" style="">

                                                                            <div  id="ch1" class="f-control  f-section  s-valid  s-linked Section clearfix  s-expanded _BQESgSWlEeuNPa1IYPTRDw s-typed  s-not-signable "
                                                                                     style=""

                                                                                     extId="biPart1"
                                                                                     cname="biPart1">
                                                                                    <div class="h-section clearfix s-not-expandable"
                                                                                         title=""><span
                                                                                            class="f-expand"></span><span
                                                                                            class="f-add fontawesome icon-plus-sign"></span><span
                                                                                            class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                            class="f-label"
                                                                                            style=""><label>Часть 1</label><span
                                                                                            class="f-required"></span><span
                                                                                            class="f-help fontawesome icon-info-sign "></span><div
                                                                                            class="f-helpcontent"
                                                                                            style="display:none">
                                                                                 <div class="c-helpcontent"></div>
                                                                              </div></span><span class="f-status"
                                                                                                 style="display:none;"><span>(n)</span></span>
                                                                                    </div>
                                                                                    <div class="c-section clearfix">
                                                                                        <span class="f-info"
                                                                                              style="display:none;">Перетащите элементы управления из палитры или формы.</span>
                                                                                        <div class="f-control Twelve columns  f-input  s-valid  s-linked Text _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                             style=""
                                                                                             id="_G24KECWlEeuNPa1IYPTRDw"
                                                                                             extId="biName"
                                                                                             cname="biName"
                                                                                             title=""><span
                                                                                                class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                class="f-label"
                                                                                                style=""><label
                                                                                                for="w75044aab1b1b2b1b1b1">Название бизнес-инициативы*</label><span
                                                                                                class="f-required"></span><span
                                                                                                class="f-help fontawesome icon-info-sign "></span><div
                                                                                                class="f-helpcontent"
                                                                                                style="display:none">
                                                                                    <div class="c-helpcontent"></div>
                                                                                 </div></span>
                                                                                            <aside class="decorator fontawesome icon-edit"></aside>
                                                                                            <div class="decorator facade"
                                                                                                 style=""><pre
                                                                                                    id="w75044aab1b1b2b1b1b1"
                                                                                                    name="biName"
                                                                                                    class="input wrap"
                                                                                                    wrap="virtual"
                                                                                                    style=""
                                                                                                    type="text">${bi.biName}</pre>
                                                                                            </div>
                                                                                            <aside class="decorator fontawesome"></aside>
                                                                                            <span class="f-status"
                                                                                                  style="display:none;"><span>(n)</span></span>
                                                                                        </div>
                                                                                        <div class="f-control Twelve columns  f-select1  s-valid  s-linked Radio  s-disabled _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                             style=""
                                                                                             id="_G24KEiWlEeuNPa1IYPTRDw"
                                                                                             extId="jobTypes"
                                                                                             cname="jobTypes"
                                                                                             title=""><span
                                                                                                class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                class="f-label"
                                                                                                style=""><label>Вид работ*</label><span
                                                                                                class="f-required"></span><span
                                                                                                class="f-help fontawesome icon-info-sign "></span><div
                                                                                                class="f-helpcontent"
                                                                                                style="display:none">
                                                                                    <div class="c-helpcontent"></div>
                                                                                 </div></span>
                                                                                            <fieldset class="facade "
                                                                                                      itemWidth="20%"
                                                                                                      style="">
                                                                                                <div class="f-select-item s-checked"
                                                                                                     style="width:20%;">
                                                                                                    <span class="radio-checkbox"><i
                                                                                                            class="fontawesome icon-circle"></i></span><span
                                                                                                        class="radio-checkbox-option">Разработка</span>
                                                                                                </div>
                                                                                                <div class="f-select-item "
                                                                                                     style="width:20%;">
                                                                                                    <span class="radio-checkbox"><i
                                                                                                            class="fontawesome icon-circle-blank"></i></span><span
                                                                                                        class="radio-checkbox-option">Модернизация</span>
                                                                                                </div>
                                                                                            </fieldset>
                                                                                            <span class="f-status"
                                                                                                  style="display:none;"><span>(n)</span></span>
                                                                                        </div>
                                                                                        <div class="f-control Twelve columns  f-textarea  s-valid  s-linked TextArea _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                             style=""
                                                                                             id="_G24KFCWlEeuNPa1IYPTRDw"
                                                                                             extId="biPoint"
                                                                                             cname="biPoint"
                                                                                             title=""><span
                                                                                                class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                class="f-label"
                                                                                                style=""><label
                                                                                                for="w75044aab1b1b2b1b1b3">Суть бизнес-инициативы*</label><span
                                                                                                class="f-required"></span><span
                                                                                                class="f-help fontawesome icon-info-sign "></span><div
                                                                                                class="f-helpcontent"
                                                                                                style="display:none">
                                                                                    <div class="c-helpcontent"></div>
                                                                                 </div></span>
                                                                                            <div class="decorator facade"
                                                                                                 style=""><pre
                                                                                                    id="w75044aab1b1b2b1b1b3"
                                                                                                    type="text"
                                                                                                    name="biPoint"
                                                                                                    wrap="virtual"
                                                                                                    class="textarea wrap"
                                                                                                    style=""></pre>
                                                                                            </div>
                                                                                            <span class="f-status"
                                                                                                  style="display:none;"><span>(n)</span></span>
                                                                                        </div>
                                                                                        <div class="f-control  f-section  s-valid  s-linked Section clearfix  s-expanded _BQESgSWlEeuNPa1IYPTRDw s-typed  s-not-signable "
                                                                                             style=""
                                                                                             id="_G24KFiWlEeuNPa1IYPTRDw"
                                                                                             extId="businessGoalsBlock"
                                                                                             cname="businessGoalsBlock">
                                                                                            <div class="h-section clearfix s-not-expandable"
                                                                                                 title=""><span
                                                                                                    class="f-expand"></span><span
                                                                                                    class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                    class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                    class="f-label"
                                                                                                    style=""><label>Бизнес-цели</label><span
                                                                                                    class="f-required"></span><span
                                                                                                    class="f-help fontawesome icon-info-sign "></span><div
                                                                                                    class="f-helpcontent"
                                                                                                    style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><span class="f-status"
                                                                                                       style="display:none;"><span>(n)</span></span>
                                                                                            </div>
                                                                                            <div class="c-section clearfix">
                                                                                                <span class="f-info"
                                                                                                      style="display:none;">Перетащите элементы управления из палитры или формы.</span>
                                                                                                <div class="f-control  f-table s-valid s-linked Table clearfix  s-expanded "
                                                                                                     style=""
                                                                                                     minOccurs="0"
                                                                                                     maxOccurs="32767"
                                                                                                     id="_G24KGCWlEeuNPa1IYPTRDw"
                                                                                                     extId="RepeatBusinessGoalsTable"
                                                                                                     cname="RepeatBusinessGoalsTable">
                                                                                                    <div class="h-table clearfix"
                                                                                                         title=""><span
                                                                                                            class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                            class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                            class="f-label"
                                                                                                            style=""><label>Repeat Business Goals</label><span
                                                                                                            class="f-required"></span><span
                                                                                                            class="f-help fontawesome icon-info-sign "></span><div
                                                                                                            class="f-helpcontent"
                                                                                                            style="display:none">
                                                                                             <div class="c-helpcontent"></div>
                                                                                          </div></span><span
                                                                                                            class="f-status"
                                                                                                            style="display:none;"><span>(n)</span></span>
                                                                                                    </div>
                                                                                                    <div class="c-table clearfix">
                                                                                                        <table border="0"
                                                                                                               cellpadding="0"
                                                                                                               cellspacing="0">
                                                                                                            <thead>
                                                                                                            <tr class="f-table-head"
                                                                                                                id="__maFxSWnEeuNPa1IYPTRDw">
                                                                                                                <th style=""
                                                                                                                    class="data-column f-table-column-head s-typed "
                                                                                                                    id="__maFyyWnEeuNPa1IYPTRDw"
                                                                                                                    title=""><span
                                                                                                                        class="f-label"
                                                                                                                        style=""><label>Наименование цели*</label><span
                                                                                                                        class="f-required"></span><span
                                                                                                                        class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                        class="f-helpcontent"
                                                                                                                        style="display:none">
                                                                                                         <div class="c-helpcontent"></div>
                                                                                                      </div></span></th>
                                                                                                            </tr>
                                                                                                            </thead>
                                                                                                            <tbody>
                                                                                                            <tr id="_G24KGSWlEeuNPa1IYPTRDw"
                                                                                                                class="f-table-row s-expanded s-linked s-typed"
                                                                                                                rcId="_G24KGCWlEeuNPa1IYPTRDw">
                                                                                                                <td valign="top"
                                                                                                                    class="data-column ">
                                                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                                                         style=""
                                                                                                                         id="_G24KGyWlEeuNPa1IYPTRDw"
                                                                                                                         extId="businessGoalsName"
                                                                                                                         rcId="_G24KGCWlEeuNPa1IYPTRDw"
                                                                                                                         cname="businessGoalsName"
                                                                                                                         title="">
                                                                                                                        <span class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                                            class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                                            class="f-label"
                                                                                                                            style=""><label
                                                                                                                            for="w75044aab1b1b2b1b1b4b1b1ab1">Наименование цели*</label><span
                                                                                                                            class="f-required"></span><span
                                                                                                                            class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                            class="f-helpcontent"
                                                                                                                            style="display:none">
                                                                                                            <div class="c-helpcontent"></div>
                                                                                                         </div></span>
                                                                                                                        <aside class="decorator fontawesome"></aside>
                                                                                                                        <div class="decorator facade"
                                                                                                                             style=""><pre
                                                                                                                                id="w75044aab1b1b2b1b1b4b1b1ab1"
                                                                                                                                name="businessGoalsName"
                                                                                                                                class="input wrap"
                                                                                                                                wrap="virtual"
                                                                                                                                style=""
                                                                                                                                type="text"><br/></pre>
                                                                                                                        </div>
                                                                                                                        <aside class="decorator fontawesome"></aside>
                                                                                                                        <span class="f-status"
                                                                                                                              style="display:none;"><span>(n)</span></span>
                                                                                                                    </div>
                                                                                                                </td>
                                                                                                            </tr>
                                                                                                            </tbody>
                                                                                                        </table>
                                                                                                        <span class="f-status f-table-status"
                                                                                                              style="display:none;"><span>(n)</span></span>
                                                                                                    </div>
                                                                                                    <div class="b-droppable clearfix"></div>
                                                                                                </div>
                                                                                            </div>
                                                                                            <div class="b-droppable clearfix"></div>
                                                                                        </div>
                                                                                        <div class="f-control  f-section  s-valid  s-linked Section clearfix  s-expanded _BQESgSWlEeuNPa1IYPTRDw s-typed  s-not-signable "
                                                                                             style=""
                                                                                             id="_G24KHSWlEeuNPa1IYPTRDw"
                                                                                             extId="businessDirectionBlock"
                                                                                             cname="businessDirectionBlock">
                                                                                            <div class="h-section clearfix s-not-expandable"
                                                                                                 title=""><span
                                                                                                    class="f-expand"></span><span
                                                                                                    class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                    class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                    class="f-label"
                                                                                                    style=""><label>Бизнес-направление</label><span
                                                                                                    class="f-required"></span><span
                                                                                                    class="f-help fontawesome icon-info-sign "></span><div
                                                                                                    class="f-helpcontent"
                                                                                                    style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><span class="f-status"
                                                                                                       style="display:none;"><span>(n)</span></span>
                                                                                            </div>
                                                                                            <div class="c-section clearfix">
                                                                                                <span class="f-info"
                                                                                                      style="display:none;">Перетащите элементы управления из палитры или формы.</span>
                                                                                                <div class="f-control  f-table s-valid s-linked Table clearfix  s-expanded "
                                                                                                     style=""
                                                                                                     minOccurs="0"
                                                                                                     maxOccurs="32767"
                                                                                                     id="_G24KHyWlEeuNPa1IYPTRDw"
                                                                                                     extId="BusinessDirectionTable"
                                                                                                     cname="BusinessDirectionTable">
                                                                                                    <div class="h-table clearfix"
                                                                                                         title=""><span
                                                                                                            class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                            class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                            class="f-label"
                                                                                                            style=""><label>Repeat Business Direction</label><span
                                                                                                            class="f-required"></span><span
                                                                                                            class="f-help fontawesome icon-info-sign "></span><div
                                                                                                            class="f-helpcontent"
                                                                                                            style="display:none">
                                                                                             <div class="c-helpcontent"></div>
                                                                                          </div></span><span
                                                                                                            class="f-status"
                                                                                                            style="display:none;"><span>(n)</span></span>
                                                                                                    </div>
                                                                                                    <div class="c-table clearfix">
                                                                                                        <table border="0"
                                                                                                               cellpadding="0"
                                                                                                               cellspacing="0">
                                                                                                            <thead>
                                                                                                            <tr class="f-table-head"
                                                                                                                id="_ed8akyWoEeuNPa1IYPTRDw">
                                                                                                                <th style=""
                                                                                                                    class="data-column f-table-column-head s-typed "
                                                                                                                    id="_ed9otCWoEeuNPa1IYPTRDw"
                                                                                                                    title=""><span
                                                                                                                        class="f-label"
                                                                                                                        style=""><label>Бизнес-направление*</label><span
                                                                                                                        class="f-required"></span><span
                                                                                                                        class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                        class="f-helpcontent"
                                                                                                                        style="display:none">
                                                                                                         <div class="c-helpcontent"></div>
                                                                                                      </div></span></th>
                                                                                                                <th style=""
                                                                                                                    class="data-column f-table-column-head s-typed "
                                                                                                                    id="_ed9ouiWoEeuNPa1IYPTRDw"
                                                                                                                    title=""><span
                                                                                                                        class="f-label"
                                                                                                                        style=""><label>Целевая аудитория*</label><span
                                                                                                                        class="f-required"></span><span
                                                                                                                        class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                        class="f-helpcontent"
                                                                                                                        style="display:none">
                                                                                                         <div class="c-helpcontent"></div>
                                                                                                      </div></span></th>
                                                                                                                <th style=""
                                                                                                                    class="data-column f-table-column-head s-typed "
                                                                                                                    id="_ed9owCWoEeuNPa1IYPTRDw"
                                                                                                                    title=""><span
                                                                                                                        class="f-label"
                                                                                                                        style=""><label>Вид деятельности*</label><span
                                                                                                                        class="f-required"></span><span
                                                                                                                        class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                        class="f-helpcontent"
                                                                                                                        style="display:none">
                                                                                                         <div class="c-helpcontent"></div>
                                                                                                      </div></span></th>
                                                                                                                <th style=""
                                                                                                                    class="data-column f-table-column-head s-typed "
                                                                                                                    id="_ed9oxiWoEeuNPa1IYPTRDw"
                                                                                                                    title=""><span
                                                                                                                        class="f-label"
                                                                                                                        style=""><label>Резиденство*</label><span
                                                                                                                        class="f-required"></span><span
                                                                                                                        class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                        class="f-helpcontent"
                                                                                                                        style="display:none">
                                                                                                         <div class="c-helpcontent"></div>
                                                                                                      </div></span></th>
                                                                                                            </tr>
                                                                                                            </thead>
                                                                                                            <tbody>
                                                                                                            <tr id="_G24KICWlEeuNPa1IYPTRDw"
                                                                                                                class="f-table-row s-expanded s-linked s-typed"
                                                                                                                rcId="_G24KHyWlEeuNPa1IYPTRDw">
                                                                                                                <td valign="top"
                                                                                                                    class="data-column ">
                                                                                                                    <div class="f-control Twelve columns  f-select1  s-valid  s-linked Dropdown _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                                                         style=""
                                                                                                                         id="_G24KLiWlEeuNPa1IYPTRDw"
                                                                                                                         extId="businessDirectionDrop"
                                                                                                                         rcId="_G24KHyWlEeuNPa1IYPTRDw"
                                                                                                                         cname="businessDirection"
                                                                                                                         title="">
                                                                                                                        <span class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                                            class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                                            class="f-label"
                                                                                                                            style=""><label>Бизнес-направление*</label><span
                                                                                                                            class="f-required"></span><span
                                                                                                                            class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                            class="f-helpcontent"
                                                                                                                            style="display:none">
                                                                                                            <div class="c-helpcontent"></div>
                                                                                                         </div></span>
                                                                                                                        <aside class="decorator fontawesome"></aside>
                                                                                                                        <div class="decorator facade"
                                                                                                                             style=""><pre
                                                                                                                                id="w75044aab1b1b2b1b1b5b1b1ab1"
                                                                                                                                name="businessDirection"
                                                                                                                                class="select wrap"
                                                                                                                                wrap="virtual"
                                                                                                                                style=""><br/></pre>
                                                                                                                        </div>
                                                                                                                        <aside class="decorator fontawesome"></aside>
                                                                                                                        <span class="f-status"
                                                                                                                              style="display:none;"><span>(n)</span></span>
                                                                                                                    </div>
                                                                                                                </td>
                                                                                                                <td valign="top"
                                                                                                                    class="data-column ">
                                                                                                                    <div class="f-control Twelve columns  f-select1  s-valid  s-linked Radio _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                                                         style=""
                                                                                                                         id="_G24KLCWlEeuNPa1IYPTRDw"
                                                                                                                         extId="choiseTargetAudience"
                                                                                                                         rcId="_G24KHyWlEeuNPa1IYPTRDw"
                                                                                                                         cname="choiseTargetAudience"
                                                                                                                         title="">
                                                                                                                        <span class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                                            class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                                            class="f-label"
                                                                                                                            style=""><label>Целевая аудитория*</label><span
                                                                                                                            class="f-required"></span><span
                                                                                                                            class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                            class="f-helpcontent"
                                                                                                                            style="display:none">
                                                                                                            <div class="c-helpcontent"></div>
                                                                                                         </div></span>
                                                                                                                        <fieldset
                                                                                                                                class="facade "
                                                                                                                                style="">
                                                                                                                            <div class="f-select-item ">
                                                                                                                                <span class="radio-checkbox"><i
                                                                                                                                        class="fontawesome icon-circle-blank"></i></span><span
                                                                                                                                    class="radio-checkbox-option">физ.</span>
                                                                                                                            </div>
                                                                                                                            <div class="f-select-item ">
                                                                                                                                <span class="radio-checkbox"><i
                                                                                                                                        class="fontawesome icon-circle-blank"></i></span><span
                                                                                                                                    class="radio-checkbox-option">юр.</span>
                                                                                                                            </div>
                                                                                                                        </fieldset>
                                                                                                                        <span class="f-status"
                                                                                                                              style="display:none;"><span>(n)</span></span>
                                                                                                                    </div>
                                                                                                                </td>
                                                                                                                <td valign="top"
                                                                                                                    class="data-column  s-disabled ">
                                                                                                                    <div class="f-control Twelve columns  f-select1  s-valid  s-linked Dropdown  s-disabled _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                                                         style=""
                                                                                                                         id="_G24KJiWlEeuNPa1IYPTRDw"
                                                                                                                         extId="activityKind"
                                                                                                                         rcId="_G24KHyWlEeuNPa1IYPTRDw"
                                                                                                                         cname="activityKind"
                                                                                                                         title="">
                                                                                                                        <span class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                                            class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                                            class="f-label"
                                                                                                                            style=""><label>Вид деятельности*</label><span
                                                                                                                            class="f-required"></span><span
                                                                                                                            class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                            class="f-helpcontent"
                                                                                                                            style="display:none">
                                                                                                            <div class="c-helpcontent"></div>
                                                                                                         </div></span>
                                                                                                                        <aside class="decorator fontawesome"></aside>
                                                                                                                        <div class="decorator facade"
                                                                                                                             style=""><pre
                                                                                                                                id="w75044aab1b1b2b1b1b5b1b1ab3"
                                                                                                                                name="activityKind"
                                                                                                                                class="select wrap"
                                                                                                                                wrap="virtual"
                                                                                                                                style=""><br/></pre>
                                                                                                                        </div>
                                                                                                                        <aside class="decorator fontawesome"></aside>
                                                                                                                        <span class="f-status"
                                                                                                                              style="display:none;"><span>(n)</span></span>
                                                                                                                    </div>
                                                                                                                </td>
                                                                                                                <td valign="top"
                                                                                                                    class="data-column  s-disabled ">
                                                                                                                    <div class="f-control Twelve columns  f-select1  s-valid  s-linked Radio  s-disabled _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                                                         style=""
                                                                                                                         id="_G24KKiWlEeuNPa1IYPTRDw"
                                                                                                                         extId="resident"
                                                                                                                         rcId="_G24KHyWlEeuNPa1IYPTRDw"
                                                                                                                         cname="resident"
                                                                                                                         title="">
                                                                                                                        <span class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                                            class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                                            class="f-label"
                                                                                                                            style=""><label>Резиденство*</label><span
                                                                                                                            class="f-required"></span><span
                                                                                                                            class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                            class="f-helpcontent"
                                                                                                                            style="display:none">
                                                                                                            <div class="c-helpcontent"></div>
                                                                                                         </div></span>
                                                                                                                        <fieldset
                                                                                                                                class="facade "
                                                                                                                                style="">
                                                                                                                            <div class="f-select-item ">
                                                                                                                                <span class="radio-checkbox"><i
                                                                                                                                        class="fontawesome icon-circle-blank"></i></span><span
                                                                                                                                    class="radio-checkbox-option">резидент</span>
                                                                                                                            </div>
                                                                                                                            <div class="f-select-item ">
                                                                                                                                <span class="radio-checkbox"><i
                                                                                                                                        class="fontawesome icon-circle-blank"></i></span><span
                                                                                                                                    class="radio-checkbox-option">не резидент</span>
                                                                                                                            </div>
                                                                                                                        </fieldset>
                                                                                                                        <span class="f-status"
                                                                                                                              style="display:none;"><span>(n)</span></span>
                                                                                                                    </div>
                                                                                                                </td>
                                                                                                            </tr>
                                                                                                            </tbody>
                                                                                                        </table>
                                                                                                        <span class="f-status f-table-status"
                                                                                                              style="display:none;"><span>(n)</span></span>
                                                                                                    </div>
                                                                                                    <div class="b-droppable clearfix"></div>
                                                                                                </div>
                                                                                            </div>
                                                                                            <div class="b-droppable clearfix"></div>
                                                                                        </div>
                                                                                        <div class="f-control Twelve columns  f-select1  s-valid  s-linked Dropdown _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                             style=""
                                                                                             id="_G24xECWlEeuNPa1IYPTRDw"
                                                                                             extId="product"
                                                                                             cname="product"
                                                                                             title=""><span
                                                                                                class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                class="f-label"
                                                                                                style=""><label>Продукт*</label><span
                                                                                                class="f-required"></span><span
                                                                                                class="f-help fontawesome icon-info-sign "></span><div
                                                                                                class="f-helpcontent"
                                                                                                style="display:none">
                                                                                    <div class="c-helpcontent"></div>
                                                                                 </div></span>
                                                                                            <aside class="decorator fontawesome icon-list"></aside>
                                                                                            <div class="decorator facade"
                                                                                                 style=""><pre
                                                                                                    id="w75044aab1b1b2b1b1b6"
                                                                                                    name="product"
                                                                                                    class="select wrap"
                                                                                                    wrap="virtual"
                                                                                                    style=""><br/></pre>
                                                                                            </div>
                                                                                            <aside class="decorator fontawesome"></aside>
                                                                                            <span class="f-status"
                                                                                                  style="display:none;"><span>(n)</span></span>
                                                                                        </div>
                                                                                        <div class="f-control Twelve columns  f-textarea  s-valid  s-linked TextArea _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                             style=""
                                                                                             id="_G24xEiWlEeuNPa1IYPTRDw"
                                                                                             extId="realizeProspective"
                                                                                             cname="realizeProspective"
                                                                                             title=""><span
                                                                                                class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                class="f-label"
                                                                                                style=""><label
                                                                                                for="w75044aab1b1b2b1b1b7">Перспективы (в случае реализации)*</label><span
                                                                                                class="f-required"></span><span
                                                                                                class="f-help fontawesome icon-info-sign "></span><div
                                                                                                class="f-helpcontent"
                                                                                                style="display:none">
                                                                                    <div class="c-helpcontent"></div>
                                                                                 </div></span>
                                                                                            <div class="decorator facade"
                                                                                                 style=""><pre
                                                                                                    id="w75044aab1b1b2b1b1b7"
                                                                                                    type="text"
                                                                                                    name="realizeProspective"
                                                                                                    wrap="virtual"
                                                                                                    class="textarea wrap"
                                                                                                    style="">${bi.realizeProspective}</pre>
                                                                                            </div>
                                                                                            <span class="f-status"
                                                                                                  style="display:none;"><span>(n)</span></span>
                                                                                        </div>
                                                                                        <div class="f-control Twelve columns  f-textarea  s-valid  s-linked TextArea _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                             style=""
                                                                                             id="_G24xFCWlEeuNPa1IYPTRDw"
                                                                                             extId="nonrealizeEffects"
                                                                                             cname="nonrealizeEffects"
                                                                                             title=""><span
                                                                                                class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                class="f-label"
                                                                                                style=""><label
                                                                                                for="w75044aab1b1b2b1b1b8">Последствия (в случае нереализации)*</label><span
                                                                                                class="f-required"></span><span
                                                                                                class="f-help fontawesome icon-info-sign "></span><div
                                                                                                class="f-helpcontent"
                                                                                                style="display:none">
                                                                                    <div class="c-helpcontent"></div>
                                                                                 </div></span>
                                                                                            <div class="decorator facade"
                                                                                                 style=""><pre
                                                                                                    id="w75044aab1b1b2b1b1b8"
                                                                                                    type="text"
                                                                                                    name="nonrealizeEffects"
                                                                                                    wrap="virtual"
                                                                                                    class="textarea wrap"
                                                                                                    style="">${bi.nonRealizeEffects}</pre>
                                                                                            </div>
                                                                                            <span class="f-status"
                                                                                                  style="display:none;"><span>(n)</span></span>
                                                                                        </div>
                                                                                        <div class="f-control Three columns  f-input  s-valid  s-linked Date _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                             style=""
                                                                                             id="_G24xFiWlEeuNPa1IYPTRDw"
                                                                                             extId="implPlanningDate"
                                                                                             cname="implPlanningDate"
                                                                                             title=""><span
                                                                                                class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                class="f-label"
                                                                                                style=""><label
                                                                                                for="w75044aab1b1b2b1b1b9">Планируемая дата внедрения*</label><span
                                                                                                class="f-required"></span><span
                                                                                                class="f-help fontawesome icon-info-sign "></span><div
                                                                                                class="f-helpcontent"
                                                                                                style="display:none">
                                                                                    <div class="c-helpcontent"></div>
                                                                                 </div></span>
                                                                                            <div class="decorator facade"
                                                                                                 style=""><pre
                                                                                                    id="w75044aab1b1b2b1b1b9"
                                                                                                    name="implPlanningDate"
                                                                                                    class="input wrap"
                                                                                                    wrap="virtual"
                                                                                                    style=""
                                                                                                    type="text">${bi.planGraphicDate}</pre>
                                                                                            </div>
                                                                                            <span class="f-status"
                                                                                                  style="display:none;"><span>(n)</span></span>
                                                                                        </div>
                                                                                        <div class="f-control  f-section  s-valid  s-linked Section clearfix  s-expanded _BQESgSWlEeuNPa1IYPTRDw s-typed  s-not-signable "
                                                                                             style=""
                                                                                             id="_G24xGCWlEeuNPa1IYPTRDw"
                                                                                             extId="salesChannelsBlock"
                                                                                             cname="salesChannelsBlock">
                                                                                            <div class="h-section clearfix s-not-expandable"
                                                                                                 title=""><span
                                                                                                    class="f-expand"></span><span
                                                                                                    class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                    class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                    class="f-label"
                                                                                                    style=""><label>Каналы продаж</label><span
                                                                                                    class="f-required"></span><span
                                                                                                    class="f-help fontawesome icon-info-sign "></span><div
                                                                                                    class="f-helpcontent"
                                                                                                    style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><span class="f-status"
                                                                                                       style="display:none;"><span>(n)</span></span>
                                                                                            </div>
                                                                                            <div class="c-section clearfix">
                                                                                                <span class="f-info"
                                                                                                      style="display:none;">Перетащите элементы управления из палитры или формы.</span>
                                                                                                <div class="f-control  f-table s-valid s-linked Table clearfix  s-expanded "
                                                                                                     style=""
                                                                                                     minOccurs="0"
                                                                                                     maxOccurs="32767"
                                                                                                     id="_G24xGiWlEeuNPa1IYPTRDw"
                                                                                                     extId="RepeatSalesChannelsRecsTable"
                                                                                                     cname="RepeatSalesChannelsRecsTable">
                                                                                                    <div class="h-table clearfix"
                                                                                                         title=""><span
                                                                                                            class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                            class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                            class="f-label"
                                                                                                            style=""><label>Repeat Sales Channels Recs</label><span
                                                                                                            class="f-required"></span><span
                                                                                                            class="f-help fontawesome icon-info-sign "></span><div
                                                                                                            class="f-helpcontent"
                                                                                                            style="display:none">
                                                                                             <div class="c-helpcontent"></div>
                                                                                          </div></span><span
                                                                                                            class="f-status"
                                                                                                            style="display:none;"><span>(n)</span></span>
                                                                                                    </div>
                                                                                                    <div class="c-table clearfix">
                                                                                                        <table border="0"
                                                                                                               cellpadding="0"
                                                                                                               cellspacing="0">
                                                                                                            <thead>
                                                                                                            <tr class="f-table-head"
                                                                                                                id="_v1qUWiWoEeuNPa1IYPTRDw">
                                                                                                                <th style=""
                                                                                                                    class="data-column f-table-column-head s-typed "
                                                                                                                    id="_v1qUYCWoEeuNPa1IYPTRDw"
                                                                                                                    title=""><span
                                                                                                                        class="f-label"
                                                                                                                        style=""><label>Каналы продаж*</label><span
                                                                                                                        class="f-required"></span><span
                                                                                                                        class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                        class="f-helpcontent"
                                                                                                                        style="display:none">
                                                                                                         <div class="c-helpcontent"></div>
                                                                                                      </div></span></th>
                                                                                                            </tr>
                                                                                                            </thead>
                                                                                                            <tbody>
                                                                                                            <tr id="_G24xGyWlEeuNPa1IYPTRDw"
                                                                                                                class="f-table-row s-expanded s-linked s-typed"
                                                                                                                rcId="_G24xGiWlEeuNPa1IYPTRDw">
                                                                                                                <td valign="top"
                                                                                                                    class="data-column ">
                                                                                                                    <div class="f-control Twelve columns  f-select1  s-valid  s-linked Dropdown _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                                                         style=""
                                                                                                                         id="_G24xHSWlEeuNPa1IYPTRDw"
                                                                                                                         extId="salesChannelsDrop"
                                                                                                                         rcId="_G24xGiWlEeuNPa1IYPTRDw"
                                                                                                                         cname="salesChannels"
                                                                                                                         title="">
                                                                                                                        <span class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                                            class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                                            class="f-label"
                                                                                                                            style=""><label>Каналы продаж*</label><span
                                                                                                                            class="f-required"></span><span
                                                                                                                            class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                            class="f-helpcontent"
                                                                                                                            style="display:none">
                                                                                                            <div class="c-helpcontent"></div>
                                                                                                         </div></span>
                                                                                                                        <aside class="decorator fontawesome"></aside>
                                                                                                                        <div class="decorator facade"
                                                                                                                             style=""><pre
                                                                                                                                id="w75044aab1b1b2b1b1c10b1b1ab1"
                                                                                                                                name="salesChannels"
                                                                                                                                class="select wrap"
                                                                                                                                wrap="virtual"
                                                                                                                                style=""><br/></pre>
                                                                                                                        </div>
                                                                                                                        <aside class="decorator fontawesome"></aside>
                                                                                                                        <span class="f-status"
                                                                                                                              style="display:none;"><span>(n)</span></span>
                                                                                                                    </div>
                                                                                                                </td>
                                                                                                            </tr>
                                                                                                            </tbody>
                                                                                                        </table>
                                                                                                        <span class="f-status f-table-status"
                                                                                                              style="display:none;"><span>(n)</span></span>
                                                                                                    </div>
                                                                                                    <div class="b-droppable clearfix"></div>
                                                                                                </div>
                                                                                            </div>
                                                                                            <div class="b-droppable clearfix"></div>
                                                                                        </div>
                                                                                        <div class="f-control Twelve columns  f-textarea  s-valid  s-linked TextArea _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                             style=""
                                                                                             id="_G24xHyWlEeuNPa1IYPTRDw"
                                                                                             extId="addInfo"
                                                                                             cname="addInfo"
                                                                                             title=""><span
                                                                                                class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                class="f-label"
                                                                                                style=""><label
                                                                                                for="w75044aab1b1b2b1b1c11">Дополнительная информация*</label><span
                                                                                                class="f-required"></span><span
                                                                                                class="f-help fontawesome icon-info-sign "></span><div
                                                                                                class="f-helpcontent"
                                                                                                style="display:none">
                                                                                    <div class="c-helpcontent"></div>
                                                                                 </div></span>
                                                                                            <div class="decorator facade"
                                                                                                 style=""><pre
                                                                                                    id="w75044aab1b1b2b1b1c11"
                                                                                                    type="text"
                                                                                                    name="addInfo"
                                                                                                    wrap="virtual"
                                                                                                    class="textarea wrap"
                                                                                                    style=""></pre>
                                                                                            </div>
                                                                                            <span class="f-status"
                                                                                                  style="display:none;"><span>(n)</span></span>
                                                                                        </div>
                                                                                    </div>
                                                                                    <div class="b-droppable clearfix"></div>
                                                                                </div>



                                                                            <div  hidden id="ch2"  class="f-control  f-section  s-valid  s-linked Section clearfix  s-expanded _BQESgSWlEeuNPa1IYPTRDw s-typed  s-not-signable "
                                                                                 style=""
                                                                                 extId="biPart2"
                                                                                 cname="biPart2">
                                                                                <div class="h-section clearfix s-not-expandable"
                                                                                     title=""><span
                                                                                        class="f-expand"></span><span
                                                                                        class="f-add fontawesome icon-plus-sign"></span><span
                                                                                        class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                        class="f-label"
                                                                                        style=""><label>Часть 2</label><span
                                                                                        class="f-required"></span><span
                                                                                        class="f-help fontawesome icon-info-sign "></span><div
                                                                                        class="f-helpcontent"
                                                                                        style="display:none">
                                                                                 <div class="c-helpcontent"></div>
                                                                              </div></span><span class="f-status"
                                                                                                 style="display:none;"><span>(n)</span></span>
                                                                                </div>
                                                                                <div class="c-section clearfix">
                                                                                        <span class="f-info"
                                                                                              style="display:none;">Перетащите элементы управления из палитры или формы.</span>
                                                                                    <div class="f-control  f-section  s-valid  s-linked Section clearfix  s-expanded _BQESgSWlEeuNPa1IYPTRDw s-typed  s-not-signable "
                                                                                         style=""
                                                                                         id="_G24xIyWlEeuNPa1IYPTRDw"
                                                                                         extId="infoSystemInfluenceBlock"
                                                                                         cname="infoSystemInfluenceBlock">
                                                                                        <div class="h-section clearfix s-not-expandable"
                                                                                             title=""><span
                                                                                                class="f-expand"></span><span
                                                                                                class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                class="f-label"
                                                                                                style=""><label>Влияние на информационные системы</label><span
                                                                                                class="f-required"></span><span
                                                                                                class="f-help fontawesome icon-info-sign "></span><div
                                                                                                class="f-helpcontent"
                                                                                                style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><span class="f-status"
                                                                                                       style="display:none;"><span>(n)</span></span>
                                                                                        </div>
                                                                                        <div class="c-section clearfix">
                                                                                                <span class="f-info"
                                                                                                      style="display:none;">Перетащите элементы управления из палитры или формы.</span>
                                                                                            <div class="f-control  f-table s-valid s-linked Table clearfix  s-expanded "
                                                                                                 style=""
                                                                                                 minOccurs="0"
                                                                                                 maxOccurs="32767"
                                                                                                 id="_G24xJSWlEeuNPa1IYPTRDw"
                                                                                                 extId="InfoSystemInfluenceTable"
                                                                                                 cname="InfoSystemInfluenceTable">
                                                                                                <div class="h-table clearfix"
                                                                                                     title=""><span
                                                                                                        class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                        class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                        class="f-label"
                                                                                                        style=""><label>Repeat Info System Influence</label><span
                                                                                                        class="f-required"></span><span
                                                                                                        class="f-help fontawesome icon-info-sign "></span><div
                                                                                                        class="f-helpcontent"
                                                                                                        style="display:none">
                                                                                             <div class="c-helpcontent"></div>
                                                                                          </div></span><span
                                                                                                        class="f-status"
                                                                                                        style="display:none;"><span>(n)</span></span>
                                                                                                </div>
                                                                                                <div class="c-table clearfix">
                                                                                                    <table border="0"
                                                                                                           cellpadding="0"
                                                                                                           cellspacing="0">
                                                                                                        <thead>
                                                                                                        <tr class="f-table-head"
                                                                                                            id="_Q5KKfCWpEeuNPa1IYPTRDw">
                                                                                                            <th style=""
                                                                                                                class="data-column f-table-column-head s-typed "
                                                                                                                id="_Q5KKgiWpEeuNPa1IYPTRDw"
                                                                                                                title=""><span
                                                                                                                    class="f-label"
                                                                                                                    style=""><label>Влияние на информационные системы*</label><span
                                                                                                                    class="f-required"></span><span
                                                                                                                    class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                    class="f-helpcontent"
                                                                                                                    style="display:none">
                                                                                                         <div class="c-helpcontent"></div>
                                                                                                      </div></span></th>
                                                                                                            <th style=""
                                                                                                                class="data-column f-table-column-head s-typed "
                                                                                                                id="_Q5KKiCWpEeuNPa1IYPTRDw"
                                                                                                                title=""><span
                                                                                                                    class="f-label"
                                                                                                                    style=""><label>Описание влияния*</label><span
                                                                                                                    class="f-required"></span><span
                                                                                                                    class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                    class="f-helpcontent"
                                                                                                                    style="display:none">
                                                                                                         <div class="c-helpcontent"></div>
                                                                                                      </div></span></th>
                                                                                                        </tr>
                                                                                                        </thead>
                                                                                                        <tbody>
                                                                                                        <tr id="_G24xJiWlEeuNPa1IYPTRDw"
                                                                                                            class="f-table-row s-expanded s-linked s-typed"
                                                                                                            rcId="_G24xJSWlEeuNPa1IYPTRDw">
                                                                                                            <td valign="top"
                                                                                                                class="data-column  s-disabled ">
                                                                                                                <div class="f-control Twelve columns  f-select1  s-valid  s-linked Dropdown  s-disabled _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                                                     style=""
                                                                                                                     id="_G24xKCWlEeuNPa1IYPTRDw"
                                                                                                                     extId="infoSystemInfluenceDrop"
                                                                                                                     rcId="_G24xJSWlEeuNPa1IYPTRDw"
                                                                                                                     cname="infoSystemInfluence"
                                                                                                                     title="">
                                                                                                                    <span class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                                        class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                                        class="f-label"
                                                                                                                        style=""><label>Влияние на информационные системы*</label><span
                                                                                                                        class="f-required"></span><span
                                                                                                                        class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                        class="f-helpcontent"
                                                                                                                        style="display:none">
                                                                                                            <div class="c-helpcontent"></div>
                                                                                                         </div></span>
                                                                                                                    <aside class="decorator fontawesome"></aside>
                                                                                                                    <div class="decorator facade"
                                                                                                                         style=""><pre
                                                                                                                            id="w75044aab1b1b2b3b1b1b1b1ab1"
                                                                                                                            name="infoSystemInfluence"
                                                                                                                            class="select wrap"
                                                                                                                            wrap="virtual"
                                                                                                                            style=""><br/></pre>
                                                                                                                    </div>
                                                                                                                    <aside class="decorator fontawesome"></aside>
                                                                                                                    <span class="f-status"
                                                                                                                          style="display:none;"><span>(n)</span></span>
                                                                                                                </div>
                                                                                                            </td>
                                                                                                            <td valign="top"
                                                                                                                class="data-column  s-disabled ">
                                                                                                                <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                                                     style=""
                                                                                                                     id="_G24xKiWlEeuNPa1IYPTRDw"
                                                                                                                     extId="influencedescription"
                                                                                                                     rcId="_G24xJSWlEeuNPa1IYPTRDw"
                                                                                                                     cname="influencedescription"
                                                                                                                     title="">
                                                                                                                    <span class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                                        class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                                        class="f-label"
                                                                                                                        style=""><label
                                                                                                                        for="w75044aab1b1b2b3b1b1b1b1ab2">Описание влияния*</label><span
                                                                                                                        class="f-required"></span><span
                                                                                                                        class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                        class="f-helpcontent"
                                                                                                                        style="display:none">
                                                                                                            <div class="c-helpcontent"></div>
                                                                                                         </div></span>
                                                                                                                    <aside class="decorator fontawesome"></aside>
                                                                                                                    <div class="decorator facade"
                                                                                                                         style=""><pre
                                                                                                                            id="w75044aab1b1b2b3b1b1b1b1ab2"
                                                                                                                            name="influencedescription"
                                                                                                                            class="input wrap"
                                                                                                                            wrap="virtual"
                                                                                                                            style=""
                                                                                                                            type="text"><br/></pre>
                                                                                                                    </div>
                                                                                                                    <aside class="decorator fontawesome"></aside>
                                                                                                                    <span class="f-status"
                                                                                                                          style="display:none;"><span>(n)</span></span>
                                                                                                                </div>
                                                                                                            </td>
                                                                                                        </tr>
                                                                                                        </tbody>
                                                                                                    </table>
                                                                                                    <span class="f-status f-table-status"
                                                                                                          style="display:none;"><span>(n)</span></span>
                                                                                                </div>
                                                                                                <div class="b-droppable clearfix"></div>
                                                                                            </div>
                                                                                        </div>
                                                                                        <div class="b-droppable clearfix"></div>
                                                                                    </div>
                                                                                    <div class="f-control  f-section  s-valid  s-linked Section clearfix  s-expanded _BQESgSWlEeuNPa1IYPTRDw s-typed  s-not-signable "
                                                                                         style=""
                                                                                         id="_G24xLCWlEeuNPa1IYPTRDw"
                                                                                         extId="ImplementationRisksBlock"
                                                                                         cname="ImplementationRisksBlock">
                                                                                        <div class="h-section clearfix s-not-expandable"
                                                                                             title=""><span
                                                                                                class="f-expand"></span><span
                                                                                                class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                class="f-label"
                                                                                                style=""><label>Риски</label><span
                                                                                                class="f-required"></span><span
                                                                                                class="f-help fontawesome icon-info-sign "></span><div
                                                                                                class="f-helpcontent"
                                                                                                style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><span class="f-status"
                                                                                                       style="display:none;"><span>(n)</span></span>
                                                                                        </div>
                                                                                        <div class="c-section clearfix">
                                                                                                <span class="f-info"
                                                                                                      style="display:none;">Перетащите элементы управления из палитры или формы.</span>
                                                                                            <div class="f-control  f-table s-valid s-linked Table clearfix  s-expanded "
                                                                                                 style=""
                                                                                                 minOccurs="0"
                                                                                                 maxOccurs="32767"
                                                                                                 id="_G24xLiWlEeuNPa1IYPTRDw"
                                                                                                 extId="RepeatImplementationRiskTable"
                                                                                                 cname="RepeatImplementationRiskTable">
                                                                                                <div class="h-table clearfix"
                                                                                                     title=""><span
                                                                                                        class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                        class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                        class="f-label"
                                                                                                        style=""><label>Repeat Implementation Risk</label><span
                                                                                                        class="f-required"></span><span
                                                                                                        class="f-help fontawesome icon-info-sign "></span><div
                                                                                                        class="f-helpcontent"
                                                                                                        style="display:none">
                                                                                             <div class="c-helpcontent"></div>
                                                                                          </div></span><span
                                                                                                        class="f-status"
                                                                                                        style="display:none;"><span>(n)</span></span>
                                                                                                </div>
                                                                                                <div class="c-table clearfix">
                                                                                                    <table border="0"
                                                                                                           cellpadding="0"
                                                                                                           cellspacing="0">
                                                                                                        <thead>
                                                                                                        <tr class="f-table-head"
                                                                                                            id="_bqx6FCWpEeuNPa1IYPTRDw">
                                                                                                            <th style=""
                                                                                                                class="data-column f-table-column-head s-typed "
                                                                                                                id="_bqx6GiWpEeuNPa1IYPTRDw"
                                                                                                                title=""><span
                                                                                                                    class="f-label"
                                                                                                                    style=""><label>Наименование риска*</label><span
                                                                                                                    class="f-required"></span><span
                                                                                                                    class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                    class="f-helpcontent"
                                                                                                                    style="display:none">
                                                                                                         <div class="c-helpcontent"></div>
                                                                                                      </div></span></th>
                                                                                                            <th style=""
                                                                                                                class="data-column f-table-column-head s-typed "
                                                                                                                id="_bqx6ICWpEeuNPa1IYPTRDw"
                                                                                                                title=""><span
                                                                                                                    class="f-label"
                                                                                                                    style=""><label>Вероятность возникновения*</label><span
                                                                                                                    class="f-required"></span><span
                                                                                                                    class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                    class="f-helpcontent"
                                                                                                                    style="display:none">
                                                                                                         <div class="c-helpcontent"></div>
                                                                                                      </div></span></th>
                                                                                                            <th style=""
                                                                                                                class="data-column f-table-column-head s-typed "
                                                                                                                id="_bqx6JiWpEeuNPa1IYPTRDw"
                                                                                                                title=""><span
                                                                                                                    class="f-label"
                                                                                                                    style=""><label>Стоп-факторы*</label><span
                                                                                                                    class="f-required"></span><span
                                                                                                                    class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                    class="f-helpcontent"
                                                                                                                    style="display:none">
                                                                                                         <div class="c-helpcontent"></div>
                                                                                                      </div></span></th>
                                                                                                            <th style=""
                                                                                                                class="data-column f-table-column-head s-typed "
                                                                                                                id="_bqx6LCWpEeuNPa1IYPTRDw"
                                                                                                                title=""><span
                                                                                                                    class="f-label"
                                                                                                                    style=""><label>Avalability</label><span
                                                                                                                    class="f-required"></span><span
                                                                                                                    class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                    class="f-helpcontent"
                                                                                                                    style="display:none">
                                                                                                         <div class="c-helpcontent"></div>
                                                                                                      </div></span></th>
                                                                                                        </tr>
                                                                                                        </thead>
                                                                                                        <tbody>
                                                                                                        <tr id="_G24xLyWlEeuNPa1IYPTRDw"
                                                                                                            class="f-table-row s-expanded s-linked s-typed"
                                                                                                            rcId="_G24xLiWlEeuNPa1IYPTRDw">
                                                                                                            <td valign="top"
                                                                                                                class="data-column  s-disabled ">
                                                                                                                <div class="f-control Twelve columns  f-select1  s-valid  s-linked Dropdown  s-disabled _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                                                     style=""
                                                                                                                     id="_G24xMSWlEeuNPa1IYPTRDw"
                                                                                                                     extId="riskName"
                                                                                                                     rcId="_G24xLiWlEeuNPa1IYPTRDw"
                                                                                                                     cname="riskName"
                                                                                                                     title="">
                                                                                                                    <span class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                                        class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                                        class="f-label"
                                                                                                                        style=""><label>Наименование риска*</label><span
                                                                                                                        class="f-required"></span><span
                                                                                                                        class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                        class="f-helpcontent"
                                                                                                                        style="display:none">
                                                                                                            <div class="c-helpcontent"></div>
                                                                                                         </div></span>
                                                                                                                    <aside class="decorator fontawesome"></aside>
                                                                                                                    <div class="decorator facade"
                                                                                                                         style=""><pre
                                                                                                                            id="w75044aab1b1b2b3b1b2b1b1ab1"
                                                                                                                            name="riskName"
                                                                                                                            class="select wrap"
                                                                                                                            wrap="virtual"
                                                                                                                            style=""><br/></pre>
                                                                                                                    </div>
                                                                                                                    <aside class="decorator fontawesome"></aside>
                                                                                                                    <span class="f-status"
                                                                                                                          style="display:none;"><span>(n)</span></span>
                                                                                                                </div>
                                                                                                            </td>
                                                                                                            <td valign="top"
                                                                                                                class="data-column  s-disabled ">
                                                                                                                <div class="f-control Twelve columns  f-select1  s-valid  s-linked Dropdown  s-disabled _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                                                     style=""
                                                                                                                     id="_G24xMyWlEeuNPa1IYPTRDw"
                                                                                                                     extId="occurProbability"
                                                                                                                     rcId="_G24xLiWlEeuNPa1IYPTRDw"
                                                                                                                     cname="occurProbability"
                                                                                                                     title="">
                                                                                                                    <span class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                                        class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                                        class="f-label"
                                                                                                                        style=""><label>Вероятность возникновения*</label><span
                                                                                                                        class="f-required"></span><span
                                                                                                                        class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                        class="f-helpcontent"
                                                                                                                        style="display:none">
                                                                                                            <div class="c-helpcontent"></div>
                                                                                                         </div></span>
                                                                                                                    <aside class="decorator fontawesome"></aside>
                                                                                                                    <div class="decorator facade"
                                                                                                                         style=""><pre
                                                                                                                            id="w75044aab1b1b2b3b1b2b1b1ab2"
                                                                                                                            name="occurProbability"
                                                                                                                            class="select wrap"
                                                                                                                            wrap="virtual"
                                                                                                                            style=""><br/></pre>
                                                                                                                    </div>
                                                                                                                    <aside class="decorator fontawesome"></aside>
                                                                                                                    <span class="f-status"
                                                                                                                          style="display:none;"><span>(n)</span></span>
                                                                                                                </div>
                                                                                                            </td>
                                                                                                            <td valign="top"
                                                                                                                class="data-column  s-disabled ">
                                                                                                                <div class="f-control Twelve columns  f-select1  s-valid  s-linked Dropdown  s-disabled _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                                                     style=""
                                                                                                                     id="_G24xNSWlEeuNPa1IYPTRDw"
                                                                                                                     extId="stopFactors"
                                                                                                                     rcId="_G24xLiWlEeuNPa1IYPTRDw"
                                                                                                                     cname="stopFactors_MinProp"
                                                                                                                     title="">
                                                                                                                    <span class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                                        class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                                        class="f-label"
                                                                                                                        style=""><label>Стоп-факторы*</label><span
                                                                                                                        class="f-required"></span><span
                                                                                                                        class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                        class="f-helpcontent"
                                                                                                                        style="display:none">
                                                                                                            <div class="c-helpcontent"></div>
                                                                                                         </div></span>
                                                                                                                    <aside class="decorator fontawesome"></aside>
                                                                                                                    <div class="decorator facade"
                                                                                                                         style=""><pre
                                                                                                                            id="w75044aab1b1b2b3b1b2b1b1ab3"
                                                                                                                            name="stopFactors_MinProp"
                                                                                                                            class="select wrap"
                                                                                                                            wrap="virtual"
                                                                                                                            style=""><br/></pre>
                                                                                                                    </div>
                                                                                                                    <aside class="decorator fontawesome"></aside>
                                                                                                                    <span class="f-status"
                                                                                                                          style="display:none;"><span>(n)</span></span>
                                                                                                                </div>
                                                                                                            </td>
                                                                                                            <td valign="top"
                                                                                                                class="data-column  s-disabled ">
                                                                                                                <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                                                     style=""
                                                                                                                     id="_G24xNyWlEeuNPa1IYPTRDw"
                                                                                                                     extId="avalability"
                                                                                                                     rcId="_G24xLiWlEeuNPa1IYPTRDw"
                                                                                                                     cname="avalability"
                                                                                                                     title="">
                                                                                                                    <span class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                                        class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                                        class="f-label"
                                                                                                                        style=""><label
                                                                                                                        for="w75044aab1b1b2b3b1b2b1b1ab4">Avalability</label><span
                                                                                                                        class="f-required"></span><span
                                                                                                                        class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                        class="f-helpcontent"
                                                                                                                        style="display:none">
                                                                                                            <div class="c-helpcontent"></div>
                                                                                                         </div></span>
                                                                                                                    <aside class="decorator fontawesome"></aside>
                                                                                                                    <div class="decorator facade"
                                                                                                                         style=""><pre
                                                                                                                            id="w75044aab1b1b2b3b1b2b1b1ab4"
                                                                                                                            name="avalability"
                                                                                                                            class="input wrap"
                                                                                                                            wrap="virtual"
                                                                                                                            style=""
                                                                                                                            type="text"><br/></pre>
                                                                                                                    </div>
                                                                                                                    <aside class="decorator fontawesome"></aside>
                                                                                                                    <span class="f-status"
                                                                                                                          style="display:none;"><span>(n)</span></span>
                                                                                                                </div>
                                                                                                            </td>
                                                                                                        </tr>
                                                                                                        </tbody>
                                                                                                    </table>
                                                                                                    <span class="f-status f-table-status"
                                                                                                          style="display:none;"><span>(n)</span></span>
                                                                                                </div>
                                                                                                <div class="b-droppable clearfix"></div>
                                                                                            </div>
                                                                                        </div>
                                                                                        <div class="b-droppable clearfix"></div>
                                                                                    </div>
                                                                                    <div class="f-control Twelve columns  f-textarea  s-valid  s-linked TextArea  s-disabled _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                         style=""
                                                                                         id="_G24xOSWlEeuNPa1IYPTRDw"
                                                                                         extId="marketAnalisys"
                                                                                         cname="marketAnalisys"
                                                                                         title=""><span
                                                                                            class="f-add fontawesome icon-plus-sign"></span><span
                                                                                            class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                            class="f-label"
                                                                                            style=""><label
                                                                                            for="w75044aab1b1b2b3b1b3">Анализ рынка*</label><span
                                                                                            class="f-required"></span><span
                                                                                            class="f-help fontawesome icon-info-sign "></span><div
                                                                                            class="f-helpcontent"
                                                                                            style="display:none">
                                                                                    <div class="c-helpcontent"></div>
                                                                                 </div></span>
                                                                                        <div class="decorator facade"
                                                                                             style=""><pre
                                                                                                id="w75044aab1b1b2b3b1b3"
                                                                                                type="text"
                                                                                                name="marketAnalisys"
                                                                                                wrap="virtual"
                                                                                                class="textarea wrap"
                                                                                                style="">${bi.marketAnalisys}</pre>
                                                                                        </div>
                                                                                        <span class="f-status"
                                                                                              style="display:none;"><span>(n)</span></span>
                                                                                    </div>
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                         style=""
                                                                                         id="_G24xOyWlEeuNPa1IYPTRDw"
                                                                                         extId="marketAnalisysFile"
                                                                                         cname="marketAnalisysFile"
                                                                                         title=""><span
                                                                                            class="f-add fontawesome icon-plus-sign"></span><span
                                                                                            class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                            class="f-label"
                                                                                            style=""><label
                                                                                            for="w75044aab1b1b2b3b1b4">Файл для анализа рынка</label><span
                                                                                            class="f-required"></span><span
                                                                                            class="f-help fontawesome icon-info-sign "></span><div
                                                                                            class="f-helpcontent"
                                                                                            style="display:none">
                                                                                    <div class="c-helpcontent"></div>
                                                                                 </div></span>
                                                                                        <aside class="decorator fontawesome icon-edit"></aside>
                                                                                        <div class="decorator facade"
                                                                                             style=""><pre
                                                                                                id="w75044aab1b1b2b3b1b4"
                                                                                                name="marketAnalisysFile"
                                                                                                class="input wrap"
                                                                                                wrap="virtual"
                                                                                                style=""
                                                                                                type="text">Отсутствует</pre>
                                                                                        </div>
                                                                                        <aside class="decorator fontawesome"></aside>
                                                                                        <span class="f-status"
                                                                                              style="display:none;"><span>(n)</span></span>
                                                                                    </div>
                                                                                    <div class="f-control Four columns  f-input  s-valid  s-linked Date  s-disabled _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                         style=""
                                                                                         id="_G24xPSWlEeuNPa1IYPTRDw"
                                                                                         extId="businessAppImplDate"
                                                                                         cname="businessAppImplDate"
                                                                                         title=""><span
                                                                                            class="f-add fontawesome icon-plus-sign"></span><span
                                                                                            class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                            class="f-label"
                                                                                            style=""><label
                                                                                            for="w75044aab1b1b2b3b1b5">Дата разработки бизнес-предложения*</label><span
                                                                                            class="f-required"></span><span
                                                                                            class="f-help fontawesome icon-info-sign "></span><div
                                                                                            class="f-helpcontent"
                                                                                            style="display:none">
                                                                                    <div class="c-helpcontent"></div>
                                                                                 </div></span>
                                                                                        <div class="decorator facade"
                                                                                             style=""><pre
                                                                                                id="w75044aab1b1b2b3b1b5"
                                                                                                name="businessAppImplDate"
                                                                                                class="input wrap"
                                                                                                wrap="virtual"
                                                                                                style=""
                                                                                                type="text"></pre>
                                                                                        </div>
                                                                                        <span class="f-status"
                                                                                              style="display:none;"><span>(n)</span></span>
                                                                                    </div>
                                                                                    <div class="f-control Four columns  f-input  s-valid  s-linked Date s-new-line  s-disabled _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                         style=""
                                                                                         id="_G24xPyWlEeuNPa1IYPTRDw"
                                                                                         extId="planGraphicDateMain"
                                                                                         cname="planGraphicDate"
                                                                                         title=""><span
                                                                                            class="f-add fontawesome icon-plus-sign"></span><span
                                                                                            class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                            class="f-label"
                                                                                            style=""><label
                                                                                            for="w75044aab1b1b2b3b1b6">Дата разработки Плана-графика*</label><span
                                                                                            class="f-required"></span><span
                                                                                            class="f-help fontawesome icon-info-sign "></span><div
                                                                                            class="f-helpcontent"
                                                                                            style="display:none">
                                                                                    <div class="c-helpcontent"></div>
                                                                                 </div></span>
                                                                                        <div class="decorator facade"
                                                                                             style=""><pre
                                                                                                id="w75044aab1b1b2b3b1b6"
                                                                                                name="planGraphicDate"
                                                                                                class="input wrap"
                                                                                                wrap="virtual"
                                                                                                style=""
                                                                                                type="text"></pre>
                                                                                        </div>
                                                                                        <span class="f-status"
                                                                                              style="display:none;"><span>(n)</span></span>
                                                                                    </div>
                                                                                    <div class="f-control  f-section  s-valid  s-linked Section clearfix  s-expanded _BQESgSWlEeuNPa1IYPTRDw s-typed  s-not-signable "
                                                                                         style=""
                                                                                         id="_G24xQSWlEeuNPa1IYPTRDw"
                                                                                         extId="projectedExpencesBlock"
                                                                                         cname="projectedExpencesBlock">
                                                                                        <div class="h-section clearfix s-not-expandable"
                                                                                             title=""><span
                                                                                                class="f-expand"></span><span
                                                                                                class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                class="f-label"
                                                                                                style=""><label>Расходы</label><span
                                                                                                class="f-required"></span><span
                                                                                                class="f-help fontawesome icon-info-sign "></span><div
                                                                                                class="f-helpcontent"
                                                                                                style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><span class="f-status"
                                                                                                       style="display:none;"><span>(n)</span></span>
                                                                                        </div>
                                                                                        <div class="c-section clearfix">
                                                                                                <span class="f-info"
                                                                                                      style="display:none;">Перетащите элементы управления из палитры или формы.</span>
                                                                                            <div class="f-control  f-table s-valid s-linked Table clearfix  s-expanded "
                                                                                                 style=""
                                                                                                 minOccurs="0"
                                                                                                 maxOccurs="32767"
                                                                                                 id="_G24xQyWlEeuNPa1IYPTRDw"
                                                                                                 extId="RepeatProjectedExpensesTable"
                                                                                                 cname="RepeatProjectedExpensesTable">
                                                                                                <div class="h-table clearfix"
                                                                                                     title=""><span
                                                                                                        class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                        class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                        class="f-label"
                                                                                                        style=""><label>Repeat Projected Expenses</label><span
                                                                                                        class="f-required"></span><span
                                                                                                        class="f-help fontawesome icon-info-sign "></span><div
                                                                                                        class="f-helpcontent"
                                                                                                        style="display:none">
                                                                                             <div class="c-helpcontent"></div>
                                                                                          </div></span><span
                                                                                                        class="f-status"
                                                                                                        style="display:none;"><span>(n)</span></span>
                                                                                                </div>
                                                                                                <div class="c-table clearfix">
                                                                                                    <table border="0"
                                                                                                           cellpadding="0"
                                                                                                           cellspacing="0">
                                                                                                        <thead>
                                                                                                        <tr class="f-table-head"
                                                                                                            id="_OVL8eiWqEeuNPa1IYPTRDw">
                                                                                                            <th style=""
                                                                                                                class="data-column f-table-column-head s-typed "
                                                                                                                id="_OVL8gCWqEeuNPa1IYPTRDw"
                                                                                                                title=""><span
                                                                                                                    class="f-label"
                                                                                                                    style=""><label>Расход*</label><span
                                                                                                                    class="f-required"></span><span
                                                                                                                    class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                    class="f-helpcontent"
                                                                                                                    style="display:none">
                                                                                                         <div class="c-helpcontent"></div>
                                                                                                      </div></span></th>
                                                                                                            <th style=""
                                                                                                                class="data-column f-table-column-head s-typed "
                                                                                                                id="_OVMjdSWqEeuNPa1IYPTRDw"
                                                                                                                title=""><span
                                                                                                                    class="f-label"
                                                                                                                    style=""><label>Размер*</label><span
                                                                                                                    class="f-required"></span><span
                                                                                                                    class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                    class="f-helpcontent"
                                                                                                                    style="display:none">
                                                                                                         <div class="c-helpcontent"></div>
                                                                                                      </div></span></th>
                                                                                                        </tr>
                                                                                                        </thead>
                                                                                                        <tbody>
                                                                                                        <tr id="_G24xRCWlEeuNPa1IYPTRDw"
                                                                                                            class="f-table-row s-expanded s-linked s-typed"
                                                                                                            rcId="_G24xQyWlEeuNPa1IYPTRDw">
                                                                                                            <td valign="top"
                                                                                                                class="data-column  s-disabled ">
                                                                                                                <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                                                     style=""
                                                                                                                     id="_G24xRiWlEeuNPa1IYPTRDw"
                                                                                                                     extId="expensesTypes"
                                                                                                                     rcId="_G24xQyWlEeuNPa1IYPTRDw"
                                                                                                                     cname="expensesTypes"
                                                                                                                     title="">
                                                                                                                    <span class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                                        class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                                        class="f-label"
                                                                                                                        style=""><label
                                                                                                                        for="w75044aab1b1b2b3b1b7b1b1ab1">Расход*</label><span
                                                                                                                        class="f-required"></span><span
                                                                                                                        class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                        class="f-helpcontent"
                                                                                                                        style="display:none">
                                                                                                            <div class="c-helpcontent"></div>
                                                                                                         </div></span>
                                                                                                                    <aside class="decorator fontawesome"></aside>
                                                                                                                    <div class="decorator facade"
                                                                                                                         style=""><pre
                                                                                                                            id="w75044aab1b1b2b3b1b7b1b1ab1"
                                                                                                                            name="expensesTypes"
                                                                                                                            class="input wrap"
                                                                                                                            wrap="virtual"
                                                                                                                            style=""
                                                                                                                            type="text"><br/></pre>
                                                                                                                    </div>
                                                                                                                    <aside class="decorator fontawesome"></aside>
                                                                                                                    <span class="f-status"
                                                                                                                          style="display:none;"><span>(n)</span></span>
                                                                                                                </div>
                                                                                                            </td>
                                                                                                            <td valign="top"
                                                                                                                class="data-column  s-disabled ">
                                                                                                                <div class="f-control Twelve columns  f-input  s-valid  s-linked Number  s-disabled _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                                                     style=""
                                                                                                                     id="_G24xSCWlEeuNPa1IYPTRDw"
                                                                                                                     extId="expencesSize"
                                                                                                                     rcId="_G24xQyWlEeuNPa1IYPTRDw"
                                                                                                                     cname="expencesSize"
                                                                                                                     title="">
                                                                                                                    <span class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                                        class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                                        class="f-label"
                                                                                                                        style=""><label
                                                                                                                        for="w75044aab1b1b2b3b1b7b1b1ab2">Размер*</label><span
                                                                                                                        class="f-required"></span><span
                                                                                                                        class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                        class="f-helpcontent"
                                                                                                                        style="display:none">
                                                                                                            <div class="c-helpcontent"></div>
                                                                                                         </div></span>
                                                                                                                    <aside class="decorator fontawesome"></aside>
                                                                                                                    <div class="decorator facade"
                                                                                                                         style=""><pre
                                                                                                                            id="w75044aab1b1b2b3b1b7b1b1ab2"
                                                                                                                            name="expencesSize"
                                                                                                                            class="input wrap"
                                                                                                                            wrap="virtual"
                                                                                                                            style=""
                                                                                                                            type="text"><br/></pre>
                                                                                                                    </div>
                                                                                                                    <aside class="decorator fontawesome"></aside>
                                                                                                                    <span class="f-status"
                                                                                                                          style="display:none;"><span>(n)</span></span>
                                                                                                                </div>
                                                                                                            </td>
                                                                                                        </tr>
                                                                                                        </tbody>
                                                                                                    </table>
                                                                                                    <span class="f-status f-table-status"
                                                                                                          style="display:none;"><span>(n)</span></span>
                                                                                                </div>
                                                                                                <div class="b-droppable clearfix"></div>
                                                                                            </div>
                                                                                        </div>
                                                                                        <div class="b-droppable clearfix"></div>
                                                                                    </div>
                                                                                    <div class="f-control  f-section  s-valid  s-linked Section clearfix  s-expanded _BQESgSWlEeuNPa1IYPTRDw s-typed  s-not-signable "
                                                                                         style=""
                                                                                         id="_G24xSiWlEeuNPa1IYPTRDw"
                                                                                         extId="productTeamBlock"
                                                                                         cname="productTeamBlock">
                                                                                        <div class="h-section clearfix s-not-expandable"
                                                                                             title=""><span
                                                                                                class="f-expand"></span><span
                                                                                                class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                class="f-label"
                                                                                                style=""><label>Продуктовая команда</label><span
                                                                                                class="f-required"></span><span
                                                                                                class="f-help fontawesome icon-info-sign "></span><div
                                                                                                class="f-helpcontent"
                                                                                                style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><span class="f-status"
                                                                                                       style="display:none;"><span>(n)</span></span>
                                                                                        </div>
                                                                                        <div class="c-section clearfix">
                                                                                                <span class="f-info"
                                                                                                      style="display:none;">Перетащите элементы управления из палитры или формы.</span>
                                                                                            <div class="f-control  f-table s-valid s-linked Table clearfix  s-expanded "
                                                                                                 style=""
                                                                                                 minOccurs="0"
                                                                                                 maxOccurs="32767"
                                                                                                 id="_G24xTCWlEeuNPa1IYPTRDw"
                                                                                                 extId="ProductTeamTable"
                                                                                                 cname="ProductTeamTable">
                                                                                                <div class="h-table clearfix"
                                                                                                     title=""><span
                                                                                                        class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                        class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                        class="f-label"
                                                                                                        style=""><label>Repeat Product Teams</label><span
                                                                                                        class="f-required"></span><span
                                                                                                        class="f-help fontawesome icon-info-sign "></span><div
                                                                                                        class="f-helpcontent"
                                                                                                        style="display:none">
                                                                                             <div class="c-helpcontent"></div>
                                                                                          </div></span><span
                                                                                                        class="f-status"
                                                                                                        style="display:none;"><span>(n)</span></span>
                                                                                                </div>
                                                                                                <div class="c-table clearfix">
                                                                                                    <table border="0"
                                                                                                           cellpadding="0"
                                                                                                           cellspacing="0">
                                                                                                        <thead>
                                                                                                        <tr class="f-table-head"
                                                                                                            id="_UybFsyWqEeuNPa1IYPTRDw">
                                                                                                            <th style=""
                                                                                                                class="data-column f-table-column-head s-typed "
                                                                                                                id="_UybFuSWqEeuNPa1IYPTRDw"
                                                                                                                title=""><span
                                                                                                                    class="f-label"
                                                                                                                    style=""><label>Структурное подразделение разработчика*</label><span
                                                                                                                    class="f-required"></span><span
                                                                                                                    class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                    class="f-helpcontent"
                                                                                                                    style="display:none">
                                                                                                         <div class="c-helpcontent"></div>
                                                                                                      </div></span></th>
                                                                                                            <th style=""
                                                                                                                class="data-column f-table-column-head s-typed "
                                                                                                                id="_UybsoCWqEeuNPa1IYPTRDw"
                                                                                                                title=""><span
                                                                                                                    class="f-label"
                                                                                                                    style=""><label>ФИО менеджера Продукта*</label><span
                                                                                                                    class="f-required"></span><span
                                                                                                                    class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                    class="f-helpcontent"
                                                                                                                    style="display:none">
                                                                                                         <div class="c-helpcontent"></div>
                                                                                                      </div></span></th>
                                                                                                            <th style=""
                                                                                                                class="data-column f-table-column-head s-typed "
                                                                                                                id="_UybspiWqEeuNPa1IYPTRDw"
                                                                                                                title=""><span
                                                                                                                    class="f-label"
                                                                                                                    style=""><label>Структурное подразделение члена проектной команды*</label><span
                                                                                                                    class="f-required"></span><span
                                                                                                                    class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                    class="f-helpcontent"
                                                                                                                    style="display:none">
                                                                                                         <div class="c-helpcontent"></div>
                                                                                                      </div></span></th>
                                                                                                            <th style=""
                                                                                                                class="data-column f-table-column-head s-typed "
                                                                                                                id="_UybsrCWqEeuNPa1IYPTRDw"
                                                                                                                title=""><span
                                                                                                                    class="f-label"
                                                                                                                    style=""><label>ФИО члена проектной команды*</label><span
                                                                                                                    class="f-required"></span><span
                                                                                                                    class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                    class="f-helpcontent"
                                                                                                                    style="display:none">
                                                                                                         <div class="c-helpcontent"></div>
                                                                                                      </div></span></th>
                                                                                                        </tr>
                                                                                                        </thead>
                                                                                                        <tbody>
                                                                                                        <tr id="_G24xTSWlEeuNPa1IYPTRDw"
                                                                                                            class="f-table-row s-expanded s-linked s-typed"
                                                                                                            rcId="_G24xTCWlEeuNPa1IYPTRDw">
                                                                                                            <td valign="top"
                                                                                                                class="data-column  s-disabled ">
                                                                                                                <div class="f-control Twelve columns  f-select1  s-valid  s-linked Dropdown  s-disabled _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                                                     style=""
                                                                                                                     id="_G24xTyWlEeuNPa1IYPTRDw"
                                                                                                                     extId="developDept"
                                                                                                                     rcId="_G24xTCWlEeuNPa1IYPTRDw"
                                                                                                                     cname="developDept"
                                                                                                                     title="">
                                                                                                                    <span class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                                        class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                                        class="f-label"
                                                                                                                        style=""><label>Структурное подразделение разработчика*</label><span
                                                                                                                        class="f-required"></span><span
                                                                                                                        class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                        class="f-helpcontent"
                                                                                                                        style="display:none">
                                                                                                            <div class="c-helpcontent"></div>
                                                                                                         </div></span>
                                                                                                                    <aside class="decorator fontawesome"></aside>
                                                                                                                    <div class="decorator facade"
                                                                                                                         style=""><pre
                                                                                                                            id="w75044aab1b1b2b3b1b8b1b1ab1"
                                                                                                                            name="developDept"
                                                                                                                            class="select wrap"
                                                                                                                            wrap="virtual"
                                                                                                                            style=""><br/></pre>
                                                                                                                    </div>
                                                                                                                    <aside class="decorator fontawesome"></aside>
                                                                                                                    <span class="f-status"
                                                                                                                          style="display:none;"><span>(n)</span></span>
                                                                                                                </div>
                                                                                                            </td>
                                                                                                            <td valign="top"
                                                                                                                class="data-column  s-disabled ">
                                                                                                                <div class="f-control Twelve columns  f-select1  s-valid  s-linked Dropdown  s-disabled _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                                                     style=""
                                                                                                                     id="_G24xUSWlEeuNPa1IYPTRDw"
                                                                                                                     extId="productManagerName"
                                                                                                                     rcId="_G24xTCWlEeuNPa1IYPTRDw"
                                                                                                                     cname="productManagerName"
                                                                                                                     title="">
                                                                                                                    <span class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                                        class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                                        class="f-label"
                                                                                                                        style=""><label>ФИО менеджера Продукта*</label><span
                                                                                                                        class="f-required"></span><span
                                                                                                                        class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                        class="f-helpcontent"
                                                                                                                        style="display:none">
                                                                                                            <div class="c-helpcontent"></div>
                                                                                                         </div></span>
                                                                                                                    <aside class="decorator fontawesome"></aside>
                                                                                                                    <div class="decorator facade"
                                                                                                                         style=""><pre
                                                                                                                            id="w75044aab1b1b2b3b1b8b1b1ab2"
                                                                                                                            name="productManagerName"
                                                                                                                            class="select wrap"
                                                                                                                            wrap="virtual"
                                                                                                                            style=""><br/></pre>
                                                                                                                    </div>
                                                                                                                    <aside class="decorator fontawesome"></aside>
                                                                                                                    <span class="f-status"
                                                                                                                          style="display:none;"><span>(n)</span></span>
                                                                                                                </div>
                                                                                                            </td>
                                                                                                            <td valign="top"
                                                                                                                class="data-column  s-disabled ">
                                                                                                                <div class="f-control Twelve columns  f-select1  s-valid  s-linked Dropdown  s-disabled _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                                                     style=""
                                                                                                                     id="_G24xUyWlEeuNPa1IYPTRDw"
                                                                                                                     extId="developMemberDept"
                                                                                                                     rcId="_G24xTCWlEeuNPa1IYPTRDw"
                                                                                                                     cname="developMemberDept"
                                                                                                                     title="">
                                                                                                                    <span class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                                        class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                                        class="f-label"
                                                                                                                        style=""><label>Структурное подразделение члена проектной команды*</label><span
                                                                                                                        class="f-required"></span><span
                                                                                                                        class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                        class="f-helpcontent"
                                                                                                                        style="display:none">
                                                                                                            <div class="c-helpcontent"></div>
                                                                                                         </div></span>
                                                                                                                    <aside class="decorator fontawesome"></aside>
                                                                                                                    <div class="decorator facade"
                                                                                                                         style=""><pre
                                                                                                                            id="w75044aab1b1b2b3b1b8b1b1ab3"
                                                                                                                            name="developMemberDept"
                                                                                                                            class="select wrap"
                                                                                                                            wrap="virtual"
                                                                                                                            style=""><br/></pre>
                                                                                                                    </div>
                                                                                                                    <aside class="decorator fontawesome"></aside>
                                                                                                                    <span class="f-status"
                                                                                                                          style="display:none;"><span>(n)</span></span>
                                                                                                                </div>
                                                                                                            </td>
                                                                                                            <td valign="top"
                                                                                                                class="data-column  s-disabled ">
                                                                                                                <div class="f-control Twelve columns  f-select1  s-valid  s-linked Dropdown  s-disabled _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                                                     style=""
                                                                                                                     id="_G24xVSWlEeuNPa1IYPTRDw"
                                                                                                                     extId="developMemberName"
                                                                                                                     rcId="_G24xTCWlEeuNPa1IYPTRDw"
                                                                                                                     cname="developMemberName"
                                                                                                                     title="">
                                                                                                                    <span class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                                        class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                                        class="f-label"
                                                                                                                        style=""><label>ФИО члена проектной команды*</label><span
                                                                                                                        class="f-required"></span><span
                                                                                                                        class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                        class="f-helpcontent"
                                                                                                                        style="display:none">
                                                                                                            <div class="c-helpcontent"></div>
                                                                                                         </div></span>
                                                                                                                    <aside class="decorator fontawesome"></aside>
                                                                                                                    <div class="decorator facade"
                                                                                                                         style=""><pre
                                                                                                                            id="w75044aab1b1b2b3b1b8b1b1ab4"
                                                                                                                            name="developMemberName"
                                                                                                                            class="select wrap"
                                                                                                                            wrap="virtual"
                                                                                                                            style=""><br/></pre>
                                                                                                                    </div>
                                                                                                                    <aside class="decorator fontawesome"></aside>
                                                                                                                    <span class="f-status"
                                                                                                                          style="display:none;"><span>(n)</span></span>
                                                                                                                </div>
                                                                                                            </td>
                                                                                                        </tr>
                                                                                                        </tbody>
                                                                                                    </table>
                                                                                                    <span class="f-status f-table-status"
                                                                                                          style="display:none;"><span>(n)</span></span>
                                                                                                </div>
                                                                                                <div class="b-droppable clearfix"></div>
                                                                                            </div>
                                                                                        </div>
                                                                                        <div class="b-droppable clearfix"></div>
                                                                                    </div>
                                                                                    <div class="f-control  f-section  s-valid  s-linked Section clearfix  s-expanded _BQESgSWlEeuNPa1IYPTRDw s-typed  s-not-signable "
                                                                                         style=""
                                                                                         id="_G24xVyWlEeuNPa1IYPTRDw"
                                                                                         extId="planGraphic"
                                                                                         cname="planGraphic">
                                                                                        <div class="h-section clearfix s-not-expandable"
                                                                                             title=""><span
                                                                                                class="f-expand"></span><span
                                                                                                class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                class="f-label"
                                                                                                style=""><label>План-график</label><span
                                                                                                class="f-required"></span><span
                                                                                                class="f-help fontawesome icon-info-sign "></span><div
                                                                                                class="f-helpcontent"
                                                                                                style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><span class="f-status"
                                                                                                       style="display:none;"><span>(n)</span></span>
                                                                                        </div>
                                                                                        <div class="c-section clearfix">
                                                                                                <span class="f-info"
                                                                                                      style="display:none;">Перетащите элементы управления из палитры или формы.</span>
                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                                 style=""
                                                                                                 id="_G25YICWlEeuNPa1IYPTRDw"
                                                                                                 extId="idPlanGraphic"
                                                                                                 cname="idPlanGraphic"
                                                                                                 title=""><span
                                                                                                    class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                    class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                    class="f-label"
                                                                                                    style=""><label
                                                                                                    for="w75044aab1b1b2b3b1b9b1">Id План-график</label><span
                                                                                                    class="f-required"></span><span
                                                                                                    class="f-help fontawesome icon-info-sign "></span><div
                                                                                                    class="f-helpcontent"
                                                                                                    style="display:none">
                                                                                          <div class="c-helpcontent"></div>
                                                                                       </div></span>
                                                                                                <aside class="decorator fontawesome icon-edit"></aside>
                                                                                                <div class="decorator facade"
                                                                                                     style=""><pre
                                                                                                        id="w75044aab1b1b2b3b1b9b1"
                                                                                                        name="idPlanGraphic"
                                                                                                        class="input wrap"
                                                                                                        wrap="virtual"
                                                                                                        style=""
                                                                                                        type="text"><br/></pre>
                                                                                                </div>
                                                                                                <aside class="decorator fontawesome"></aside>
                                                                                                <span class="f-status"
                                                                                                      style="display:none;"><span>(n)</span></span>
                                                                                            </div>
                                                                                            <div class="f-control Three columns  f-input  s-valid  s-linked Date  s-disabled _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                                 style=""
                                                                                                 id="_G25YIiWlEeuNPa1IYPTRDw"
                                                                                                 extId="planGraphicDate"
                                                                                                 cname="planGraphicDate"
                                                                                                 title=""><span
                                                                                                    class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                    class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                    class="f-label"
                                                                                                    style=""><label
                                                                                                    for="w75044aab1b1b2b3b1b9b2">Дата создания</label><span
                                                                                                    class="f-required"></span><span
                                                                                                    class="f-help fontawesome icon-info-sign "></span><div
                                                                                                    class="f-helpcontent"
                                                                                                    style="display:none">
                                                                                          <div class="c-helpcontent"></div>
                                                                                       </div></span>
                                                                                                <div class="decorator facade"
                                                                                                     style=""><pre
                                                                                                        id="w75044aab1b1b2b3b1b9b2"
                                                                                                        name="planGraphicDate"
                                                                                                        class="input wrap"
                                                                                                        wrap="virtual"
                                                                                                        style=""
                                                                                                        type="text"></pre>
                                                                                                </div>
                                                                                                <span class="f-status"
                                                                                                      style="display:none;"><span>(n)</span></span>
                                                                                            </div>
                                                                                            <div class="f-control  f-section  s-valid  s-linked Section clearfix  s-expanded _BQESgSWlEeuNPa1IYPTRDw s-typed  s-not-signable "
                                                                                                 style=""
                                                                                                 id="_G25YJCWlEeuNPa1IYPTRDw"
                                                                                                 extId="worksBlock"
                                                                                                 cname="worksBlock">
                                                                                                <div class="h-section clearfix s-not-expandable"
                                                                                                     title=""><span
                                                                                                        class="f-expand"></span><span
                                                                                                        class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                        class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                        class="f-label"
                                                                                                        style=""><label>Работы</label><span
                                                                                                        class="f-required"></span><span
                                                                                                        class="f-help fontawesome icon-info-sign "></span><div
                                                                                                        class="f-helpcontent"
                                                                                                        style="display:none">
                                                                                             <div class="c-helpcontent"></div>
                                                                                          </div></span><span
                                                                                                        class="f-status"
                                                                                                        style="display:none;"><span>(n)</span></span>
                                                                                                </div>
                                                                                                <div class="c-section clearfix">
                                                                                                        <span class="f-info"
                                                                                                              style="display:none;">Перетащите элементы управления из палитры или формы.</span>
                                                                                                    <div class="f-control  f-table s-valid s-linked Table clearfix  s-expanded "
                                                                                                         style=""
                                                                                                         minOccurs="0"
                                                                                                         maxOccurs="32767"
                                                                                                         id="_G25YJiWlEeuNPa1IYPTRDw"
                                                                                                         extId="WorksTable"
                                                                                                         cname="WorksTable">
                                                                                                        <div class="h-table clearfix"
                                                                                                             title="">
                                                                                                            <span class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                                class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                                class="f-label"
                                                                                                                style=""><label>Repeat Works</label><span
                                                                                                                class="f-required"></span><span
                                                                                                                class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                class="f-helpcontent"
                                                                                                                style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span><span class="f-status"
                                                                                                                   style="display:none;"><span>(n)</span></span>
                                                                                                        </div>
                                                                                                        <div class="c-table clearfix">
                                                                                                            <table border="0"
                                                                                                                   cellpadding="0"
                                                                                                                   cellspacing="0">
                                                                                                                <thead>
                                                                                                                <tr class="f-table-head"
                                                                                                                    id="_czZDtCWwEeuNPa1IYPTRDw">
                                                                                                                    <th style=""
                                                                                                                        class="data-column f-table-column-head s-typed "
                                                                                                                        id="_czZqtSWwEeuNPa1IYPTRDw"
                                                                                                                        title=""><span
                                                                                                                            class="f-label"
                                                                                                                            style=""><label>Id Works</label><span
                                                                                                                            class="f-required"></span><span
                                                                                                                            class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                            class="f-helpcontent"
                                                                                                                            style="display:none">
                                                                                                               <div class="c-helpcontent"></div>
                                                                                                            </div></span>
                                                                                                                    </th>
                                                                                                                    <th style=""
                                                                                                                        class="data-column f-table-column-head s-typed "
                                                                                                                        id="_czaRxSWwEeuNPa1IYPTRDw"
                                                                                                                        title=""><span
                                                                                                                            class="f-label"
                                                                                                                            style="font-size:x-small;"><label>п/п</label><span
                                                                                                                            class="f-required"></span><span
                                                                                                                            class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                            class="f-helpcontent"
                                                                                                                            style="display:none">
                                                                                                               <div class="c-helpcontent"></div>
                                                                                                            </div></span>
                                                                                                                    </th>
                                                                                                                    <th style=""
                                                                                                                        class="data-column f-table-column-head s-typed "
                                                                                                                        id="_czaRyyWwEeuNPa1IYPTRDw"
                                                                                                                        title=""><span
                                                                                                                            class="f-label"
                                                                                                                            style="font-size:x-small;"><label>Уровень вложенности (СДР)</label><span
                                                                                                                            class="f-required"></span><span
                                                                                                                            class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                            class="f-helpcontent"
                                                                                                                            style="display:none">
                                                                                                               <div class="c-helpcontent"></div>
                                                                                                            </div></span>
                                                                                                                    </th>
                                                                                                                    <th style=""
                                                                                                                        class="data-column f-table-column-head s-typed "
                                                                                                                        id="_czaR0SWwEeuNPa1IYPTRDw"
                                                                                                                        title=""><span
                                                                                                                            class="f-label"
                                                                                                                            style="font-size:x-small;"><label>Наименование мероприятия/ работы</label><span
                                                                                                                            class="f-required"></span><span
                                                                                                                            class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                            class="f-helpcontent"
                                                                                                                            style="display:none">
                                                                                                               <div class="c-helpcontent"></div>
                                                                                                            </div></span>
                                                                                                                    </th>
                                                                                                                    <th style=""
                                                                                                                        class="data-column f-table-column-head s-typed "
                                                                                                                        id="_czaR1yWwEeuNPa1IYPTRDw"
                                                                                                                        title=""><span
                                                                                                                            class="f-label"
                                                                                                                            style="font-size:x-small;"><label>Дата начала выполнения</label><span
                                                                                                                            class="f-required"></span><span
                                                                                                                            class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                            class="f-helpcontent"
                                                                                                                            style="display:none">
                                                                                                               <div class="c-helpcontent"></div>
                                                                                                            </div></span>
                                                                                                                    </th>
                                                                                                                    <th style=""
                                                                                                                        class="data-column f-table-column-head s-typed "
                                                                                                                        id="_czaR3SWwEeuNPa1IYPTRDw"
                                                                                                                        title=""><span
                                                                                                                            class="f-label"
                                                                                                                            style="font-size:x-small;"><label>Дата выполнения</label><span
                                                                                                                            class="f-required"></span><span
                                                                                                                            class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                            class="f-helpcontent"
                                                                                                                            style="display:none">
                                                                                                               <div class="c-helpcontent"></div>
                                                                                                            </div></span>
                                                                                                                    </th>
                                                                                                                    <th style=""
                                                                                                                        class="data-column f-table-column-head s-typed "
                                                                                                                        id="_czaR4yWwEeuNPa1IYPTRDw"
                                                                                                                        title=""><span
                                                                                                                            class="f-label"
                                                                                                                            style="font-size:x-small;"><label>Длительность, календарных дней</label><span
                                                                                                                            class="f-required"></span><span
                                                                                                                            class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                            class="f-helpcontent"
                                                                                                                            style="display:none">
                                                                                                               <div class="c-helpcontent"></div>
                                                                                                            </div></span>
                                                                                                                    </th>
                                                                                                                    <th style=""
                                                                                                                        class="data-column f-table-column-head s-typed "
                                                                                                                        id="_czaR6SWwEeuNPa1IYPTRDw"
                                                                                                                        title=""><span
                                                                                                                            class="f-label"
                                                                                                                            style="font-size:x-small;"><label>Предшественник</label><span
                                                                                                                            class="f-required"></span><span
                                                                                                                            class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                            class="f-helpcontent"
                                                                                                                            style="display:none">
                                                                                                               <div class="c-helpcontent"></div>
                                                                                                            </div></span>
                                                                                                                    </th>
                                                                                                                    <th style=""
                                                                                                                        class="data-column f-table-column-head s-typed "
                                                                                                                        id="_czaR7yWwEeuNPa1IYPTRDw"
                                                                                                                        title=""><span
                                                                                                                            class="f-label"
                                                                                                                            style="font-size:x-small;"><label>Наименование подразделения</label><span
                                                                                                                            class="f-required"></span><span
                                                                                                                            class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                            class="f-helpcontent"
                                                                                                                            style="display:none">
                                                                                                               <div class="c-helpcontent"></div>
                                                                                                            </div></span>
                                                                                                                    </th>
                                                                                                                    <th style=""
                                                                                                                        class="data-column f-table-column-head s-typed "
                                                                                                                        id="_czaR9SWwEeuNPa1IYPTRDw"
                                                                                                                        title=""><span
                                                                                                                            class="f-label"
                                                                                                                            style="font-size:x-small;"><label>Ответственный</label><span
                                                                                                                            class="f-required"></span><span
                                                                                                                            class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                            class="f-helpcontent"
                                                                                                                            style="display:none">
                                                                                                               <div class="c-helpcontent"></div>
                                                                                                            </div></span>
                                                                                                                    </th>
                                                                                                                    <th style=""
                                                                                                                        class="data-column f-table-column-head s-typed "
                                                                                                                        id="_czaR-yWwEeuNPa1IYPTRDw"
                                                                                                                        title=""><span
                                                                                                                            class="f-label"
                                                                                                                            style="font-size:x-small;"><label>Статус выполнения</label><span
                                                                                                                            class="f-required"></span><span
                                                                                                                            class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                            class="f-helpcontent"
                                                                                                                            style="display:none">
                                                                                                               <div class="c-helpcontent"></div>
                                                                                                            </div></span>
                                                                                                                    </th>
                                                                                                                    <th style=""
                                                                                                                        class="data-column f-table-column-head s-typed "
                                                                                                                        id="_czaSASWwEeuNPa1IYPTRDw"
                                                                                                                        title=""><span
                                                                                                                            class="f-label"
                                                                                                                            style="font-size:x-small;"><label>Процент готовности</label><span
                                                                                                                            class="f-required"></span><span
                                                                                                                            class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                            class="f-helpcontent"
                                                                                                                            style="display:none">
                                                                                                               <div class="c-helpcontent"></div>
                                                                                                            </div></span>
                                                                                                                    </th>
                                                                                                                    <th style=""
                                                                                                                        class="data-column f-table-column-head s-typed "
                                                                                                                        id="_czaSByWwEeuNPa1IYPTRDw"
                                                                                                                        title=""><span
                                                                                                                            class="f-label"
                                                                                                                            style="font-size:x-small;"><label>Комментарий</label><span
                                                                                                                            class="f-required"></span><span
                                                                                                                            class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                            class="f-helpcontent"
                                                                                                                            style="display:none">
                                                                                                               <div class="c-helpcontent"></div>
                                                                                                            </div></span>
                                                                                                                    </th>
                                                                                                                    <th style=""
                                                                                                                        class="data-column f-table-column-head s-typed "
                                                                                                                        id="_czaSDSWwEeuNPa1IYPTRDw"
                                                                                                                        title=""><span
                                                                                                                            class="f-label"
                                                                                                                            style="font-size:x-small;"><label>Планируемая дата запуска Продукта</label><span
                                                                                                                            class="f-required"></span><span
                                                                                                                            class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                            class="f-helpcontent"
                                                                                                                            style="display:none">
                                                                                                               <div class="c-helpcontent"></div>
                                                                                                            </div></span>
                                                                                                                    </th>
                                                                                                                    <th style=""
                                                                                                                        class="data-column f-table-column-head s-typed "
                                                                                                                        id="_czaSEyWwEeuNPa1IYPTRDw"
                                                                                                                        title=""><span
                                                                                                                            class="f-label"
                                                                                                                            style="font-size:x-small;"><label>Дата мониторинга готовности работы</label><span
                                                                                                                            class="f-required"></span><span
                                                                                                                            class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                            class="f-helpcontent"
                                                                                                                            style="display:none">
                                                                                                               <div class="c-helpcontent"></div>
                                                                                                            </div></span>
                                                                                                                    </th>
                                                                                                                    <th style=""
                                                                                                                        class="data-column f-table-column-head s-typed "
                                                                                                                        id="_czaSGSWwEeuNPa1IYPTRDw"
                                                                                                                        title=""><span
                                                                                                                            class="f-label"
                                                                                                                            style=""><label>Readiness Mon Freq</label><span
                                                                                                                            class="f-required"></span><span
                                                                                                                            class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                            class="f-helpcontent"
                                                                                                                            style="display:none">
                                                                                                               <div class="c-helpcontent"></div>
                                                                                                            </div></span>
                                                                                                                    </th>
                                                                                                                </tr>
                                                                                                                </thead>
                                                                                                                <tbody>
                                                                                                                <tr id="_G25YJyWlEeuNPa1IYPTRDw"
                                                                                                                    class="f-table-row s-expanded s-linked s-typed"
                                                                                                                    rcId="_G25YJiWlEeuNPa1IYPTRDw">
                                                                                                                    <td valign="top"
                                                                                                                        class="data-column  s-disabled ">
                                                                                                                        <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                                                             style=""
                                                                                                                             id="_G25YKSWlEeuNPa1IYPTRDw"
                                                                                                                             extId="idWorks"
                                                                                                                             rcId="_G25YJiWlEeuNPa1IYPTRDw"
                                                                                                                             cname="idWorks"
                                                                                                                             title="">
                                                                                                                            <span class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                                                class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                                                class="f-label"
                                                                                                                                style=""><label
                                                                                                                                for="w75044aab1b1b2b3b1b9b3b1b1ab1">Id Works</label><span
                                                                                                                                class="f-required"></span><span
                                                                                                                                class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                                class="f-helpcontent"
                                                                                                                                style="display:none">
                                                                                                                  <div class="c-helpcontent"></div>
                                                                                                               </div></span>
                                                                                                                            <aside class="decorator fontawesome"></aside>
                                                                                                                            <div class="decorator facade"
                                                                                                                                 style=""><pre
                                                                                                                                    id="w75044aab1b1b2b3b1b9b3b1b1ab1"
                                                                                                                                    name="idWorks"
                                                                                                                                    class="input wrap"
                                                                                                                                    wrap="virtual"
                                                                                                                                    style=""
                                                                                                                                    type="text"><br/></pre>
                                                                                                                            </div>
                                                                                                                            <aside class="decorator fontawesome"></aside>
                                                                                                                            <span class="f-status"
                                                                                                                                  style="display:none;"><span>(n)</span></span>
                                                                                                                        </div>
                                                                                                                    </td>
                                                                                                                    <td valign="top"
                                                                                                                        class="data-column  s-disabled ">
                                                                                                                        <div class="f-control Twelve columns  f-input  s-valid  s-linked Quantity  s-disabled _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                                                             style=""
                                                                                                                             id="_G25YKyWlEeuNPa1IYPTRDw"
                                                                                                                             extId="ppWorks"
                                                                                                                             rcId="_G25YJiWlEeuNPa1IYPTRDw"
                                                                                                                             cname="ppWorks"
                                                                                                                             title="">
                                                                                                                            <span class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                                                class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                                                class="f-label"
                                                                                                                                style=""><label
                                                                                                                                for="w75044aab1b1b2b3b1b9b3b1b1ab2">п/п</label><span
                                                                                                                                class="f-required"></span><span
                                                                                                                                class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                                class="f-helpcontent"
                                                                                                                                style="display:none">
                                                                                                                  <div class="c-helpcontent"></div>
                                                                                                               </div></span>
                                                                                                                            <aside class="decorator fontawesome"></aside>
                                                                                                                            <div class="decorator facade"
                                                                                                                                 style=""><pre
                                                                                                                                    id="w75044aab1b1b2b3b1b9b3b1b1ab2"
                                                                                                                                    name="ppWorks"
                                                                                                                                    class="input wrap"
                                                                                                                                    wrap="virtual"
                                                                                                                                    style=""
                                                                                                                                    type="text">1</pre>
                                                                                                                            </div>
                                                                                                                            <aside class="decorator fontawesome"></aside>
                                                                                                                            <span class="f-status"
                                                                                                                                  style="display:none;"><span>(n)</span></span>
                                                                                                                        </div>
                                                                                                                    </td>
                                                                                                                    <td valign="top"
                                                                                                                        class="data-column  s-disabled ">
                                                                                                                        <div class="f-control Twelve columns  f-input  s-valid  s-linked Quantity  s-disabled _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                                                             style=""
                                                                                                                             id="_G25YLSWlEeuNPa1IYPTRDw"
                                                                                                                             extId="nestingLevel"
                                                                                                                             rcId="_G25YJiWlEeuNPa1IYPTRDw"
                                                                                                                             cname="nestingLevel"
                                                                                                                             title="">
                                                                                                                            <span class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                                                class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                                                class="f-label"
                                                                                                                                style=""><label
                                                                                                                                for="w75044aab1b1b2b3b1b9b3b1b1ab3">Уровень вложенности (СДР)</label><span
                                                                                                                                class="f-required"></span><span
                                                                                                                                class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                                class="f-helpcontent"
                                                                                                                                style="display:none">
                                                                                                                  <div class="c-helpcontent"></div>
                                                                                                               </div></span>
                                                                                                                            <aside class="decorator fontawesome"></aside>
                                                                                                                            <div class="decorator facade"
                                                                                                                                 style=""><pre
                                                                                                                                    id="w75044aab1b1b2b3b1b9b3b1b1ab3"
                                                                                                                                    name="nestingLevel"
                                                                                                                                    class="input wrap"
                                                                                                                                    wrap="virtual"
                                                                                                                                    style=""
                                                                                                                                    type="text">1</pre>
                                                                                                                            </div>
                                                                                                                            <aside class="decorator fontawesome"></aside>
                                                                                                                            <span class="f-status"
                                                                                                                                  style="display:none;"><span>(n)</span></span>
                                                                                                                        </div>
                                                                                                                    </td>
                                                                                                                    <td valign="top"
                                                                                                                        class="data-column  s-disabled ">
                                                                                                                        <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                                                             style=""
                                                                                                                             id="_G25YLyWlEeuNPa1IYPTRDw"
                                                                                                                             extId="worksName"
                                                                                                                             rcId="_G25YJiWlEeuNPa1IYPTRDw"
                                                                                                                             cname="worksName"
                                                                                                                             title="">
                                                                                                                            <span class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                                                class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                                                class="f-label"
                                                                                                                                style=""><label
                                                                                                                                for="w75044aab1b1b2b3b1b9b3b1b1ab4">Наименование мероприятия/ работы</label><span
                                                                                                                                class="f-required"></span><span
                                                                                                                                class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                                class="f-helpcontent"
                                                                                                                                style="display:none">
                                                                                                                  <div class="c-helpcontent"></div>
                                                                                                               </div></span>
                                                                                                                            <aside class="decorator fontawesome"></aside>
                                                                                                                            <div class="decorator facade"
                                                                                                                                 style=""><pre
                                                                                                                                    id="w75044aab1b1b2b3b1b9b3b1b1ab4"
                                                                                                                                    name="worksName"
                                                                                                                                    class="input wrap"
                                                                                                                                    wrap="virtual"
                                                                                                                                    style=""
                                                                                                                                    type="text"><br/></pre>
                                                                                                                            </div>
                                                                                                                            <aside class="decorator fontawesome"></aside>
                                                                                                                            <span class="f-status"
                                                                                                                                  style="display:none;"><span>(n)</span></span>
                                                                                                                        </div>
                                                                                                                    </td>
                                                                                                                    <td valign="top"
                                                                                                                        class="data-column  s-disabled ">
                                                                                                                        <div class="f-control Twelve columns  f-input  s-valid  s-linked Date  s-disabled _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                                                             style=""
                                                                                                                             id="_G25YMSWlEeuNPa1IYPTRDw"
                                                                                                                             extId="worksDate"
                                                                                                                             rcId="_G25YJiWlEeuNPa1IYPTRDw"
                                                                                                                             cname="worksDate"
                                                                                                                             title="">
                                                                                                                            <span class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                                                class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                                                class="f-label"
                                                                                                                                style=""><label
                                                                                                                                for="w75044aab1b1b2b3b1b9b3b1b1ab5">Дата начала выполнения</label><span
                                                                                                                                class="f-required"></span><span
                                                                                                                                class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                                class="f-helpcontent"
                                                                                                                                style="display:none">
                                                                                                                  <div class="c-helpcontent"></div>
                                                                                                               </div></span>
                                                                                                                            <div class="decorator facade"
                                                                                                                                 style=""><pre
                                                                                                                                    id="w75044aab1b1b2b3b1b9b3b1b1ab5"
                                                                                                                                    name="worksDate"
                                                                                                                                    class="input wrap"
                                                                                                                                    wrap="virtual"
                                                                                                                                    style=""
                                                                                                                                    type="text"></pre>
                                                                                                                            </div>
                                                                                                                            <span class="f-status"
                                                                                                                                  style="display:none;"><span>(n)</span></span>
                                                                                                                        </div>
                                                                                                                    </td>
                                                                                                                    <td valign="top"
                                                                                                                        class="data-column  s-disabled ">
                                                                                                                        <div class="f-control Twelve columns  f-input  s-valid  s-linked Date  s-disabled _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                                                             style=""
                                                                                                                             id="_G25YMyWlEeuNPa1IYPTRDw"
                                                                                                                             extId="execDate"
                                                                                                                             rcId="_G25YJiWlEeuNPa1IYPTRDw"
                                                                                                                             cname="execDate"
                                                                                                                             title="">
                                                                                                                            <span class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                                                class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                                                class="f-label"
                                                                                                                                style=""><label
                                                                                                                                for="w75044aab1b1b2b3b1b9b3b1b1ab6">Дата выполнения</label><span
                                                                                                                                class="f-required"></span><span
                                                                                                                                class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                                class="f-helpcontent"
                                                                                                                                style="display:none">
                                                                                                                  <div class="c-helpcontent"></div>
                                                                                                               </div></span>
                                                                                                                            <div class="decorator facade"
                                                                                                                                 style=""><pre
                                                                                                                                    id="w75044aab1b1b2b3b1b9b3b1b1ab6"
                                                                                                                                    name="execDate"
                                                                                                                                    class="input wrap"
                                                                                                                                    wrap="virtual"
                                                                                                                                    style=""
                                                                                                                                    type="text"></pre>
                                                                                                                            </div>
                                                                                                                            <span class="f-status"
                                                                                                                                  style="display:none;"><span>(n)</span></span>
                                                                                                                        </div>
                                                                                                                    </td>
                                                                                                                    <td valign="top"
                                                                                                                        class="data-column  s-disabled ">
                                                                                                                        <div class="f-control Twelve columns  f-input  s-valid  s-linked Quantity  s-disabled _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                                                             style=""
                                                                                                                             id="_G25YNSWlEeuNPa1IYPTRDw"
                                                                                                                             extId="duration"
                                                                                                                             rcId="_G25YJiWlEeuNPa1IYPTRDw"
                                                                                                                             cname="duration"
                                                                                                                             title="">
                                                                                                                            <span class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                                                class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                                                class="f-label"
                                                                                                                                style=""><label
                                                                                                                                for="w75044aab1b1b2b3b1b9b3b1b1ab7">Длительность, календарных дней</label><span
                                                                                                                                class="f-required"></span><span
                                                                                                                                class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                                class="f-helpcontent"
                                                                                                                                style="display:none">
                                                                                                                  <div class="c-helpcontent"></div>
                                                                                                               </div></span>
                                                                                                                            <aside class="decorator fontawesome"></aside>
                                                                                                                            <div class="decorator facade"
                                                                                                                                 style=""><pre
                                                                                                                                    id="w75044aab1b1b2b3b1b9b3b1b1ab7"
                                                                                                                                    name="duration"
                                                                                                                                    class="input wrap"
                                                                                                                                    wrap="virtual"
                                                                                                                                    style=""
                                                                                                                                    type="text"><br/></pre>
                                                                                                                            </div>
                                                                                                                            <aside class="decorator fontawesome"></aside>
                                                                                                                            <span class="f-status"
                                                                                                                                  style="display:none;"><span>(n)</span></span>
                                                                                                                        </div>
                                                                                                                    </td>
                                                                                                                    <td valign="top"
                                                                                                                        class="data-column  s-disabled ">
                                                                                                                        <div class="f-control Twelve columns  f-input  s-valid  s-linked Quantity  s-disabled _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                                                             style=""
                                                                                                                             id="_G25YNyWlEeuNPa1IYPTRDw"
                                                                                                                             extId="ancestor"
                                                                                                                             rcId="_G25YJiWlEeuNPa1IYPTRDw"
                                                                                                                             cname="ancestor"
                                                                                                                             title="">
                                                                                                                            <span class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                                                class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                                                class="f-label"
                                                                                                                                style=""><label
                                                                                                                                for="w75044aab1b1b2b3b1b9b3b1b1ab8">Предшественник</label><span
                                                                                                                                class="f-required"></span><span
                                                                                                                                class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                                class="f-helpcontent"
                                                                                                                                style="display:none">
                                                                                                                  <div class="c-helpcontent"></div>
                                                                                                               </div></span>
                                                                                                                            <aside class="decorator fontawesome"></aside>
                                                                                                                            <div class="decorator facade"
                                                                                                                                 style=""><pre
                                                                                                                                    id="w75044aab1b1b2b3b1b9b3b1b1ab8"
                                                                                                                                    name="ancestor"
                                                                                                                                    class="input wrap"
                                                                                                                                    wrap="virtual"
                                                                                                                                    style=""
                                                                                                                                    type="text"><br/></pre>
                                                                                                                            </div>
                                                                                                                            <aside class="decorator fontawesome"></aside>
                                                                                                                            <span class="f-status"
                                                                                                                                  style="display:none;"><span>(n)</span></span>
                                                                                                                        </div>
                                                                                                                    </td>
                                                                                                                    <td valign="top"
                                                                                                                        class="data-column  s-disabled ">
                                                                                                                        <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                                                             style=""
                                                                                                                             id="_G25YOSWlEeuNPa1IYPTRDw"
                                                                                                                             extId="respDeptName"
                                                                                                                             rcId="_G25YJiWlEeuNPa1IYPTRDw"
                                                                                                                             cname="respDeptName"
                                                                                                                             title="">
                                                                                                                            <span class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                                                class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                                                class="f-label"
                                                                                                                                style=""><label
                                                                                                                                for="w75044aab1b1b2b3b1b9b3b1b1ab9">Наименование подразделения</label><span
                                                                                                                                class="f-required"></span><span
                                                                                                                                class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                                class="f-helpcontent"
                                                                                                                                style="display:none">
                                                                                                                  <div class="c-helpcontent"></div>
                                                                                                               </div></span>
                                                                                                                            <aside class="decorator fontawesome"></aside>
                                                                                                                            <div class="decorator facade"
                                                                                                                                 style=""><pre
                                                                                                                                    id="w75044aab1b1b2b3b1b9b3b1b1ab9"
                                                                                                                                    name="respDeptName"
                                                                                                                                    class="input wrap"
                                                                                                                                    wrap="virtual"
                                                                                                                                    style=""
                                                                                                                                    type="text"><br/></pre>
                                                                                                                            </div>
                                                                                                                            <aside class="decorator fontawesome"></aside>
                                                                                                                            <span class="f-status"
                                                                                                                                  style="display:none;"><span>(n)</span></span>
                                                                                                                        </div>
                                                                                                                    </td>
                                                                                                                    <td valign="top"
                                                                                                                        class="data-column  s-disabled ">
                                                                                                                        <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                                                             style=""
                                                                                                                             id="_G25YOyWlEeuNPa1IYPTRDw"
                                                                                                                             extId="respEmpName"
                                                                                                                             rcId="_G25YJiWlEeuNPa1IYPTRDw"
                                                                                                                             cname="respEmpName"
                                                                                                                             title="">
                                                                                                                            <span class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                                                class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                                                class="f-label"
                                                                                                                                style=""><label
                                                                                                                                for="w75044aab1b1b2b3b1b9b3b1b1ac10">Ответственный</label><span
                                                                                                                                class="f-required"></span><span
                                                                                                                                class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                                class="f-helpcontent"
                                                                                                                                style="display:none">
                                                                                                                  <div class="c-helpcontent"></div>
                                                                                                               </div></span>
                                                                                                                            <aside class="decorator fontawesome"></aside>
                                                                                                                            <div class="decorator facade"
                                                                                                                                 style=""><pre
                                                                                                                                    id="w75044aab1b1b2b3b1b9b3b1b1ac10"
                                                                                                                                    name="respEmpName"
                                                                                                                                    class="input wrap"
                                                                                                                                    wrap="virtual"
                                                                                                                                    style=""
                                                                                                                                    type="text"><br/></pre>
                                                                                                                            </div>
                                                                                                                            <aside class="decorator fontawesome"></aside>
                                                                                                                            <span class="f-status"
                                                                                                                                  style="display:none;"><span>(n)</span></span>
                                                                                                                        </div>
                                                                                                                    </td>
                                                                                                                    <td valign="top"
                                                                                                                        class="data-column  s-disabled ">
                                                                                                                        <div class="f-control Twelve columns  f-select1  s-valid  s-linked Dropdown  s-disabled _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                                                             style=""
                                                                                                                             id="_G25YPSWlEeuNPa1IYPTRDw"
                                                                                                                             extId="execStatus"
                                                                                                                             rcId="_G25YJiWlEeuNPa1IYPTRDw"
                                                                                                                             cname="execStatus"
                                                                                                                             title="">
                                                                                                                            <span class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                                                class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                                                class="f-label"
                                                                                                                                style=""><label>Статус выполнения</label><span
                                                                                                                                class="f-required"></span><span
                                                                                                                                class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                                class="f-helpcontent"
                                                                                                                                style="display:none">
                                                                                                                  <div class="c-helpcontent"></div>
                                                                                                               </div></span>
                                                                                                                            <aside class="decorator fontawesome"></aside>
                                                                                                                            <div class="decorator facade"
                                                                                                                                 style=""><pre
                                                                                                                                    id="w75044aab1b1b2b3b1b9b3b1b1ac11"
                                                                                                                                    name="execStatus"
                                                                                                                                    class="select wrap"
                                                                                                                                    wrap="virtual"
                                                                                                                                    style=""><br/></pre>
                                                                                                                            </div>
                                                                                                                            <aside class="decorator fontawesome"></aside>
                                                                                                                            <span class="f-status"
                                                                                                                                  style="display:none;"><span>(n)</span></span>
                                                                                                                        </div>
                                                                                                                    </td>
                                                                                                                    <td valign="top"
                                                                                                                        class="data-column  s-disabled ">
                                                                                                                        <div class="f-control Twelve columns  f-select1  s-valid  s-linked Dropdown  s-disabled _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                                                             style=""
                                                                                                                             id="_G25YPyWlEeuNPa1IYPTRDw"
                                                                                                                             extId="readinessPercentage"
                                                                                                                             rcId="_G25YJiWlEeuNPa1IYPTRDw"
                                                                                                                             cname="readinessPercentage"
                                                                                                                             title="">
                                                                                                                            <span class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                                                class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                                                class="f-label"
                                                                                                                                style=""><label>Процент готовности</label><span
                                                                                                                                class="f-required"></span><span
                                                                                                                                class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                                class="f-helpcontent"
                                                                                                                                style="display:none">
                                                                                                                  <div class="c-helpcontent"></div>
                                                                                                               </div></span>
                                                                                                                            <aside class="decorator fontawesome"></aside>
                                                                                                                            <div class="decorator facade"
                                                                                                                                 style=""><pre
                                                                                                                                    id="w75044aab1b1b2b3b1b9b3b1b1ac12"
                                                                                                                                    name="readinessPercentage"
                                                                                                                                    class="select wrap"
                                                                                                                                    wrap="virtual"
                                                                                                                                    style=""><br/></pre>
                                                                                                                            </div>
                                                                                                                            <aside class="decorator fontawesome"></aside>
                                                                                                                            <span class="f-status"
                                                                                                                                  style="display:none;"><span>(n)</span></span>
                                                                                                                        </div>
                                                                                                                    </td>
                                                                                                                    <td valign="top"
                                                                                                                        class="data-column  s-disabled ">
                                                                                                                        <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                                                             style=""
                                                                                                                             id="_G27NXCWlEeuNPa1IYPTRDw"
                                                                                                                             extId="comments"
                                                                                                                             rcId="_G25YJiWlEeuNPa1IYPTRDw"
                                                                                                                             cname="comments"
                                                                                                                             title="">
                                                                                                                            <span class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                                                class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                                                class="f-label"
                                                                                                                                style=""><label
                                                                                                                                for="w75044aab1b1b2b3b1b9b3b1b1ac13">Комментарий</label><span
                                                                                                                                class="f-required"></span><span
                                                                                                                                class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                                class="f-helpcontent"
                                                                                                                                style="display:none">
                                                                                                                  <div class="c-helpcontent"></div>
                                                                                                               </div></span>
                                                                                                                            <aside class="decorator fontawesome"></aside>
                                                                                                                            <div class="decorator facade"
                                                                                                                                 style=""><pre
                                                                                                                                    id="w75044aab1b1b2b3b1b9b3b1b1ac13"
                                                                                                                                    name="comments"
                                                                                                                                    class="input wrap"
                                                                                                                                    wrap="virtual"
                                                                                                                                    style=""
                                                                                                                                    type="text"><br/></pre>
                                                                                                                            </div>
                                                                                                                            <aside class="decorator fontawesome"></aside>
                                                                                                                            <span class="f-status"
                                                                                                                                  style="display:none;"><span>(n)</span></span>
                                                                                                                        </div>
                                                                                                                    </td>
                                                                                                                    <td valign="top"
                                                                                                                        class="data-column  s-disabled ">
                                                                                                                        <div class="f-control Twelve columns  f-input  s-valid  s-linked Date  s-disabled _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                                                             style=""
                                                                                                                             id="_G27NXiWlEeuNPa1IYPTRDw"
                                                                                                                             extId="plannedProdLaunchDate"
                                                                                                                             rcId="_G25YJiWlEeuNPa1IYPTRDw"
                                                                                                                             cname="plannedProdLaunchDate"
                                                                                                                             title="">
                                                                                                                            <span class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                                                class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                                                class="f-label"
                                                                                                                                style=""><label
                                                                                                                                for="w75044aab1b1b2b3b1b9b3b1b1ac14">Планируемая дата запуска Продукта</label><span
                                                                                                                                class="f-required"></span><span
                                                                                                                                class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                                class="f-helpcontent"
                                                                                                                                style="display:none">
                                                                                                                  <div class="c-helpcontent"></div>
                                                                                                               </div></span>
                                                                                                                            <div class="decorator facade"
                                                                                                                                 style=""><pre
                                                                                                                                    id="w75044aab1b1b2b3b1b9b3b1b1ac14"
                                                                                                                                    name="plannedProdLaunchDate"
                                                                                                                                    class="input wrap"
                                                                                                                                    wrap="virtual"
                                                                                                                                    style=""
                                                                                                                                    type="text">13.01.2021</pre>
                                                                                                                            </div>
                                                                                                                            <span class="f-status"
                                                                                                                                  style="display:none;"><span>(n)</span></span>
                                                                                                                        </div>
                                                                                                                    </td>
                                                                                                                    <td valign="top"
                                                                                                                        class="data-column  s-disabled ">
                                                                                                                        <div class="f-control Twelve columns  f-input  s-valid  s-linked Date  s-disabled _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                                                             style=""
                                                                                                                             id="_G27NYCWlEeuNPa1IYPTRDw"
                                                                                                                             extId="monitorReadyDate"
                                                                                                                             rcId="_G25YJiWlEeuNPa1IYPTRDw"
                                                                                                                             cname="monitorReadyDate"
                                                                                                                             title="">
                                                                                                                            <span class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                                                class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                                                class="f-label"
                                                                                                                                style=""><label
                                                                                                                                for="w75044aab1b1b2b3b1b9b3b1b1ac15">Дата мониторинга готовности работы</label><span
                                                                                                                                class="f-required"></span><span
                                                                                                                                class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                                class="f-helpcontent"
                                                                                                                                style="display:none">
                                                                                                                  <div class="c-helpcontent"></div>
                                                                                                               </div></span>
                                                                                                                            <div class="decorator facade"
                                                                                                                                 style=""><pre
                                                                                                                                    id="w75044aab1b1b2b3b1b9b3b1b1ac15"
                                                                                                                                    name="monitorReadyDate"
                                                                                                                                    class="input wrap"
                                                                                                                                    wrap="virtual"
                                                                                                                                    style=""
                                                                                                                                    type="text"></pre>
                                                                                                                            </div>
                                                                                                                            <span class="f-status"
                                                                                                                                  style="display:none;"><span>(n)</span></span>
                                                                                                                        </div>
                                                                                                                    </td>
                                                                                                                    <td valign="top"
                                                                                                                        class="data-column  s-disabled ">
                                                                                                                        <div class="f-control Twelve columns  f-input  s-valid  s-linked Quantity  s-disabled _BQESgSWlEeuNPa1IYPTRDw s-typed "
                                                                                                                             style=""
                                                                                                                             id="_G27NYiWlEeuNPa1IYPTRDw"
                                                                                                                             extId="readinessMonFreq"
                                                                                                                             rcId="_G25YJiWlEeuNPa1IYPTRDw"
                                                                                                                             cname="readinessMonFreq"
                                                                                                                             title="">
                                                                                                                            <span class="f-add fontawesome icon-plus-sign"></span><span
                                                                                                                                class="f-remove fontawesome icon-minus-sign"></span><span
                                                                                                                                class="f-label"
                                                                                                                                style=""><label
                                                                                                                                for="w75044aab1b1b2b3b1b9b3b1b1ac16">Readiness Mon Freq</label><span
                                                                                                                                class="f-required"></span><span
                                                                                                                                class="f-help fontawesome icon-info-sign "></span><div
                                                                                                                                class="f-helpcontent"
                                                                                                                                style="display:none">
                                                                                                                  <div class="c-helpcontent"></div>
                                                                                                               </div></span>
                                                                                                                            <aside class="decorator fontawesome"></aside>
                                                                                                                            <div class="decorator facade"
                                                                                                                                 style=""><pre
                                                                                                                                    id="w75044aab1b1b2b3b1b9b3b1b1ac16"
                                                                                                                                    name="readinessMonFreq"
                                                                                                                                    class="input wrap"
                                                                                                                                    wrap="virtual"
                                                                                                                                    style=""
                                                                                                                                    type="text"><br/></pre>
                                                                                                                            </div>
                                                                                                                            <aside class="decorator fontawesome"></aside>
                                                                                                                            <span class="f-status"
                                                                                                                                  style="display:none;"><span>(n)</span></span>
                                                                                                                        </div>
                                                                                                                    </td>
                                                                                                                </tr>
                                                                                                                </tbody>
                                                                                                            </table>
                                                                                                            <span class="f-status f-table-status"
                                                                                                                  style="display:none;"><span>(n)</span></span>
                                                                                                        </div>
                                                                                                        <div class="b-droppable clearfix"></div>
                                                                                                    </div>
                                                                                                </div>
                                                                                                <div class="b-droppable clearfix"></div>
                                                                                            </div>
                                                                                        </div>
                                                                                        <div class="b-droppable clearfix"></div>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="b-droppable clearfix"></div>
                                                                            </div>

                                                                            <div class="c-switch " style="">

                                                                                <div class="c-case clearfix "><span class="f-info" style="display:none;">Перетащите элементы управления из палитры или формы.</span>
                                                                                    <div class="f-control  f-section  s-valid  s-linked Section clearfix  s-expanded _BQESgSWlEeuNPa1IYPTRDw s-typed  s-not-signable " style="" id="_8jpMYCW0EeuNPa1IYPTRDw" extid="OnFamiliarize" cname="OnFamiliarize">
                                                                                        <div class="h-section clearfix s-not-expandable" title=""><span class="f-expand"></span><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label>Ознакомление</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                 <div class="c-helpcontent"></div>
                                                                              </div></span><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                        <div class="c-section clearfix"><span class="f-info" style="display:none;">Перетащите элементы управления из палитры или формы.</span><div class="f-control  f-table s-valid s-linked Table clearfix  s-expanded " style="" minoccurs="0" maxoccurs="32767" id="_8jpMYiW0EeuNPa1IYPTRDw" extid="OnFamiliarizeTable" cname="OnFamiliarizeTable">
                                                                                            <div class="h-table clearfix" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label>Repeat Record</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                            <div class="c-table clearfix">
                                                                                                <table border="0" cellpadding="0" cellspacing="0">
                                                                                                    <thead>
                                                                                                    <tr class="f-table-head s-valid" id="_eAXdLDiIEeuKZ_wCS8O7Zw">
                                                                                                        <th class="first-column data-not-column"></th>
                                                                                                        <th class="data-not-column"></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAZSSTiIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>Dev Phase</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_eAZ5VTiIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>Наименование подразделения*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_eAZ5WziIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>Должность*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_eAZ5YTiIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>ФИО*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAZ5ZziIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>DLG_ Emp Login</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAZ5bTiIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>Наименование подразделения*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAZ5cziIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>Должность*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAZ5eTiIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>ФИО*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAagZTiIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>Emp Login</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAagaziIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>Результат</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_eAagcTiIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>Срок ознакомления*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAagdziIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>Дата ознакомления</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_eAagfTiIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>Комментарий*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAaggziIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>DLG_ Id Dev</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAagiTiIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>DLG_ Result</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAagjziIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>DLG_ Date To</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAaglTiIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>DLG_ Date Nom</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAagmziIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>DLG_ Comment</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                    </tr>
                                                                                                    </thead>
                                                                                                    <tbody>
                                                                                                    <tr id="_8jpMYyW0EeuNPa1IYPTRDw" class="f-table-row s-expanded s-linked s-typed s-valid" rcid="_8jpMYiW0EeuNPa1IYPTRDw">
                                                                                                        <td class="add-column data-not-column"><span class="f-add fontawesome icon-plus-sign s-add"></span></td>
                                                                                                        <td class="remove-column data-not-column"><span class="f-remove fontawesome icon-minus-sign"></span></td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMZSW0EeuNPa1IYPTRDw" extid="DevPhaseOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DevPhase" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ab1">Dev Phase</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ab1" name="DevPhase" value="" class="input" autocorrect="off" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns  f-select1  s-valid  s-linked Dropdown _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMeSW0EeuNPa1IYPTRDw" extid="DLG_DeptNameOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DLG_DeptName" title=""><span class="f-label" style=""><label>Наименование подразделения*</label><span class="f-required"></span>&gt;</span><div class="f-helpcontent" style="display:none">
                                                                                                                <div class="c-helpcontent"></div>
                                                                                                            </div><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input class="input" readonly="readonly"><span class="fontawesome icon-caret-down"></span><ul><li><a ovalue=""></a></li><li><a ovalue="finance">finance</a></li><li><a ovalue="Develop">Develop</a></li><li><a ovalue="company">company</a></li><li><a ovalue="security">security</a></li><li><a ovalue="finance-developer">finance-developer</a></li><li><a ovalue="123">123</a></li></ul>
                                                                                                                </div>
                                                                                                                <aside class="decorator fontawesome"></aside><textarea rows="1" type="text" name="_8jpMeSW0EeuNPa1IYPTRDw_comment" wrap="virtual" class="textarea f-select-comment" style="display:none;"></textarea><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns  f-select1  s-valid  s-linked Dropdown _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMeyW0EeuNPa1IYPTRDw" extid="DLG_EmpPositionOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DLG_EmpPosition" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label>Должность*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input class="input" readonly="readonly"><ul>
                                                                                                                    <li><a class="fontawesome " href="#" ovalue=""></a></li>
                                                                                                                </ul>
                                                                                                                </div>
                                                                                                                <aside class="decorator fontawesome"></aside><textarea rows="1" type="text" name="_8jpMeyW0EeuNPa1IYPTRDw_comment" wrap="virtual" class="textarea f-select-comment" style="display:none;"></textarea><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns  f-select1  s-valid  s-linked Dropdown _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMfSW0EeuNPa1IYPTRDw" extid="DLG_EmpNameOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DLG_EmpName" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label>ФИО*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input class="input" readonly="readonly"><ul>
                                                                                                                    <li><a class="fontawesome " href="#" ovalue=""></a></li>
                                                                                                                </ul>
                                                                                                                </div>
                                                                                                                <aside class="decorator fontawesome"></aside><textarea rows="1" type="text" name="_8jpMfSW0EeuNPa1IYPTRDw_comment" wrap="virtual" class="textarea f-select-comment" style="display:none;"></textarea><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMfyW0EeuNPa1IYPTRDw" extid="DLG_EmpLoginOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DLG_EmpLogin" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ab5">DLG_ Emp Login</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ab5" name="DLG_EmpLogin" value="" class="input" autocorrect="off" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMZyW0EeuNPa1IYPTRDw" extid="DeptNameOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DeptName" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ab6">Наименование подразделения*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ab6" name="DeptName" value="" class="input" autocorrect="off" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMaSW0EeuNPa1IYPTRDw" extid="EmpPositionOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="EmpPosition" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ab7">Должность*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ab7" name="EmpPosition" value="" class="input" autocorrect="off" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMayW0EeuNPa1IYPTRDw" extid="EmpNameOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="EmpName" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ab8">ФИО*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ab8" name="EmpName" value="" class="input" autocorrect="off" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMbSW0EeuNPa1IYPTRDw" extid="EmpLoginOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="EmpLogin" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ab9">Emp Login</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ab9" name="EmpLogin" value="" class="input" autocorrect="off" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMbyW0EeuNPa1IYPTRDw" extid="ResultOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="Result" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ac10">Результат</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ac10" name="Result" value="" class="input" autocorrect="off" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Date _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMcSW0EeuNPa1IYPTRDw" extid="DateToOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DateTo" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ac11">Срок ознакомления*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><hr class="ie-date-time-hr">
                                                                                                                <aside class="decorator fontawesome icon-calendar-empty"></aside>
                                                                                                                <div class="decorator facade dtdt" style=""><input id="w29254aab1b1b2b2b1b1b1ac11" name="DateTo" value="" class="input f-date" style="" type=""></div>
                                                                                                                <div class="decorator facade dttm" style="display: none;"><input name="DateTo-time" value="" class="input f-time" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome icon-time"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Date  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMcyW0EeuNPa1IYPTRDw" extid="DateNomOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DateNom" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ac12">Дата ознакомления</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><hr class="ie-date-time-hr">
                                                                                                                <aside class="decorator fontawesome icon-calendar-empty"></aside>
                                                                                                                <div class="decorator facade dtdt" style=""><input id="w29254aab1b1b2b2b1b1b1ac12" name="DateNom" value="" class="input f-date" style="" type=""><span class="f-calendar fontawesome icon-calendar"></span></div>
                                                                                                                <div class="decorator facade dttm" style="display: none;"><input name="DateNom-time" value="" class="input f-time" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome icon-time"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_8jpMdSW0EeuNPa1IYPTRDw" extid="CommentOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="Comment" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ac13">Комментарий*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ac13" name="Comment" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMdyW0EeuNPa1IYPTRDw" extid="DLG_IdDevOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DLG_IdDev" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ac14">DLG_ Id Dev</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ac14" name="DLG_IdDev" value="" class="input" autocorrect="off" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMgSW0EeuNPa1IYPTRDw" extid="DLG_ResultOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DLG_Result" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ac15">DLG_ Result</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ac15" name="DLG_Result" value="" class="input" autocorrect="off" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Date  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMgyW0EeuNPa1IYPTRDw" extid="DLG_DateToOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DLG_DateTo" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ac16">DLG_ Date To</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><hr class="ie-date-time-hr">
                                                                                                                <aside class="decorator fontawesome icon-calendar-empty"></aside>
                                                                                                                <div class="decorator facade dtdt" style=""><input id="w29254aab1b1b2b2b1b1b1ac16" name="DLG_DateTo" value="" class="input f-date" style="" type=""><span class="f-calendar fontawesome icon-calendar"></span></div>
                                                                                                                <div class="decorator facade dttm" style="display: none;"><input name="DLG_DateTo-time" value="" class="input f-time" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome icon-time"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Date  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMhSW0EeuNPa1IYPTRDw" extid="DLG_DateNomOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DLG_DateNom" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ac17">DLG_ Date Nom</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><hr class="ie-date-time-hr">
                                                                                                                <aside class="decorator fontawesome icon-calendar-empty"></aside>
                                                                                                                <div class="decorator facade dtdt" style=""><input id="w29254aab1b1b2b2b1b1b1ac17" name="DLG_DateNom" value="" class="input f-date" style="" type=""><span class="f-calendar fontawesome icon-calendar"></span></div>
                                                                                                                <div class="decorator facade dttm" style="display: none;"><input name="DLG_DateNom-time" value="" class="input f-time" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome icon-time"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMhyW0EeuNPa1IYPTRDw" extid="DLG_CommentOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DLG_Comment" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ac18">DLG_ Comment</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ac18" name="DLG_Comment" value="" class="input" autocorrect="off" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                    </tr>
                                                                                                    </tbody>
                                                                                                </table><span class="f-status f-table-status" style="display:none;"><span></span></span></div>
                                                                                            <div class="b-droppable clearfix"></div>
                                                                                        </div>
                                                                                        </div>
                                                                                        <div class="b-droppable clearfix"></div>
                                                                                    </div>
                                                                                    <div class="f-control  f-section  s-valid  s-linked Section clearfix  s-expanded _BQESgSWlEeuNPa1IYPTRDw s-typed  s-not-signable " style="" id="_G270pyWlEeuNPa1IYPTRDw" extid="OnFamiliarizeHistory" cname="OnFamiliarize">
                                                                                        <div class="h-section clearfix s-not-expandable" title=""><span class="f-expand"></span><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label>История ознакомления</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                 <div class="c-helpcontent"></div>
                                                                              </div></span><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                        <div class="c-section clearfix"><span class="f-info" style="display:none;">Перетащите элементы управления из палитры или формы.</span><div class="f-control f-table s-valid s-linked Table clearfix s-expanded s-disabled" style="" minoccurs="0" maxoccurs="32767" id="_G270qSWlEeuNPa1IYPTRDw" extid="RepeatRecord" cname="RepeatRecord">
                                                                                            <div class="h-table clearfix" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label>Repeat Record</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                            <div class="c-table clearfix">
                                                                                                <table border="0" cellpadding="0" cellspacing="0">
                                                                                                    <thead>
                                                                                                    <tr class="f-table-head s-valid" id="_HtpxdSW2EeuNPa1IYPTRDw">
                                                                                                        <th class="first-column data-not-column"></th>
                                                                                                        <th class="data-not-column"></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_HtpxeyW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>Dev Phase</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_HtpxgSW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>Наименование подразделения</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_HtpxhyW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>Должность</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_HtpxjSW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>ФИО</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_HtpxkyW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>Emp Login</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_HtpxmSW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>Должность делегирования</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_HtpxnyW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>ФИО делегирования</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_HtpxpSW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>Статус</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_HtpxqyW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>Срок ознакомления*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_HtpxsSW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>Дата ознакомления</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_HtpxtyW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>Комментарий</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_HtpxvSW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>DLG_ Id Dev</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_HtpxwyW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>DLG_ Dept Name</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_HtqYVSW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>DLG_ Emp Login</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_HtqYWyW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>DLG_ Result</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_HtqYYSW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>DLG_ Date To</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_HtqYZyW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>DLG_ Date Nom</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_HtqYbSW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>DLG_ Comment</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                    </tr>
                                                                                                    </thead>
                                                                                                    <tbody>
                                                                                                    <tr id="_G270qiWlEeuNPa1IYPTRDw" class="f-table-row s-expanded s-linked s-typed s-valid" rcid="_G270qSWlEeuNPa1IYPTRDw">
                                                                                                        <td class="add-column data-not-column"><span class="f-add fontawesome icon-plus-sign"></span></td>
                                                                                                        <td class="remove-column data-not-column"><span class="f-remove fontawesome icon-minus-sign"></span></td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270rCWlEeuNPa1IYPTRDw" extid="DevPhase" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DevPhase" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ab1">Dev Phase</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ab1" name="DevPhase" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270riWlEeuNPa1IYPTRDw" extid="DeptNameOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DeptName" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ab2">Наименование подразделения</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ab2" name="DeptName" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270sCWlEeuNPa1IYPTRDw" extid="EmpPositionOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="EmpPosition" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ab3">Должность</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ab3" name="EmpPosition" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270siWlEeuNPa1IYPTRDw" extid="EmpNameOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="EmpName" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ab4">ФИО</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ab4" name="EmpName" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270tCWlEeuNPa1IYPTRDw" extid="EmpLoginOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="EmpLogin" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ab5">Emp Login</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ab5" name="EmpLogin" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270wiWlEeuNPa1IYPTRDw" extid="DLG_EmpPositionOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DLG_EmpPosition" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ab6">Должность делегирования</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ab6" name="DLG_EmpPosition" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270xCWlEeuNPa1IYPTRDw" extid="DLG_EmpNameOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DLG_EmpName" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ab7">ФИО делегирования</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ab7" name="DLG_EmpName" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270tiWlEeuNPa1IYPTRDw" extid="ResultOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="Result" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ab8">Статус</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ab8" name="Result" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Date s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270uCWlEeuNPa1IYPTRDw" extid="DateToOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DateTo" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ab9">Срок ознакомления*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><hr class="ie-date-time-hr">
                                                                                                                <aside class="decorator fontawesome icon-calendar-empty"></aside>
                                                                                                                <div class="decorator facade dtdt" style=""><input id="w29254aab1b1b2b2b2b1b1ab9" name="DateTo" value="" class="input f-date" style="" type="" disabled=""><span class="f-calendar fontawesome icon-calendar"></span></div>
                                                                                                                <div class="decorator facade dttm" style="display: none;"><input name="DateTo-time" value="" class="input f-time" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome icon-time"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Date _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270uiWlEeuNPa1IYPTRDw" extid="DateNomOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DateNom" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ac10">Дата ознакомления</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><hr class="ie-date-time-hr">
                                                                                                                <aside class="decorator fontawesome icon-calendar-empty"></aside>
                                                                                                                <div class="decorator facade dtdt" style=""><input id="w29254aab1b1b2b2b2b1b1ac10" name="DateNom" value="" class="input f-date" style="" type="" disabled=""></div>
                                                                                                                <div class="decorator facade dttm" style="display: none;"><input name="DateNom-time" value="" class="input f-time" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome icon-time"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270vCWlEeuNPa1IYPTRDw" extid="CommentOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="Comment" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ac11">Комментарий</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ac11" name="Comment" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270viWlEeuNPa1IYPTRDw" extid="DLG_IdDevOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DLG_IdDev" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ac12">DLG_ Id Dev</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ac12" name="DLG_IdDev" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270wCWlEeuNPa1IYPTRDw" extid="DLG_DeptNameOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DLG_DeptName" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ac13">DLG_ Dept Name</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ac13" name="DLG_DeptName" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270xiWlEeuNPa1IYPTRDw" extid="DLG_EmpLoginOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DLG_EmpLogin" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ac14">DLG_ Emp Login</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ac14" name="DLG_EmpLogin" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="1017944b-022a-432c-9ac1-ad1792e4759d" extid="DLG_ResultOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DLG_Result" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ac15">DLG_ Result</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ac15" name="DLG_Result" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Date s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="f510d8fc-07ee-43f7-a2d1-f4ffe79425ff" extid="DLG_DateToOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DLG_DateTo" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ac16">DLG_ Date To</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><hr class="ie-date-time-hr">
                                                                                                                <aside class="decorator fontawesome icon-calendar-empty"></aside>
                                                                                                                <div class="decorator facade dtdt" style=""><input id="w29254aab1b1b2b2b2b1b1ac16" name="DLG_DateTo" value="" class="input f-date" style="" type="" disabled=""><span class="f-calendar fontawesome icon-calendar"></span></div>
                                                                                                                <div class="decorator facade dttm" style="display: none;"><input name="DLG_DateTo-time" value="" class="input f-time" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome icon-time"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Date s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="e1734fbd-77a2-4f92-9147-570381edab4e" extid="DLG_DateNomOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DLG_DateNom" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ac17">DLG_ Date Nom</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><hr class="ie-date-time-hr">
                                                                                                                <aside class="decorator fontawesome icon-calendar-empty"></aside>
                                                                                                                <div class="decorator facade dtdt" style=""><input id="w29254aab1b1b2b2b2b1b1ac17" name="DLG_DateNom" value="" class="input f-date" style="" type="" disabled=""><span class="f-calendar fontawesome icon-calendar"></span></div>
                                                                                                                <div class="decorator facade dttm" style="display: none;"><input name="DLG_DateNom-time" value="" class="input f-time" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome icon-time"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="d876f8bd-43eb-4959-9deb-2dc0c80111d3" extid="DLG_CommentOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DLG_Comment" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ac18">DLG_ Comment</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ac18" name="DLG_Comment" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                    </tr>
                                                                                                    </tbody>
                                                                                                </table><span class="f-status f-table-status" style="display:none;"><span></span></span></div>
                                                                                            <div class="b-droppable clearfix"></div>
                                                                                        </div>
                                                                                        </div>
                                                                                        <div class="b-droppable clearfix"></div>
                                                                                    </div>

                                                                                </div>
                                                                            </div>

                                                                            <div hidden id="soglasovanie" class="c-switch " style="">

                                                                                <div class="c-case clearfix "><span class="f-info" style="display:none;">Перетащите элементы управления из палитры или формы.</span>
                                                                                    <div class="f-control  f-section  s-valid  s-linked Section clearfix  s-expanded _BQESgSWlEeuNPa1IYPTRDw s-typed  s-not-signable " style="" id="_8jpMYCW0EeuNPa1IYPTRDw" extid="OnFamiliarize" cname="OnFamiliarize">
                                                                                        <div class="h-section clearfix s-not-expandable" title=""><span class="f-expand"></span><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label>Ознакомление</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                 <div class="c-helpcontent"></div>
                                                                              </div></span><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                        <div class="c-section clearfix"><span class="f-info" style="display:none;">Перетащите элементы управления из палитры или формы.</span><div class="f-control  f-table s-valid s-linked Table clearfix  s-expanded " style="" minoccurs="0" maxoccurs="32767" id="_8jpMYiW0EeuNPa1IYPTRDw" extid="OnFamiliarizeTable" cname="OnFamiliarizeTable">
                                                                                            <div class="h-table clearfix" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label>Repeat Record</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                            <div class="c-table clearfix">
                                                                                                <table border="0" cellpadding="0" cellspacing="0">
                                                                                                    <thead>
                                                                                                    <tr class="f-table-head s-valid" id="_eAXdLDiIEeuKZ_wCS8O7Zw">
                                                                                                        <th class="first-column data-not-column"></th>
                                                                                                        <th class="data-not-column"></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAZSSTiIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>Dev Phase</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_eAZ5VTiIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>Наименование подразделения*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_eAZ5WziIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>Должность*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_eAZ5YTiIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>ФИО*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAZ5ZziIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>DLG_ Emp Login</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAZ5bTiIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>Наименование подразделения*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAZ5cziIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>Должность*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAZ5eTiIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>ФИО*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAagZTiIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>Emp Login</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAagaziIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>Результат</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_eAagcTiIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>Срок ознакомления*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAagdziIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>Дата ознакомления</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_eAagfTiIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>Комментарий*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAaggziIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>DLG_ Id Dev</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAagiTiIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>DLG_ Result</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAagjziIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>DLG_ Date To</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAaglTiIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>DLG_ Date Nom</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAagmziIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>DLG_ Comment</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                    </tr>
                                                                                                    </thead>
                                                                                                    <tbody>
                                                                                                    <tr id="_8jpMYyW0EeuNPa1IYPTRDw" class="f-table-row s-expanded s-linked s-typed s-valid" rcid="_8jpMYiW0EeuNPa1IYPTRDw">
                                                                                                        <td class="add-column data-not-column"><span class="f-add fontawesome icon-plus-sign s-add"></span></td>
                                                                                                        <td class="remove-column data-not-column"><span class="f-remove fontawesome icon-minus-sign"></span></td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMZSW0EeuNPa1IYPTRDw" extid="DevPhaseOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DevPhase" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ab1">Dev Phase</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ab1" name="DevPhase" value="" class="input" autocorrect="off" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns  f-select1  s-valid  s-linked Dropdown _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMeSW0EeuNPa1IYPTRDw" extid="DLG_DeptNameOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DLG_DeptName" title=""><span class="f-label" style=""><label>Наименование подразделения*</label><span class="f-required"></span>&gt;</span><div class="f-helpcontent" style="display:none">
                                                                                                                <div class="c-helpcontent"></div>
                                                                                                            </div><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input class="input" readonly="readonly"><span class="fontawesome icon-caret-down"></span><ul><li><a ovalue=""></a></li><li><a ovalue="finance">finance</a></li><li><a ovalue="Develop">Develop</a></li><li><a ovalue="company">company</a></li><li><a ovalue="security">security</a></li><li><a ovalue="finance-developer">finance-developer</a></li><li><a ovalue="123">123</a></li></ul>
                                                                                                                </div>
                                                                                                                <aside class="decorator fontawesome"></aside><textarea rows="1" type="text" name="_8jpMeSW0EeuNPa1IYPTRDw_comment" wrap="virtual" class="textarea f-select-comment" style="display:none;"></textarea><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns  f-select1  s-valid  s-linked Dropdown _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMeyW0EeuNPa1IYPTRDw" extid="DLG_EmpPositionOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DLG_EmpPosition" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label>Должность*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input class="input" readonly="readonly"><ul>
                                                                                                                    <li><a class="fontawesome " href="#" ovalue=""></a></li>
                                                                                                                </ul>
                                                                                                                </div>
                                                                                                                <aside class="decorator fontawesome"></aside><textarea rows="1" type="text" name="_8jpMeyW0EeuNPa1IYPTRDw_comment" wrap="virtual" class="textarea f-select-comment" style="display:none;"></textarea><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns  f-select1  s-valid  s-linked Dropdown _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMfSW0EeuNPa1IYPTRDw" extid="DLG_EmpNameOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DLG_EmpName" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label>ФИО*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input class="input" readonly="readonly"><ul>
                                                                                                                    <li><a class="fontawesome " href="#" ovalue=""></a></li>
                                                                                                                </ul>
                                                                                                                </div>
                                                                                                                <aside class="decorator fontawesome"></aside><textarea rows="1" type="text" name="_8jpMfSW0EeuNPa1IYPTRDw_comment" wrap="virtual" class="textarea f-select-comment" style="display:none;"></textarea><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMfyW0EeuNPa1IYPTRDw" extid="DLG_EmpLoginOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DLG_EmpLogin" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ab5">DLG_ Emp Login</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ab5" name="DLG_EmpLogin" value="" class="input" autocorrect="off" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMZyW0EeuNPa1IYPTRDw" extid="DeptNameOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DeptName" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ab6">Наименование подразделения*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ab6" name="DeptName" value="" class="input" autocorrect="off" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMaSW0EeuNPa1IYPTRDw" extid="EmpPositionOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="EmpPosition" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ab7">Должность*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ab7" name="EmpPosition" value="" class="input" autocorrect="off" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMayW0EeuNPa1IYPTRDw" extid="EmpNameOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="EmpName" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ab8">ФИО*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ab8" name="EmpName" value="" class="input" autocorrect="off" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMbSW0EeuNPa1IYPTRDw" extid="EmpLoginOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="EmpLogin" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ab9">Emp Login</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ab9" name="EmpLogin" value="" class="input" autocorrect="off" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMbyW0EeuNPa1IYPTRDw" extid="ResultOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="Result" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ac10">Результат</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ac10" name="Result" value="" class="input" autocorrect="off" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Date _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMcSW0EeuNPa1IYPTRDw" extid="DateToOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DateTo" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ac11">Срок ознакомления*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><hr class="ie-date-time-hr">
                                                                                                                <aside class="decorator fontawesome icon-calendar-empty"></aside>
                                                                                                                <div class="decorator facade dtdt" style=""><input id="w29254aab1b1b2b2b1b1b1ac11" name="DateTo" value="" class="input f-date" style="" type=""></div>
                                                                                                                <div class="decorator facade dttm" style="display: none;"><input name="DateTo-time" value="" class="input f-time" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome icon-time"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Date  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMcyW0EeuNPa1IYPTRDw" extid="DateNomOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DateNom" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ac12">Дата ознакомления</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><hr class="ie-date-time-hr">
                                                                                                                <aside class="decorator fontawesome icon-calendar-empty"></aside>
                                                                                                                <div class="decorator facade dtdt" style=""><input id="w29254aab1b1b2b2b1b1b1ac12" name="DateNom" value="" class="input f-date" style="" type=""><span class="f-calendar fontawesome icon-calendar"></span></div>
                                                                                                                <div class="decorator facade dttm" style="display: none;"><input name="DateNom-time" value="" class="input f-time" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome icon-time"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_8jpMdSW0EeuNPa1IYPTRDw" extid="CommentOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="Comment" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ac13">Комментарий*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ac13" name="Comment" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMdyW0EeuNPa1IYPTRDw" extid="DLG_IdDevOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DLG_IdDev" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ac14">DLG_ Id Dev</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ac14" name="DLG_IdDev" value="" class="input" autocorrect="off" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMgSW0EeuNPa1IYPTRDw" extid="DLG_ResultOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DLG_Result" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ac15">DLG_ Result</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ac15" name="DLG_Result" value="" class="input" autocorrect="off" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Date  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMgyW0EeuNPa1IYPTRDw" extid="DLG_DateToOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DLG_DateTo" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ac16">DLG_ Date To</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><hr class="ie-date-time-hr">
                                                                                                                <aside class="decorator fontawesome icon-calendar-empty"></aside>
                                                                                                                <div class="decorator facade dtdt" style=""><input id="w29254aab1b1b2b2b1b1b1ac16" name="DLG_DateTo" value="" class="input f-date" style="" type=""><span class="f-calendar fontawesome icon-calendar"></span></div>
                                                                                                                <div class="decorator facade dttm" style="display: none;"><input name="DLG_DateTo-time" value="" class="input f-time" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome icon-time"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Date  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMhSW0EeuNPa1IYPTRDw" extid="DLG_DateNomOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DLG_DateNom" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ac17">DLG_ Date Nom</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><hr class="ie-date-time-hr">
                                                                                                                <aside class="decorator fontawesome icon-calendar-empty"></aside>
                                                                                                                <div class="decorator facade dtdt" style=""><input id="w29254aab1b1b2b2b1b1b1ac17" name="DLG_DateNom" value="" class="input f-date" style="" type=""><span class="f-calendar fontawesome icon-calendar"></span></div>
                                                                                                                <div class="decorator facade dttm" style="display: none;"><input name="DLG_DateNom-time" value="" class="input f-time" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome icon-time"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMhyW0EeuNPa1IYPTRDw" extid="DLG_CommentOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DLG_Comment" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ac18">DLG_ Comment</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ac18" name="DLG_Comment" value="" class="input" autocorrect="off" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                    </tr>
                                                                                                    </tbody>
                                                                                                </table><span class="f-status f-table-status" style="display:none;"><span></span></span></div>
                                                                                            <div class="b-droppable clearfix"></div>
                                                                                        </div>
                                                                                        </div>
                                                                                        <div class="b-droppable clearfix"></div>
                                                                                    </div>
                                                                                    <div class="f-control  f-section  s-valid  s-linked Section clearfix  s-expanded _BQESgSWlEeuNPa1IYPTRDw s-typed  s-not-signable " style="" id="_G270pyWlEeuNPa1IYPTRDw" extid="OnFamiliarizeHistory" cname="OnFamiliarize">
                                                                                        <div class="h-section clearfix s-not-expandable" title=""><span class="f-expand"></span><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label>История ознакомления</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                 <div class="c-helpcontent"></div>
                                                                              </div></span><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                        <div class="c-section clearfix"><span class="f-info" style="display:none;">Перетащите элементы управления из палитры или формы.</span><div class="f-control f-table s-valid s-linked Table clearfix s-expanded s-disabled" style="" minoccurs="0" maxoccurs="32767" id="_G270qSWlEeuNPa1IYPTRDw" extid="RepeatRecord" cname="RepeatRecord">
                                                                                            <div class="h-table clearfix" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label>Repeat Record</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                            <div class="c-table clearfix">
                                                                                                <table border="0" cellpadding="0" cellspacing="0">
                                                                                                    <thead>
                                                                                                    <tr class="f-table-head s-valid" id="_HtpxdSW2EeuNPa1IYPTRDw">
                                                                                                        <th class="first-column data-not-column"></th>
                                                                                                        <th class="data-not-column"></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_HtpxeyW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>Dev Phase</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_HtpxgSW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>Наименование подразделения</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_HtpxhyW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>Должность</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_HtpxjSW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>ФИО</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_HtpxkyW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>Emp Login</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_HtpxmSW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>Должность делегирования</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_HtpxnyW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>ФИО делегирования</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_HtpxpSW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>Статус</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_HtpxqyW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>Срок ознакомления*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_HtpxsSW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>Дата ознакомления</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_HtpxtyW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>Комментарий</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_HtpxvSW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>DLG_ Id Dev</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_HtpxwyW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>DLG_ Dept Name</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_HtqYVSW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>DLG_ Emp Login</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_HtqYWyW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>DLG_ Result</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_HtqYYSW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>DLG_ Date To</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_HtqYZyW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>DLG_ Date Nom</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_HtqYbSW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>DLG_ Comment</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                    </tr>
                                                                                                    </thead>
                                                                                                    <tbody>
                                                                                                    <tr id="_G270qiWlEeuNPa1IYPTRDw" class="f-table-row s-expanded s-linked s-typed s-valid" rcid="_G270qSWlEeuNPa1IYPTRDw">
                                                                                                        <td class="add-column data-not-column"><span class="f-add fontawesome icon-plus-sign"></span></td>
                                                                                                        <td class="remove-column data-not-column"><span class="f-remove fontawesome icon-minus-sign"></span></td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270rCWlEeuNPa1IYPTRDw" extid="DevPhase" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DevPhase" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ab1">Dev Phase</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ab1" name="DevPhase" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270riWlEeuNPa1IYPTRDw" extid="DeptNameOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DeptName" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ab2">Наименование подразделения</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ab2" name="DeptName" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270sCWlEeuNPa1IYPTRDw" extid="EmpPositionOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="EmpPosition" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ab3">Должность</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ab3" name="EmpPosition" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270siWlEeuNPa1IYPTRDw" extid="EmpNameOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="EmpName" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ab4">ФИО</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ab4" name="EmpName" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270tCWlEeuNPa1IYPTRDw" extid="EmpLoginOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="EmpLogin" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ab5">Emp Login</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ab5" name="EmpLogin" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270wiWlEeuNPa1IYPTRDw" extid="DLG_EmpPositionOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DLG_EmpPosition" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ab6">Должность делегирования</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ab6" name="DLG_EmpPosition" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270xCWlEeuNPa1IYPTRDw" extid="DLG_EmpNameOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DLG_EmpName" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ab7">ФИО делегирования</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ab7" name="DLG_EmpName" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270tiWlEeuNPa1IYPTRDw" extid="ResultOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="Result" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ab8">Статус</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ab8" name="Result" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Date s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270uCWlEeuNPa1IYPTRDw" extid="DateToOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DateTo" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ab9">Срок ознакомления*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><hr class="ie-date-time-hr">
                                                                                                                <aside class="decorator fontawesome icon-calendar-empty"></aside>
                                                                                                                <div class="decorator facade dtdt" style=""><input id="w29254aab1b1b2b2b2b1b1ab9" name="DateTo" value="" class="input f-date" style="" type="" disabled=""><span class="f-calendar fontawesome icon-calendar"></span></div>
                                                                                                                <div class="decorator facade dttm" style="display: none;"><input name="DateTo-time" value="" class="input f-time" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome icon-time"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Date _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270uiWlEeuNPa1IYPTRDw" extid="DateNomOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DateNom" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ac10">Дата ознакомления</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><hr class="ie-date-time-hr">
                                                                                                                <aside class="decorator fontawesome icon-calendar-empty"></aside>
                                                                                                                <div class="decorator facade dtdt" style=""><input id="w29254aab1b1b2b2b2b1b1ac10" name="DateNom" value="" class="input f-date" style="" type="" disabled=""></div>
                                                                                                                <div class="decorator facade dttm" style="display: none;"><input name="DateNom-time" value="" class="input f-time" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome icon-time"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270vCWlEeuNPa1IYPTRDw" extid="CommentOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="Comment" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ac11">Комментарий</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ac11" name="Comment" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270viWlEeuNPa1IYPTRDw" extid="DLG_IdDevOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DLG_IdDev" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ac12">DLG_ Id Dev</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ac12" name="DLG_IdDev" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270wCWlEeuNPa1IYPTRDw" extid="DLG_DeptNameOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DLG_DeptName" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ac13">DLG_ Dept Name</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ac13" name="DLG_DeptName" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270xiWlEeuNPa1IYPTRDw" extid="DLG_EmpLoginOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DLG_EmpLogin" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ac14">DLG_ Emp Login</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ac14" name="DLG_EmpLogin" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="1017944b-022a-432c-9ac1-ad1792e4759d" extid="DLG_ResultOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DLG_Result" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ac15">DLG_ Result</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ac15" name="DLG_Result" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Date s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="f510d8fc-07ee-43f7-a2d1-f4ffe79425ff" extid="DLG_DateToOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DLG_DateTo" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ac16">DLG_ Date To</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><hr class="ie-date-time-hr">
                                                                                                                <aside class="decorator fontawesome icon-calendar-empty"></aside>
                                                                                                                <div class="decorator facade dtdt" style=""><input id="w29254aab1b1b2b2b2b1b1ac16" name="DLG_DateTo" value="" class="input f-date" style="" type="" disabled=""><span class="f-calendar fontawesome icon-calendar"></span></div>
                                                                                                                <div class="decorator facade dttm" style="display: none;"><input name="DLG_DateTo-time" value="" class="input f-time" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome icon-time"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Date s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="e1734fbd-77a2-4f92-9147-570381edab4e" extid="DLG_DateNomOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DLG_DateNom" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ac17">DLG_ Date Nom</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><hr class="ie-date-time-hr">
                                                                                                                <aside class="decorator fontawesome icon-calendar-empty"></aside>
                                                                                                                <div class="decorator facade dtdt" style=""><input id="w29254aab1b1b2b2b2b1b1ac17" name="DLG_DateNom" value="" class="input f-date" style="" type="" disabled=""><span class="f-calendar fontawesome icon-calendar"></span></div>
                                                                                                                <div class="decorator facade dttm" style="display: none;"><input name="DLG_DateNom-time" value="" class="input f-time" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome icon-time"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="d876f8bd-43eb-4959-9deb-2dc0c80111d3" extid="DLG_CommentOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DLG_Comment" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ac18">DLG_ Comment</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ac18" name="DLG_Comment" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                    </tr>
                                                                                                    </tbody>
                                                                                                </table><span class="f-status f-table-status" style="display:none;"><span></span></span></div>
                                                                                            <div class="b-droppable clearfix"></div>
                                                                                        </div>
                                                                                        </div>
                                                                                        <div class="b-droppable clearfix"></div>
                                                                                    </div>

                                                                                </div>
                                                                                    <div class="b-droppable clearfix"></div>
                                                                                </div>
                                                                            </div>

                                                                            <div hidden id="soglasovanieR" class="c-switch " style="">

                                                                                <div class="c-case clearfix "><span class="f-info" style="display:none;">Перетащите элементы управления из палитры или формы.</span>
                                                                                    <div class="f-control  f-section  s-valid  s-linked Section clearfix  s-expanded _BQESgSWlEeuNPa1IYPTRDw s-typed  s-not-signable " style="" id="_8jpMYCW0EeuNPa1IYPTRDw" extid="OnFamiliarize" cname="OnFamiliarize">
                                                                                        <div class="h-section clearfix s-not-expandable" title=""><span class="f-expand"></span><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label>Ознакомление</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                 <div class="c-helpcontent"></div>
                                                                              </div></span><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                        <div class="c-section clearfix"><span class="f-info" style="display:none;">Перетащите элементы управления из палитры или формы.</span><div class="f-control  f-table s-valid s-linked Table clearfix  s-expanded " style="" minoccurs="0" maxoccurs="32767" id="_8jpMYiW0EeuNPa1IYPTRDw" extid="OnFamiliarizeTable" cname="OnFamiliarizeTable">
                                                                                            <div class="h-table clearfix" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label>Repeat Record</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                            <div class="c-table clearfix">
                                                                                                <table border="0" cellpadding="0" cellspacing="0">
                                                                                                    <thead>
                                                                                                    <tr class="f-table-head s-valid" id="_eAXdLDiIEeuKZ_wCS8O7Zw">
                                                                                                        <th class="first-column data-not-column"></th>
                                                                                                        <th class="data-not-column"></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAZSSTiIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>Dev Phase</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_eAZ5VTiIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>Наименование подразделения*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_eAZ5WziIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>Должность*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_eAZ5YTiIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>ФИО*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAZ5ZziIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>DLG_ Emp Login</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAZ5bTiIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>Наименование подразделения*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAZ5cziIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>Должность*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAZ5eTiIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>ФИО*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAagZTiIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>Emp Login</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAagaziIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>Результат</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_eAagcTiIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>Срок ознакомления*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAagdziIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>Дата ознакомления</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_eAagfTiIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>Комментарий*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAaggziIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>DLG_ Id Dev</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAagiTiIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>DLG_ Result</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAagjziIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>DLG_ Date To</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAaglTiIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>DLG_ Date Nom</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAagmziIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>DLG_ Comment</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                    </tr>
                                                                                                    </thead>
                                                                                                    <tbody>
                                                                                                    <tr id="_8jpMYyW0EeuNPa1IYPTRDw" class="f-table-row s-expanded s-linked s-typed s-valid" rcid="_8jpMYiW0EeuNPa1IYPTRDw">
                                                                                                        <td class="add-column data-not-column"><span class="f-add fontawesome icon-plus-sign s-add"></span></td>
                                                                                                        <td class="remove-column data-not-column"><span class="f-remove fontawesome icon-minus-sign"></span></td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMZSW0EeuNPa1IYPTRDw" extid="DevPhaseOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DevPhase" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ab1">Dev Phase</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ab1" name="DevPhase" value="" class="input" autocorrect="off" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns  f-select1  s-valid  s-linked Dropdown _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMeSW0EeuNPa1IYPTRDw" extid="DLG_DeptNameOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DLG_DeptName" title=""><span class="f-label" style=""><label>Наименование подразделения*</label><span class="f-required"></span>&gt;</span><div class="f-helpcontent" style="display:none">
                                                                                                                <div class="c-helpcontent"></div>
                                                                                                            </div><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input class="input" readonly="readonly"><span class="fontawesome icon-caret-down"></span><ul><li><a ovalue=""></a></li><li><a ovalue="finance">finance</a></li><li><a ovalue="Develop">Develop</a></li><li><a ovalue="company">company</a></li><li><a ovalue="security">security</a></li><li><a ovalue="finance-developer">finance-developer</a></li><li><a ovalue="123">123</a></li></ul>
                                                                                                                </div>
                                                                                                                <aside class="decorator fontawesome"></aside><textarea rows="1" type="text" name="_8jpMeSW0EeuNPa1IYPTRDw_comment" wrap="virtual" class="textarea f-select-comment" style="display:none;"></textarea><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns  f-select1  s-valid  s-linked Dropdown _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMeyW0EeuNPa1IYPTRDw" extid="DLG_EmpPositionOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DLG_EmpPosition" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label>Должность*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input class="input" readonly="readonly"><ul>
                                                                                                                    <li><a class="fontawesome " href="#" ovalue=""></a></li>
                                                                                                                </ul>
                                                                                                                </div>
                                                                                                                <aside class="decorator fontawesome"></aside><textarea rows="1" type="text" name="_8jpMeyW0EeuNPa1IYPTRDw_comment" wrap="virtual" class="textarea f-select-comment" style="display:none;"></textarea><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns  f-select1  s-valid  s-linked Dropdown _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMfSW0EeuNPa1IYPTRDw" extid="DLG_EmpNameOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DLG_EmpName" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label>ФИО*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input class="input" readonly="readonly"><ul>
                                                                                                                    <li><a class="fontawesome " href="#" ovalue=""></a></li>
                                                                                                                </ul>
                                                                                                                </div>
                                                                                                                <aside class="decorator fontawesome"></aside><textarea rows="1" type="text" name="_8jpMfSW0EeuNPa1IYPTRDw_comment" wrap="virtual" class="textarea f-select-comment" style="display:none;"></textarea><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMfyW0EeuNPa1IYPTRDw" extid="DLG_EmpLoginOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DLG_EmpLogin" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ab5">DLG_ Emp Login</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ab5" name="DLG_EmpLogin" value="" class="input" autocorrect="off" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMZyW0EeuNPa1IYPTRDw" extid="DeptNameOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DeptName" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ab6">Наименование подразделения*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ab6" name="DeptName" value="" class="input" autocorrect="off" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMaSW0EeuNPa1IYPTRDw" extid="EmpPositionOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="EmpPosition" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ab7">Должность*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ab7" name="EmpPosition" value="" class="input" autocorrect="off" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMayW0EeuNPa1IYPTRDw" extid="EmpNameOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="EmpName" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ab8">ФИО*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ab8" name="EmpName" value="" class="input" autocorrect="off" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMbSW0EeuNPa1IYPTRDw" extid="EmpLoginOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="EmpLogin" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ab9">Emp Login</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ab9" name="EmpLogin" value="" class="input" autocorrect="off" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMbyW0EeuNPa1IYPTRDw" extid="ResultOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="Result" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ac10">Результат</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ac10" name="Result" value="" class="input" autocorrect="off" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Date _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMcSW0EeuNPa1IYPTRDw" extid="DateToOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DateTo" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ac11">Срок ознакомления*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><hr class="ie-date-time-hr">
                                                                                                                <aside class="decorator fontawesome icon-calendar-empty"></aside>
                                                                                                                <div class="decorator facade dtdt" style=""><input id="w29254aab1b1b2b2b1b1b1ac11" name="DateTo" value="" class="input f-date" style="" type=""></div>
                                                                                                                <div class="decorator facade dttm" style="display: none;"><input name="DateTo-time" value="" class="input f-time" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome icon-time"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Date  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMcyW0EeuNPa1IYPTRDw" extid="DateNomOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DateNom" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ac12">Дата ознакомления</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><hr class="ie-date-time-hr">
                                                                                                                <aside class="decorator fontawesome icon-calendar-empty"></aside>
                                                                                                                <div class="decorator facade dtdt" style=""><input id="w29254aab1b1b2b2b1b1b1ac12" name="DateNom" value="" class="input f-date" style="" type=""><span class="f-calendar fontawesome icon-calendar"></span></div>
                                                                                                                <div class="decorator facade dttm" style="display: none;"><input name="DateNom-time" value="" class="input f-time" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome icon-time"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_8jpMdSW0EeuNPa1IYPTRDw" extid="CommentOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="Comment" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ac13">Комментарий*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ac13" name="Comment" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMdyW0EeuNPa1IYPTRDw" extid="DLG_IdDevOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DLG_IdDev" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ac14">DLG_ Id Dev</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ac14" name="DLG_IdDev" value="" class="input" autocorrect="off" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMgSW0EeuNPa1IYPTRDw" extid="DLG_ResultOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DLG_Result" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ac15">DLG_ Result</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ac15" name="DLG_Result" value="" class="input" autocorrect="off" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Date  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMgyW0EeuNPa1IYPTRDw" extid="DLG_DateToOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DLG_DateTo" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ac16">DLG_ Date To</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><hr class="ie-date-time-hr">
                                                                                                                <aside class="decorator fontawesome icon-calendar-empty"></aside>
                                                                                                                <div class="decorator facade dtdt" style=""><input id="w29254aab1b1b2b2b1b1b1ac16" name="DLG_DateTo" value="" class="input f-date" style="" type=""><span class="f-calendar fontawesome icon-calendar"></span></div>
                                                                                                                <div class="decorator facade dttm" style="display: none;"><input name="DLG_DateTo-time" value="" class="input f-time" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome icon-time"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Date  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMhSW0EeuNPa1IYPTRDw" extid="DLG_DateNomOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DLG_DateNom" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ac17">DLG_ Date Nom</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><hr class="ie-date-time-hr">
                                                                                                                <aside class="decorator fontawesome icon-calendar-empty"></aside>
                                                                                                                <div class="decorator facade dtdt" style=""><input id="w29254aab1b1b2b2b1b1b1ac17" name="DLG_DateNom" value="" class="input f-date" style="" type=""><span class="f-calendar fontawesome icon-calendar"></span></div>
                                                                                                                <div class="decorator facade dttm" style="display: none;"><input name="DLG_DateNom-time" value="" class="input f-time" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome icon-time"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMhyW0EeuNPa1IYPTRDw" extid="DLG_CommentOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DLG_Comment" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ac18">DLG_ Comment</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ac18" name="DLG_Comment" value="" class="input" autocorrect="off" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                    </tr>
                                                                                                    </tbody>
                                                                                                </table><span class="f-status f-table-status" style="display:none;"><span></span></span></div>
                                                                                            <div class="b-droppable clearfix"></div>
                                                                                        </div>
                                                                                        </div>
                                                                                        <div class="b-droppable clearfix"></div>
                                                                                    </div>
                                                                                    <div class="f-control  f-section  s-valid  s-linked Section clearfix  s-expanded _BQESgSWlEeuNPa1IYPTRDw s-typed  s-not-signable " style="" id="_G270pyWlEeuNPa1IYPTRDw" extid="OnFamiliarizeHistory" cname="OnFamiliarize">
                                                                                        <div class="h-section clearfix s-not-expandable" title=""><span class="f-expand"></span><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label>История ознакомления</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                 <div class="c-helpcontent"></div>
                                                                              </div></span><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                        <div class="c-section clearfix"><span class="f-info" style="display:none;">Перетащите элементы управления из палитры или формы.</span><div class="f-control f-table s-valid s-linked Table clearfix s-expanded s-disabled" style="" minoccurs="0" maxoccurs="32767" id="_G270qSWlEeuNPa1IYPTRDw" extid="RepeatRecord" cname="RepeatRecord">
                                                                                            <div class="h-table clearfix" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label>Repeat Record</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                            <div class="c-table clearfix">
                                                                                                <table border="0" cellpadding="0" cellspacing="0">
                                                                                                    <thead>
                                                                                                    <tr class="f-table-head s-valid" id="_HtpxdSW2EeuNPa1IYPTRDw">
                                                                                                        <th class="first-column data-not-column"></th>
                                                                                                        <th class="data-not-column"></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_HtpxeyW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>Dev Phase</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_HtpxgSW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>Наименование подразделения</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_HtpxhyW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>Должность</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_HtpxjSW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>ФИО</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_HtpxkyW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>Emp Login</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_HtpxmSW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>Должность делегирования</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_HtpxnyW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>ФИО делегирования</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_HtpxpSW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>Статус</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_HtpxqyW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>Срок ознакомления*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_HtpxsSW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>Дата ознакомления</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_HtpxtyW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>Комментарий</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_HtpxvSW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>DLG_ Id Dev</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_HtpxwyW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>DLG_ Dept Name</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_HtqYVSW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>DLG_ Emp Login</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_HtqYWyW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>DLG_ Result</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_HtqYYSW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>DLG_ Date To</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_HtqYZyW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>DLG_ Date Nom</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_HtqYbSW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>DLG_ Comment</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                    </tr>
                                                                                                    </thead>
                                                                                                    <tbody>
                                                                                                    <tr id="_G270qiWlEeuNPa1IYPTRDw" class="f-table-row s-expanded s-linked s-typed s-valid" rcid="_G270qSWlEeuNPa1IYPTRDw">
                                                                                                        <td class="add-column data-not-column"><span class="f-add fontawesome icon-plus-sign"></span></td>
                                                                                                        <td class="remove-column data-not-column"><span class="f-remove fontawesome icon-minus-sign"></span></td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270rCWlEeuNPa1IYPTRDw" extid="DevPhase" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DevPhase" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ab1">Dev Phase</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ab1" name="DevPhase" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270riWlEeuNPa1IYPTRDw" extid="DeptNameOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DeptName" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ab2">Наименование подразделения</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ab2" name="DeptName" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270sCWlEeuNPa1IYPTRDw" extid="EmpPositionOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="EmpPosition" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ab3">Должность</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ab3" name="EmpPosition" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270siWlEeuNPa1IYPTRDw" extid="EmpNameOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="EmpName" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ab4">ФИО</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ab4" name="EmpName" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270tCWlEeuNPa1IYPTRDw" extid="EmpLoginOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="EmpLogin" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ab5">Emp Login</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ab5" name="EmpLogin" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270wiWlEeuNPa1IYPTRDw" extid="DLG_EmpPositionOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DLG_EmpPosition" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ab6">Должность делегирования</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ab6" name="DLG_EmpPosition" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270xCWlEeuNPa1IYPTRDw" extid="DLG_EmpNameOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DLG_EmpName" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ab7">ФИО делегирования</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ab7" name="DLG_EmpName" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270tiWlEeuNPa1IYPTRDw" extid="ResultOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="Result" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ab8">Статус</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ab8" name="Result" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Date s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270uCWlEeuNPa1IYPTRDw" extid="DateToOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DateTo" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ab9">Срок ознакомления*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><hr class="ie-date-time-hr">
                                                                                                                <aside class="decorator fontawesome icon-calendar-empty"></aside>
                                                                                                                <div class="decorator facade dtdt" style=""><input id="w29254aab1b1b2b2b2b1b1ab9" name="DateTo" value="" class="input f-date" style="" type="" disabled=""><span class="f-calendar fontawesome icon-calendar"></span></div>
                                                                                                                <div class="decorator facade dttm" style="display: none;"><input name="DateTo-time" value="" class="input f-time" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome icon-time"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Date _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270uiWlEeuNPa1IYPTRDw" extid="DateNomOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DateNom" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ac10">Дата ознакомления</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><hr class="ie-date-time-hr">
                                                                                                                <aside class="decorator fontawesome icon-calendar-empty"></aside>
                                                                                                                <div class="decorator facade dtdt" style=""><input id="w29254aab1b1b2b2b2b1b1ac10" name="DateNom" value="" class="input f-date" style="" type="" disabled=""></div>
                                                                                                                <div class="decorator facade dttm" style="display: none;"><input name="DateNom-time" value="" class="input f-time" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome icon-time"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270vCWlEeuNPa1IYPTRDw" extid="CommentOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="Comment" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ac11">Комментарий</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ac11" name="Comment" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270viWlEeuNPa1IYPTRDw" extid="DLG_IdDevOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DLG_IdDev" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ac12">DLG_ Id Dev</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ac12" name="DLG_IdDev" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270wCWlEeuNPa1IYPTRDw" extid="DLG_DeptNameOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DLG_DeptName" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ac13">DLG_ Dept Name</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ac13" name="DLG_DeptName" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270xiWlEeuNPa1IYPTRDw" extid="DLG_EmpLoginOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DLG_EmpLogin" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ac14">DLG_ Emp Login</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ac14" name="DLG_EmpLogin" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="1017944b-022a-432c-9ac1-ad1792e4759d" extid="DLG_ResultOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DLG_Result" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ac15">DLG_ Result</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ac15" name="DLG_Result" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Date s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="f510d8fc-07ee-43f7-a2d1-f4ffe79425ff" extid="DLG_DateToOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DLG_DateTo" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ac16">DLG_ Date To</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><hr class="ie-date-time-hr">
                                                                                                                <aside class="decorator fontawesome icon-calendar-empty"></aside>
                                                                                                                <div class="decorator facade dtdt" style=""><input id="w29254aab1b1b2b2b2b1b1ac16" name="DLG_DateTo" value="" class="input f-date" style="" type="" disabled=""><span class="f-calendar fontawesome icon-calendar"></span></div>
                                                                                                                <div class="decorator facade dttm" style="display: none;"><input name="DLG_DateTo-time" value="" class="input f-time" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome icon-time"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Date s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="e1734fbd-77a2-4f92-9147-570381edab4e" extid="DLG_DateNomOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DLG_DateNom" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ac17">DLG_ Date Nom</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><hr class="ie-date-time-hr">
                                                                                                                <aside class="decorator fontawesome icon-calendar-empty"></aside>
                                                                                                                <div class="decorator facade dtdt" style=""><input id="w29254aab1b1b2b2b2b1b1ac17" name="DLG_DateNom" value="" class="input f-date" style="" type="" disabled=""><span class="f-calendar fontawesome icon-calendar"></span></div>
                                                                                                                <div class="decorator facade dttm" style="display: none;"><input name="DLG_DateNom-time" value="" class="input f-time" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome icon-time"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="d876f8bd-43eb-4959-9deb-2dc0c80111d3" extid="DLG_CommentOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DLG_Comment" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ac18">DLG_ Comment</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ac18" name="DLG_Comment" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                    </tr>
                                                                                                    </tbody>
                                                                                                </table><span class="f-status f-table-status" style="display:none;"><span></span></span></div>
                                                                                            <div class="b-droppable clearfix"></div>
                                                                                        </div>
                                                                                        </div>
                                                                                        <div class="b-droppable clearfix"></div>
                                                                                    </div>

                                                                                </div>
                                                                            </div>
                                                                                <div hidden id ="oznakomlenie" class="c-case clearfix "><span class="f-info" style="display:none;">Перетащите элементы управления из палитры или формы.</span>
                                                                                    <div class="f-control  f-section  s-valid  s-linked Section clearfix  s-expanded _BQESgSWlEeuNPa1IYPTRDw s-typed  s-not-signable " style="" id="_8jpMYCW0EeuNPa1IYPTRDw" extid="OnFamiliarize" cname="OnFamiliarize">
                                                                                        <div class="h-section clearfix s-not-expandable" title=""><span class="f-expand"></span><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label>Ознакомление</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                 <div class="c-helpcontent"></div>
                                                                              </div></span><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                        <div class="c-section clearfix"><span class="f-info" style="display:none;">Перетащите элементы управления из палитры или формы.</span><div class="f-control  f-table s-valid s-linked Table clearfix  s-expanded " style="" minoccurs="0" maxoccurs="32767" id="_8jpMYiW0EeuNPa1IYPTRDw" extid="OnFamiliarizeTable" cname="OnFamiliarizeTable">
                                                                                            <div class="h-table clearfix" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label>Repeat Record</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                            <div class="c-table clearfix">
                                                                                                <table border="0" cellpadding="0" cellspacing="0">
                                                                                                    <thead>
                                                                                                    <tr class="f-table-head s-valid" id="_eAXdLDiIEeuKZ_wCS8O7Zw">
                                                                                                        <th class="first-column data-not-column"></th>
                                                                                                        <th class="data-not-column"></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAZSSTiIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>Dev Phase</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_eAZ5VTiIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>Наименование подразделения*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_eAZ5WziIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>Должность*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_eAZ5YTiIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>ФИО*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAZ5ZziIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>DLG_ Emp Login</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAZ5bTiIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>Наименование подразделения*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAZ5cziIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>Должность*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAZ5eTiIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>ФИО*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAagZTiIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>Emp Login</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAagaziIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>Результат</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_eAagcTiIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>Срок ознакомления*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAagdziIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>Дата ознакомления</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_eAagfTiIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>Комментарий*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAaggziIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>DLG_ Id Dev</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAagiTiIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>DLG_ Result</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAagjziIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>DLG_ Date To</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAaglTiIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>DLG_ Date Nom</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_eAagmziIEeuKZ_wCS8O7Zw" title=""><span class="f-label" style=""><label>DLG_ Comment</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                    </tr>
                                                                                                    </thead>
                                                                                                    <tbody>
                                                                                                    <tr id="_8jpMYyW0EeuNPa1IYPTRDw" class="f-table-row s-expanded s-linked s-typed s-valid" rcid="_8jpMYiW0EeuNPa1IYPTRDw">
                                                                                                        <td class="add-column data-not-column"><span class="f-add fontawesome icon-plus-sign s-add"></span></td>
                                                                                                        <td class="remove-column data-not-column"><span class="f-remove fontawesome icon-minus-sign"></span></td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMZSW0EeuNPa1IYPTRDw" extid="DevPhaseOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DevPhase" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ab1">Dev Phase</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ab1" name="DevPhase" value="" class="input" autocorrect="off" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns  f-select1  s-valid  s-linked Dropdown _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMeSW0EeuNPa1IYPTRDw" extid="DLG_DeptNameOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DLG_DeptName" title=""><span class="f-label" style=""><label>Наименование подразделения*</label><span class="f-required"></span>&gt;</span><div class="f-helpcontent" style="display:none">
                                                                                                                <div class="c-helpcontent"></div>
                                                                                                            </div><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input class="input" readonly="readonly"><span class="fontawesome icon-caret-down"></span><ul><li><a ovalue=""></a></li><li><a ovalue="finance">finance</a></li><li><a ovalue="Develop">Develop</a></li><li><a ovalue="company">company</a></li><li><a ovalue="security">security</a></li><li><a ovalue="finance-developer">finance-developer</a></li><li><a ovalue="123">123</a></li></ul>
                                                                                                                </div>
                                                                                                                <aside class="decorator fontawesome"></aside><textarea rows="1" type="text" name="_8jpMeSW0EeuNPa1IYPTRDw_comment" wrap="virtual" class="textarea f-select-comment" style="display:none;"></textarea><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns  f-select1  s-valid  s-linked Dropdown _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMeyW0EeuNPa1IYPTRDw" extid="DLG_EmpPositionOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DLG_EmpPosition" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label>Должность*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input class="input" readonly="readonly"><ul>
                                                                                                                    <li><a class="fontawesome " href="#" ovalue=""></a></li>
                                                                                                                </ul>
                                                                                                                </div>
                                                                                                                <aside class="decorator fontawesome"></aside><textarea rows="1" type="text" name="_8jpMeyW0EeuNPa1IYPTRDw_comment" wrap="virtual" class="textarea f-select-comment" style="display:none;"></textarea><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns  f-select1  s-valid  s-linked Dropdown _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMfSW0EeuNPa1IYPTRDw" extid="DLG_EmpNameOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DLG_EmpName" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label>ФИО*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input class="input" readonly="readonly"><ul>
                                                                                                                    <li><a class="fontawesome " href="#" ovalue=""></a></li>
                                                                                                                </ul>
                                                                                                                </div>
                                                                                                                <aside class="decorator fontawesome"></aside><textarea rows="1" type="text" name="_8jpMfSW0EeuNPa1IYPTRDw_comment" wrap="virtual" class="textarea f-select-comment" style="display:none;"></textarea><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMfyW0EeuNPa1IYPTRDw" extid="DLG_EmpLoginOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DLG_EmpLogin" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ab5">DLG_ Emp Login</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ab5" name="DLG_EmpLogin" value="" class="input" autocorrect="off" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMZyW0EeuNPa1IYPTRDw" extid="DeptNameOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DeptName" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ab6">Наименование подразделения*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ab6" name="DeptName" value="" class="input" autocorrect="off" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMaSW0EeuNPa1IYPTRDw" extid="EmpPositionOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="EmpPosition" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ab7">Должность*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ab7" name="EmpPosition" value="" class="input" autocorrect="off" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMayW0EeuNPa1IYPTRDw" extid="EmpNameOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="EmpName" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ab8">ФИО*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ab8" name="EmpName" value="" class="input" autocorrect="off" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMbSW0EeuNPa1IYPTRDw" extid="EmpLoginOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="EmpLogin" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ab9">Emp Login</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ab9" name="EmpLogin" value="" class="input" autocorrect="off" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMbyW0EeuNPa1IYPTRDw" extid="ResultOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="Result" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ac10">Результат</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ac10" name="Result" value="" class="input" autocorrect="off" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Date _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMcSW0EeuNPa1IYPTRDw" extid="DateToOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DateTo" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ac11">Срок ознакомления*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><hr class="ie-date-time-hr">
                                                                                                                <aside class="decorator fontawesome icon-calendar-empty"></aside>
                                                                                                                <div class="decorator facade dtdt" style=""><input id="w29254aab1b1b2b2b1b1b1ac11" name="DateTo" value="" class="input f-date" style="" type=""></div>
                                                                                                                <div class="decorator facade dttm" style="display: none;"><input name="DateTo-time" value="" class="input f-time" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome icon-time"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Date  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMcyW0EeuNPa1IYPTRDw" extid="DateNomOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DateNom" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ac12">Дата ознакомления</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><hr class="ie-date-time-hr">
                                                                                                                <aside class="decorator fontawesome icon-calendar-empty"></aside>
                                                                                                                <div class="decorator facade dtdt" style=""><input id="w29254aab1b1b2b2b1b1b1ac12" name="DateNom" value="" class="input f-date" style="" type=""><span class="f-calendar fontawesome icon-calendar"></span></div>
                                                                                                                <div class="decorator facade dttm" style="display: none;"><input name="DateNom-time" value="" class="input f-time" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome icon-time"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_8jpMdSW0EeuNPa1IYPTRDw" extid="CommentOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="Comment" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ac13">Комментарий*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ac13" name="Comment" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMdyW0EeuNPa1IYPTRDw" extid="DLG_IdDevOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DLG_IdDev" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ac14">DLG_ Id Dev</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ac14" name="DLG_IdDev" value="" class="input" autocorrect="off" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMgSW0EeuNPa1IYPTRDw" extid="DLG_ResultOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DLG_Result" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ac15">DLG_ Result</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ac15" name="DLG_Result" value="" class="input" autocorrect="off" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Date  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMgyW0EeuNPa1IYPTRDw" extid="DLG_DateToOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DLG_DateTo" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ac16">DLG_ Date To</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><hr class="ie-date-time-hr">
                                                                                                                <aside class="decorator fontawesome icon-calendar-empty"></aside>
                                                                                                                <div class="decorator facade dtdt" style=""><input id="w29254aab1b1b2b2b1b1b1ac16" name="DLG_DateTo" value="" class="input f-date" style="" type=""><span class="f-calendar fontawesome icon-calendar"></span></div>
                                                                                                                <div class="decorator facade dttm" style="display: none;"><input name="DLG_DateTo-time" value="" class="input f-time" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome icon-time"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Date  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMhSW0EeuNPa1IYPTRDw" extid="DLG_DateNomOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DLG_DateNom" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ac17">DLG_ Date Nom</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><hr class="ie-date-time-hr">
                                                                                                                <aside class="decorator fontawesome icon-calendar-empty"></aside>
                                                                                                                <div class="decorator facade dtdt" style=""><input id="w29254aab1b1b2b2b1b1b1ac17" name="DLG_DateNom" value="" class="input f-date" style="" type=""><span class="f-calendar fontawesome icon-calendar"></span></div>
                                                                                                                <div class="decorator facade dttm" style="display: none;"><input name="DLG_DateNom-time" value="" class="input f-time" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome icon-time"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed " style="" id="_8jpMhyW0EeuNPa1IYPTRDw" extid="DLG_CommentOnFamiliarize" rcid="_8jpMYiW0EeuNPa1IYPTRDw" cname="DLG_Comment" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b1b1b1ac18">DLG_ Comment</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b1b1b1ac18" name="DLG_Comment" value="" class="input" autocorrect="off" style="" type=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                    </tr>
                                                                                                    </tbody>
                                                                                                </table><span class="f-status f-table-status" style="display:none;"><span></span></span></div>
                                                                                            <div class="b-droppable clearfix"></div>
                                                                                        </div>
                                                                                        </div>
                                                                                        <div class="b-droppable clearfix"></div>
                                                                                    </div>
                                                                                    <div class="f-control  f-section  s-valid  s-linked Section clearfix  s-expanded _BQESgSWlEeuNPa1IYPTRDw s-typed  s-not-signable " style="" id="_G270pyWlEeuNPa1IYPTRDw" extid="OnFamiliarizeHistory" cname="OnFamiliarize">
                                                                                        <div class="h-section clearfix s-not-expandable" title=""><span class="f-expand"></span><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label>История ознакомления</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                 <div class="c-helpcontent"></div>
                                                                              </div></span><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                        <div class="c-section clearfix"><span class="f-info" style="display:none;">Перетащите элементы управления из палитры или формы.</span><div class="f-control f-table s-valid s-linked Table clearfix s-expanded s-disabled" style="" minoccurs="0" maxoccurs="32767" id="_G270qSWlEeuNPa1IYPTRDw" extid="RepeatRecord" cname="RepeatRecord">
                                                                                            <div class="h-table clearfix" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label>Repeat Record</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                            <div class="c-table clearfix">
                                                                                                <table border="0" cellpadding="0" cellspacing="0">
                                                                                                    <thead>
                                                                                                    <tr class="f-table-head s-valid" id="_HtpxdSW2EeuNPa1IYPTRDw">
                                                                                                        <th class="first-column data-not-column"></th>
                                                                                                        <th class="data-not-column"></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_HtpxeyW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>Dev Phase</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_HtpxgSW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>Наименование подразделения</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_HtpxhyW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>Должность</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_HtpxjSW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>ФИО</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_HtpxkyW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>Emp Login</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_HtpxmSW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>Должность делегирования</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_HtpxnyW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>ФИО делегирования</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_HtpxpSW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>Статус</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_HtpxqyW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>Срок ознакомления*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_HtpxsSW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>Дата ознакомления</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed " id="_HtpxtyW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>Комментарий</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_HtpxvSW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>DLG_ Id Dev</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_HtpxwyW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>DLG_ Dept Name</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_HtqYVSW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>DLG_ Emp Login</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_HtqYWyW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>DLG_ Result</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_HtqYYSW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>DLG_ Date To</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_HtqYZyW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>DLG_ Date Nom</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                        <th style="" class="data-column f-table-column-head s-typed  s-invisible " id="_HtqYbSW2EeuNPa1IYPTRDw" title=""><span class="f-label" style=""><label>DLG_ Comment</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                   <div class="c-helpcontent"></div>
                                                                                                </div></span></th>
                                                                                                    </tr>
                                                                                                    </thead>
                                                                                                    <tbody>
                                                                                                    <tr  class="f-table-row s-expanded s-linked s-typed s-valid" rcid="_G270qSWlEeuNPa1IYPTRDw">
                                                                                                        <td class="add-column data-not-column"><span class="f-add fontawesome icon-plus-sign"></span></td>
                                                                                                        <td class="remove-column data-not-column"><span class="f-remove fontawesome icon-minus-sign"></span></td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270rCWlEeuNPa1IYPTRDw" extid="DevPhase" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DevPhase" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ab1">Dev Phase</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input  name="DevPhase" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270riWlEeuNPa1IYPTRDw" extid="DeptNameOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DeptName" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ab2">Наименование подразделения</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input name="DeptName" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270sCWlEeuNPa1IYPTRDw" extid="EmpPositionOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="EmpPosition" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ab3">Должность</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input  name="EmpPosition" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270siWlEeuNPa1IYPTRDw" extid="EmpNameOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="EmpName" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ab4">ФИО</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input  name="EmpName" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270tCWlEeuNPa1IYPTRDw" extid="EmpLoginOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="EmpLogin" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ab5">Emp Login</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input  name="EmpLogin" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270wiWlEeuNPa1IYPTRDw" extid="DLG_EmpPositionOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DLG_EmpPosition" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ab6">Должность делегирования</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input  name="DLG_EmpPosition" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270xCWlEeuNPa1IYPTRDw" extid="DLG_EmpNameOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DLG_EmpName" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ab7">ФИО делегирования</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input  name="DLG_EmpName" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270tiWlEeuNPa1IYPTRDw" extid="ResultOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="Result" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ab8">Статус</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input name="Result" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Date s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270uCWlEeuNPa1IYPTRDw" extid="DateToOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DateTo" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ab9">Срок ознакомления*</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><hr class="ie-date-time-hr">
                                                                                                                <aside class="decorator fontawesome icon-calendar-empty"></aside>
                                                                                                                <div class="decorator facade dtdt" style=""><input  name="DateTo" value="" class="input f-date" style="" type="" disabled=""><span class="f-calendar fontawesome icon-calendar"></span></div>
                                                                                                                <div class="decorator facade dttm" style="display: none;"><input name="DateTo-time" value="" class="input f-time" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome icon-time"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Date _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270uiWlEeuNPa1IYPTRDw" extid="DateNomOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DateNom" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ac10">Дата ознакомления</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><hr class="ie-date-time-hr">
                                                                                                                <aside class="decorator fontawesome icon-calendar-empty"></aside>
                                                                                                                <div class="decorator facade dtdt" style=""><input id="w29254aab1b1b2b2b2b1b1ac10" name="DateNom" value="" class="input f-date" style="" type="" disabled=""></div>
                                                                                                                <div class="decorator facade dttm" style="display: none;"><input name="DateNom-time" value="" class="input f-time" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome icon-time"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270vCWlEeuNPa1IYPTRDw" extid="CommentOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="Comment" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ac11">Комментарий</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ac11" name="Comment" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270viWlEeuNPa1IYPTRDw" extid="DLG_IdDevOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DLG_IdDev" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ac12">DLG_ Id Dev</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input id="w29254aab1b1b2b2b2b1b1ac12" name="DLG_IdDev" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270wCWlEeuNPa1IYPTRDw" extid="DLG_DeptNameOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DLG_DeptName" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ac13">DLG_ Dept Name</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input  name="DLG_DeptName" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="_G270xiWlEeuNPa1IYPTRDw" extid="DLG_EmpLoginOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DLG_EmpLogin" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ac14">DLG_ Emp Login</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input  name="DLG_EmpLogin" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="1017944b-022a-432c-9ac1-ad1792e4759d" extid="DLG_ResultOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DLG_Result" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ac15">DLG_ Result</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input  name="DLG_Result" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Date s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="f510d8fc-07ee-43f7-a2d1-f4ffe79425ff" extid="DLG_DateToOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DLG_DateTo" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ac16">DLG_ Date To</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><hr class="ie-date-time-hr">
                                                                                                                <aside class="decorator fontawesome icon-calendar-empty"></aside>
                                                                                                                <div class="decorator facade dtdt" style=""><input  name="DLG_DateTo" value="" class="input f-date" style="" type="" disabled=""><span class="f-calendar fontawesome icon-calendar"></span></div>
                                                                                                                <div class="decorator facade dttm" style="display: none;"><input name="DLG_DateTo-time" value="" class="input f-time" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome icon-time"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Date s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="e1734fbd-77a2-4f92-9147-570381edab4e" extid="DLG_DateNomOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DLG_DateNom" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ac17">DLG_ Date Nom</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><hr class="ie-date-time-hr">
                                                                                                                <aside class="decorator fontawesome icon-calendar-empty"></aside>
                                                                                                                <div class="decorator facade dtdt" style=""><input  name="DLG_DateNom" value="" class="input f-date" style="" type="" disabled=""><span class="f-calendar fontawesome icon-calendar"></span></div>
                                                                                                                <div class="decorator facade dttm" style="display: none;"><input name="DLG_DateNom-time" value="" class="input f-time" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome icon-time"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                        <td valign="top" class="data-column  s-invisible ">
                                                                                                            <div class="f-control Twelve columns f-input s-valid s-linked Text s-invisible _BQESgSWlEeuNPa1IYPTRDw s-typed s-disabled" style="" id="d876f8bd-43eb-4959-9deb-2dc0c80111d3" extid="DLG_CommentOnFamiliarizeH" rcid="_G270qSWlEeuNPa1IYPTRDw" cname="DLG_Comment" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w29254aab1b1b2b2b2b1b1ac18">DLG_ Comment</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                                      <div class="c-helpcontent"></div>
                                                                                                   </div></span><aside class="decorator fontawesome"></aside>
                                                                                                                <div class="decorator facade" style=""><input  name="DLG_Comment" value="" class="input" autocorrect="off" style="" type="" disabled=""></div>
                                                                                                                <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span></span></span></div>
                                                                                                        </td>
                                                                                                    </tr>
                                                                                                    </tbody>
                                                                                                </table><span class="f-status f-table-status" style="display:none;"><span></span></span></div>
                                                                                            <div class="b-droppable clearfix"></div>
                                                                                        </div>
                                                                                        </div>
                                                                                        <div class="b-droppable clearfix"></div>
                                                                                    </div>

                                                                                </div>

                                                                        </div>
                                                                        </div>

                                                                      <div class="c-section clearfix"><span class="f-info" style="display:none;">Перетащите элементы управления из палитры или формы.</span>
                                                                      </div>


                                                                    </div>


                                                                </div>

                                                            <div class="f-control  f-section  s-valid  s-linked Section clearfix  s-expanded  s-untyped  s-not-signable " style="" id="__-cZNjiVEeul7dO-Gm5pSA" extid="historyRec2" cname="historyRec2">
                                                                <div class="h-section clearfix s-not-expandable" title=""><span class="f-expand"></span><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label>История изменений</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                  <div class="c-helpcontent"></div>
                                                               </div></span><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                <div class="c-section clearfix"><span class="f-info" style="display:none;">Перетащите элементы управления из палитры или формы.</span><div class="f-control  f-table s-valid s-linked Table clearfix  s-expanded " style="" minoccurs="15" maxoccurs="15" id="_1d5yyTiVEeul7dO-Gm5pSA" extid="HistoryChangeTable" cname="HistoryChangeTable">
                                                                    <div class="h-table clearfix" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label>Table 1272</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                        <div class="c-helpcontent"></div>
                                                                     </div></span><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                    <div class="c-table clearfix">
                                                                        <table border="0" cellpadding="0" cellspacing="0">
                                                                            <thead>
                                                                            <tr class="f-table-head" id="_1d5y3ziVEeul7dO-Gm5pSA">
                                                                                <th style="" class="data-column f-table-column-head s-untyped " id="_1d5y4TiVEeul7dO-Gm5pSA" title=""><span class="f-label" style=""><label>Название атрибута</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                    <div class="c-helpcontent"></div>
                                                                                 </div></span></th>
                                                                                <th style="" class="data-column f-table-column-head s-untyped " id="_1d5y4ziVEeul7dO-Gm5pSA" title=""><span class="f-label" style=""><label>Значение атрибута пред.</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                    <div class="c-helpcontent"></div>
                                                                                 </div></span></th>
                                                                                <th style="" class="data-column f-table-column-head s-untyped " id="_1d5y5TiVEeul7dO-Gm5pSA" title=""><span class="f-label" style=""><label>Значение атрибута изм.</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                    <div class="c-helpcontent"></div>
                                                                                 </div></span></th>
                                                                                <th style="" class="data-column f-table-column-head s-untyped " id="_2qm2XTiVEeul7dO-Gm5pSA" title=""><span class="f-label" style=""><label>Дата изменения</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                    <div class="c-helpcontent"></div>
                                                                                 </div></span></th>
                                                                                <th style="" class="data-column f-table-column-head s-untyped " id="_3FvTLTiVEeul7dO-Gm5pSA" title=""><span class="f-label" style=""><label>Пользователь</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                    <div class="c-helpcontent"></div>
                                                                                 </div></span></th>
                                                                            </tr>
                                                                            </thead>
                                                                            <tbody>
                                                                            <tr id="_1d5yzziVEeul7dO-Gm5pSA" class="f-table-row s-expanded s-linked s-untyped" rcid="_1d5yyTiVEeul7dO-Gm5pSA">
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_1d5y0ziVEeul7dO-Gm5pSA" extid="attributeName2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeName2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1ab1">Название атрибута</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1ab1" name="attributeName2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_1d5y1ziVEeul7dO-Gm5pSA" extid="attributeValuePrev2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeValuePrev2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1ab2">Значение атрибута пред.</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1ab2" name="attributeValuePrev2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_1d5y2ziVEeul7dO-Gm5pSA" extid="attributeValueChanged2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeValueChanged2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1ab3">Значение атрибута изм.</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1ab3" name="attributeValueChanged2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Date  s-disabled  s-untyped " style="" id="_2qm2VjiVEeul7dO-Gm5pSA" extid="changingDate2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="changingDate2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1ab4">Дата изменения</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><div class="decorator facade" style=""><pre id="w173630aab1b2b1b1ab4" name="changingDate2" class="input wrap" wrap="virtual" style="" type="text"></pre></div><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_3FvTJjiVEeul7dO-Gm5pSA" extid="user2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="user2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1ab5">Пользователь</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style="border-style:none !important;"><pre id="w173630aab1b2b1b1ab5" name="user2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                            </tr>
                                                                            <tr id="_2CgUiDiVEeul7dO-Gm5pSA" class="f-table-row s-expanded s-linked s-untyped" rcid="_1d5yyTiVEeul7dO-Gm5pSA">
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_2CgUijiVEeul7dO-Gm5pSA" extid="attributeName2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeName2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b1b1">Название атрибута</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1b1b1" name="attributeName2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_2CgUjDiVEeul7dO-Gm5pSA" extid="attributeValuePrev2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeValuePrev2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b1b2">Значение атрибута пред.</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1b1b2" name="attributeValuePrev2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_2CgUjjiVEeul7dO-Gm5pSA" extid="attributeValueChanged2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeValueChanged2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b1b3">Значение атрибута изм.</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1b1b3" name="attributeValueChanged2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Date  s-disabled  s-untyped " style="" id="_2qm2YDiVEeul7dO-Gm5pSA" extid="changingDate2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="changingDate2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b1b4">Дата изменения</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><div class="decorator facade" style=""><pre id="w173630aab1b2b1b1b1b4" name="changingDate2" class="input wrap" wrap="virtual" style="" type="text"></pre></div><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_3FvTMDiVEeul7dO-Gm5pSA" extid="user2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="user2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b1b5">Пользователь</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style="border-style:none !important;"><pre id="w173630aab1b2b1b1b1b5" name="user2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                            </tr>
                                                                            <tr id="_2CS5KDiVEeul7dO-Gm5pSA" class="f-table-row s-expanded s-linked s-untyped" rcid="_1d5yyTiVEeul7dO-Gm5pSA">
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_2CS5KjiVEeul7dO-Gm5pSA" extid="attributeName2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeName2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b2b1">Название атрибута</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1b2b1" name="attributeName2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_2CS5LDiVEeul7dO-Gm5pSA" extid="attributeValuePrev2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeValuePrev2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b2b2">Значение атрибута пред.</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1b2b2" name="attributeValuePrev2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_2CS5LjiVEeul7dO-Gm5pSA" extid="attributeValueChanged2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeValueChanged2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b2b3">Значение атрибута изм.</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1b2b3" name="attributeValueChanged2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Date  s-disabled  s-untyped " style="" id="_2qm2ZDiVEeul7dO-Gm5pSA" extid="changingDate2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="changingDate2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b2b4">Дата изменения</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><div class="decorator facade" style=""><pre id="w173630aab1b2b1b1b2b4" name="changingDate2" class="input wrap" wrap="virtual" style="" type="text"></pre></div><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_3FvTNDiVEeul7dO-Gm5pSA" extid="user2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="user2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b2b5">Пользователь</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style="border-style:none !important;"><pre id="w173630aab1b2b1b1b2b5" name="user2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                            </tr>
                                                                            <tr id="_2CGE2DiVEeul7dO-Gm5pSA" class="f-table-row s-expanded s-linked s-untyped" rcid="_1d5yyTiVEeul7dO-Gm5pSA">
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_2CGE2jiVEeul7dO-Gm5pSA" extid="attributeName2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeName2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b3b1">Название атрибута</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1b3b1" name="attributeName2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_2CGE3DiVEeul7dO-Gm5pSA" extid="attributeValuePrev2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeValuePrev2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b3b2">Значение атрибута пред.</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1b3b2" name="attributeValuePrev2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_2CGE3jiVEeul7dO-Gm5pSA" extid="attributeValueChanged2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeValueChanged2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b3b3">Значение атрибута изм.</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1b3b3" name="attributeValueChanged2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Date  s-disabled  s-untyped " style="" id="_2qm2aDiVEeul7dO-Gm5pSA" extid="changingDate2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="changingDate2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b3b4">Дата изменения</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><div class="decorator facade" style=""><pre id="w173630aab1b2b1b1b3b4" name="changingDate2" class="input wrap" wrap="virtual" style="" type="text"></pre></div><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_3Fv6MjiVEeul7dO-Gm5pSA" extid="user2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="user2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b3b5">Пользователь</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style="border-style:none !important;"><pre id="w173630aab1b2b1b1b3b5" name="user2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                            </tr>
                                                                            <tr id="_2B53mDiVEeul7dO-Gm5pSA" class="f-table-row s-expanded s-linked s-untyped" rcid="_1d5yyTiVEeul7dO-Gm5pSA">
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_2B53mjiVEeul7dO-Gm5pSA" extid="attributeName2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeName2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b4b1">Название атрибута</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1b4b1" name="attributeName2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_2B53nDiVEeul7dO-Gm5pSA" extid="attributeValuePrev2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeValuePrev2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b4b2">Значение атрибута пред.</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1b4b2" name="attributeValuePrev2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_2B53njiVEeul7dO-Gm5pSA" extid="attributeValueChanged2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeValueChanged2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b4b3">Значение атрибута изм.</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1b4b3" name="attributeValueChanged2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Date  s-disabled  s-untyped " style="" id="_2qm2bDiVEeul7dO-Gm5pSA" extid="changingDate2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="changingDate2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b4b4">Дата изменения</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><div class="decorator facade" style=""><pre id="w173630aab1b2b1b1b4b4" name="changingDate2" class="input wrap" wrap="virtual" style="" type="text"></pre></div><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_3Fv6NjiVEeul7dO-Gm5pSA" extid="user2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="user2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b4b5">Пользователь</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style="border-style:none !important;"><pre id="w173630aab1b2b1b1b4b5" name="user2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                            </tr>
                                                                            <tr id="_2Bp_-DiVEeul7dO-Gm5pSA" class="f-table-row s-expanded s-linked s-untyped" rcid="_1d5yyTiVEeul7dO-Gm5pSA">
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_2Bp_-jiVEeul7dO-Gm5pSA" extid="attributeName2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeName2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b5b1">Название атрибута</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1b5b1" name="attributeName2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_2Bp__DiVEeul7dO-Gm5pSA" extid="attributeValuePrev2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeValuePrev2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b5b2">Значение атрибута пред.</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1b5b2" name="attributeValuePrev2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_2Bp__jiVEeul7dO-Gm5pSA" extid="attributeValueChanged2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeValueChanged2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b5b3">Значение атрибута изм.</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1b5b3" name="attributeValueChanged2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Date  s-disabled  s-untyped " style="" id="_2qm2cDiVEeul7dO-Gm5pSA" extid="changingDate2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="changingDate2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b5b4">Дата изменения</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><div class="decorator facade" style=""><pre id="w173630aab1b2b1b1b5b4" name="changingDate2" class="input wrap" wrap="virtual" style="" type="text"></pre></div><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_3Fv6OjiVEeul7dO-Gm5pSA" extid="user2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="user2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b5b5">Пользователь</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style="border-style:none !important;"><pre id="w173630aab1b2b1b1b5b5" name="user2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                            </tr>
                                                                            <tr id="_2BbWeDiVEeul7dO-Gm5pSA" class="f-table-row s-expanded s-linked s-untyped" rcid="_1d5yyTiVEeul7dO-Gm5pSA">
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_2BbWejiVEeul7dO-Gm5pSA" extid="attributeName2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeName2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b6b1">Название атрибута</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1b6b1" name="attributeName2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_2BbWfDiVEeul7dO-Gm5pSA" extid="attributeValuePrev2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeValuePrev2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b6b2">Значение атрибута пред.</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1b6b2" name="attributeValuePrev2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_2BbWfjiVEeul7dO-Gm5pSA" extid="attributeValueChanged2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeValueChanged2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b6b3">Значение атрибута изм.</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1b6b3" name="attributeValueChanged2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Date  s-disabled  s-untyped " style="" id="_2qm2dDiVEeul7dO-Gm5pSA" extid="changingDate2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="changingDate2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b6b4">Дата изменения</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><div class="decorator facade" style=""><pre id="w173630aab1b2b1b1b6b4" name="changingDate2" class="input wrap" wrap="virtual" style="" type="text"></pre></div><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_3Fv6PjiVEeul7dO-Gm5pSA" extid="user2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="user2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b6b5">Пользователь</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style="border-style:none !important;"><pre id="w173630aab1b2b1b1b6b5" name="user2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                            </tr>
                                                                            <tr id="_2BK3yDiVEeul7dO-Gm5pSA" class="f-table-row s-expanded s-linked s-untyped" rcid="_1d5yyTiVEeul7dO-Gm5pSA">
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_2BK3yjiVEeul7dO-Gm5pSA" extid="attributeName2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeName2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b7b1">Название атрибута</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1b7b1" name="attributeName2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_2BK3zDiVEeul7dO-Gm5pSA" extid="attributeValuePrev2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeValuePrev2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b7b2">Значение атрибута пред.</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1b7b2" name="attributeValuePrev2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_2BK3zjiVEeul7dO-Gm5pSA" extid="attributeValueChanged2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeValueChanged2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b7b3">Значение атрибута изм.</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1b7b3" name="attributeValueChanged2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Date  s-disabled  s-untyped " style="" id="_2qm2eDiVEeul7dO-Gm5pSA" extid="changingDate2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="changingDate2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b7b4">Дата изменения</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><div class="decorator facade" style=""><pre id="w173630aab1b2b1b1b7b4" name="changingDate2" class="input wrap" wrap="virtual" style="" type="text"></pre></div><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_3Fv6QjiVEeul7dO-Gm5pSA" extid="user2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="user2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b7b5">Пользователь</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style="border-style:none !important;"><pre id="w173630aab1b2b1b1b7b5" name="user2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                            </tr>
                                                                            <tr id="_2A8OSDiVEeul7dO-Gm5pSA" class="f-table-row s-expanded s-linked s-untyped" rcid="_1d5yyTiVEeul7dO-Gm5pSA">
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_2A8OSjiVEeul7dO-Gm5pSA" extid="attributeName2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeName2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b8b1">Название атрибута</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1b8b1" name="attributeName2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_2A8OTDiVEeul7dO-Gm5pSA" extid="attributeValuePrev2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeValuePrev2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b8b2">Значение атрибута пред.</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1b8b2" name="attributeValuePrev2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_2A8OTjiVEeul7dO-Gm5pSA" extid="attributeValueChanged2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeValueChanged2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b8b3">Значение атрибута изм.</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1b8b3" name="attributeValueChanged2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Date  s-disabled  s-untyped " style="" id="_2qm2fDiVEeul7dO-Gm5pSA" extid="changingDate2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="changingDate2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b8b4">Дата изменения</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><div class="decorator facade" style=""><pre id="w173630aab1b2b1b1b8b4" name="changingDate2" class="input wrap" wrap="virtual" style="" type="text"></pre></div><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_3Fv6RjiVEeul7dO-Gm5pSA" extid="user2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="user2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b8b5">Пользователь</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style="border-style:none !important;"><pre id="w173630aab1b2b1b1b8b5" name="user2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                            </tr>
                                                                            <tr id="_2AtkyDiVEeul7dO-Gm5pSA" class="f-table-row s-expanded s-linked s-untyped" rcid="_1d5yyTiVEeul7dO-Gm5pSA">
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_2AtkyjiVEeul7dO-Gm5pSA" extid="attributeName2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeName2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b9b1">Название атрибута</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1b9b1" name="attributeName2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_2AtkzDiVEeul7dO-Gm5pSA" extid="attributeValuePrev2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeValuePrev2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b9b2">Значение атрибута пред.</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1b9b2" name="attributeValuePrev2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_2AtkzjiVEeul7dO-Gm5pSA" extid="attributeValueChanged2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeValueChanged2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b9b3">Значение атрибута изм.</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1b9b3" name="attributeValueChanged2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Date  s-disabled  s-untyped " style="" id="_2qm2gDiVEeul7dO-Gm5pSA" extid="changingDate2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="changingDate2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b9b4">Дата изменения</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><div class="decorator facade" style=""><pre id="w173630aab1b2b1b1b9b4" name="changingDate2" class="input wrap" wrap="virtual" style="" type="text"></pre></div><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_3Fv6SjiVEeul7dO-Gm5pSA" extid="user2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="user2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1b9b5">Пользователь</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style="border-style:none !important;"><pre id="w173630aab1b2b1b1b9b5" name="user2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                            </tr>
                                                                            <tr id="_2AdtKDiVEeul7dO-Gm5pSA" class="f-table-row s-expanded s-linked s-untyped" rcid="_1d5yyTiVEeul7dO-Gm5pSA">
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_2AdtKjiVEeul7dO-Gm5pSA" extid="attributeName2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeName2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1c10b1">Название атрибута</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1c10b1" name="attributeName2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_2AdtLDiVEeul7dO-Gm5pSA" extid="attributeValuePrev2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeValuePrev2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1c10b2">Значение атрибута пред.</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1c10b2" name="attributeValuePrev2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_2AdtLjiVEeul7dO-Gm5pSA" extid="attributeValueChanged2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeValueChanged2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1c10b3">Значение атрибута изм.</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1c10b3" name="attributeValueChanged2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Date  s-disabled  s-untyped " style="" id="_2qm2hDiVEeul7dO-Gm5pSA" extid="changingDate2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="changingDate2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1c10b4">Дата изменения</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><div class="decorator facade" style=""><pre id="w173630aab1b2b1b1c10b4" name="changingDate2" class="input wrap" wrap="virtual" style="" type="text"></pre></div><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_3Fv6TjiVEeul7dO-Gm5pSA" extid="user2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="user2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1c10b5">Пользователь</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style="border-style:none !important;"><pre id="w173630aab1b2b1b1c10b5" name="user2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                            </tr>
                                                                            <tr id="_2APDqDiVEeul7dO-Gm5pSA" class="f-table-row s-expanded s-linked s-untyped" rcid="_1d5yyTiVEeul7dO-Gm5pSA">
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_2APDqjiVEeul7dO-Gm5pSA" extid="attributeName2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeName2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1c11b1">Название атрибута</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1c11b1" name="attributeName2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_2APDrDiVEeul7dO-Gm5pSA" extid="attributeValuePrev2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeValuePrev2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1c11b2">Значение атрибута пред.</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1c11b2" name="attributeValuePrev2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_2APDrjiVEeul7dO-Gm5pSA" extid="attributeValueChanged2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeValueChanged2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1c11b3">Значение атрибута изм.</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1c11b3" name="attributeValueChanged2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Date  s-disabled  s-untyped " style="" id="_2qm2iDiVEeul7dO-Gm5pSA" extid="changingDate2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="changingDate2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1c11b4">Дата изменения</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><div class="decorator facade" style=""><pre id="w173630aab1b2b1b1c11b4" name="changingDate2" class="input wrap" wrap="virtual" style="" type="text"></pre></div><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_3Fv6UjiVEeul7dO-Gm5pSA" extid="user2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="user2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1c11b5">Пользователь</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style="border-style:none !important;"><pre id="w173630aab1b2b1b1c11b5" name="user2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                            </tr>
                                                                            <tr id="_2ABBNjiVEeul7dO-Gm5pSA" class="f-table-row s-expanded s-linked s-untyped" rcid="_1d5yyTiVEeul7dO-Gm5pSA">
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_2ABBODiVEeul7dO-Gm5pSA" extid="attributeName2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeName2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1c12b1">Название атрибута</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1c12b1" name="attributeName2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_2ABBOjiVEeul7dO-Gm5pSA" extid="attributeValuePrev2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeValuePrev2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1c12b2">Значение атрибута пред.</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1c12b2" name="attributeValuePrev2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_2ABBPDiVEeul7dO-Gm5pSA" extid="attributeValueChanged2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeValueChanged2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1c12b3">Значение атрибута изм.</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1c12b3" name="attributeValueChanged2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Date  s-disabled  s-untyped " style="" id="_2qm2jDiVEeul7dO-Gm5pSA" extid="changingDate2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="changingDate2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1c12b4">Дата изменения</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><div class="decorator facade" style=""><pre id="w173630aab1b2b1b1c12b4" name="changingDate2" class="input wrap" wrap="virtual" style="" type="text"></pre></div><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_3Fv6VjiVEeul7dO-Gm5pSA" extid="user2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="user2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1c12b5">Пользователь</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style="border-style:none !important;"><pre id="w173630aab1b2b1b1c12b5" name="user2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                            </tr>
                                                                            <tr id="_1d7AwDiVEeul7dO-Gm5pSA" class="f-table-row s-expanded s-linked s-untyped" rcid="_1d5yyTiVEeul7dO-Gm5pSA">
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_1d7AwjiVEeul7dO-Gm5pSA" extid="attributeName2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeName2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1c13b1">Название атрибута</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1c13b1" name="attributeName2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_1d7AxDiVEeul7dO-Gm5pSA" extid="attributeValuePrev2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeValuePrev2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1c13b2">Значение атрибута пред.</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1c13b2" name="attributeValuePrev2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_1d7AxjiVEeul7dO-Gm5pSA" extid="attributeValueChanged2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeValueChanged2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1c13b3">Значение атрибута изм.</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1c13b3" name="attributeValueChanged2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Date  s-disabled  s-untyped " style="" id="_2qndYDiVEeul7dO-Gm5pSA" extid="changingDate2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="changingDate2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1c13b4">Дата изменения</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><div class="decorator facade" style=""><pre id="w173630aab1b2b1b1c13b4" name="changingDate2" class="input wrap" wrap="virtual" style="" type="text"></pre></div><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_3Fv6WjiVEeul7dO-Gm5pSA" extid="user2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="user2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1c13b5">Пользователь</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style="border-style:none !important;"><pre id="w173630aab1b2b1b1c13b5" name="user2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                            </tr>
                                                                            <tr id="_1d-EGDiVEeul7dO-Gm5pSA" class="f-table-row s-expanded s-linked s-untyped" rcid="_1d5yyTiVEeul7dO-Gm5pSA">
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_1d-EGjiVEeul7dO-Gm5pSA" extid="attributeName2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeName2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1c14b1">Название атрибута</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1c14b1" name="attributeName2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_1d-EHDiVEeul7dO-Gm5pSA" extid="attributeValuePrev2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeValuePrev2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1c14b2">Значение атрибута пред.</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1c14b2" name="attributeValuePrev2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_1d-EHjiVEeul7dO-Gm5pSA" extid="attributeValueChanged2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="attributeValueChanged2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1c14b3">Значение атрибута изм.</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style=""><pre id="w173630aab1b2b1b1c14b3" name="attributeValueChanged2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Date  s-disabled  s-untyped " style="" id="_2qndZDiVEeul7dO-Gm5pSA" extid="changingDate2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="changingDate2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1c14b4">Дата изменения</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><div class="decorator facade" style=""><pre id="w173630aab1b2b1b1c14b4" name="changingDate2" class="input wrap" wrap="virtual" style="" type="text"></pre></div><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                                <td valign="top" class="data-column  s-disabled ">
                                                                                    <div class="f-control Twelve columns  f-input  s-valid  s-linked Text  s-disabled  s-untyped " style="" id="_3Fv6XjiVEeul7dO-Gm5pSA" extid="user2" rcid="_1d5yyTiVEeul7dO-Gm5pSA" cname="user2" title=""><span class="f-add fontawesome icon-plus-sign"></span><span class="f-remove fontawesome icon-minus-sign"></span><span class="f-label" style=""><label for="w173630aab1b2b1b1c14b5">Пользователь</label><span class="f-required"></span><span class="f-help fontawesome icon-info-sign "></span><div class="f-helpcontent" style="display:none">
                                                                                       <div class="c-helpcontent"></div>
                                                                                    </div></span><aside class="decorator fontawesome"></aside>
                                                                                        <div class="decorator facade" style="border-style:none !important;"><pre id="w173630aab1b2b1b1c14b5" name="user2" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                                                        <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>
                                                                                </td>
                                                                            </tr>
                                                                            </tbody>
                                                                        </table><span class="f-status f-table-status" style="display:none;"><span>(n)</span></span></div>
                                                                    <div class="b-droppable clearfix"></div>
                                                                </div>
                                                                </div>
                                                                <div class="b-droppable clearfix"></div>
                                                            </div>


                                                                <div class="b-droppable clearfix"></div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                <div id="preview-overlay" class="overlay"></div>
                                            </form>
                                            <script language="JavaScript">
                                                try {
                                                    if (parent.TaskPoller)
                                                        parent.TaskPoller.refresh();
                                                } catch (e) {
                                                }
                                            </script>
                                            <div id="frevvo-form-footer" class="f-form-footer" style=""><span
                                                    id="frevvo-logo"></span></div>
                                            <div xmlns:flows="java:com.frevvo.flows.util.FlowsUtil"
                                                 xmlns:fgenadapter="java:com.gauss.forms.flow.formgen.FormGenerationAdapter"
                                                 xmlns:futil="java:com.frevvo.locale.FrevvoLocaleResolver"
                                                 id="gen-forms-view"
                                                 class="gen-forms-view clearfix"
                                                 style="display:none;">
                                                <ul id="fgen-top-bar">
                                                    <li class="fgen-top-name"><span class="app-top-navbar-desc">Формы, созданные для этой формы.</span>
                                                    </li>
                                                    <li class="fgen-top-item"><a id="a-new-fgen"
                                                                                 class="a-new-fgen editor-icon fontawesome icon-plus-sign"
                                                                                 href="#"><span
                                                            class="fgen-top-navbar-desc">Создать</span></a></li>
                                                </ul>
                                                <div id="no-fgen-message">Для этой формы не настроены созданные
                                                    формы.<br/>Нажмите на кнопку "Создать", чтобы настроить параметры
                                                    создания других форм.
                                                </div>
                                            </div>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </td>
                <td id="right-cell">
                    <div id="right" class="column">
                        <div id="right-content"></div>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
    <span id="a-invisible-span"></span></div>
</c:if>


<div id="f-help-display" style="display:none;">
    <div class="f-help-display-content"></div>
    <div class="f-help-display-close fontawesome icon-remove"></div>
</div>
<div id="overlay"></div>


<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/popper/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/js/reestr.js"></script>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Vic.Feng
  Date: 17/11/2015
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<html xmlns='http://www.w3.org/1999/xhtml'>
<head><title>RealTime /FM Ticket And Task Management</title>
    <jsp:include flush="true" page="/WEB-INF/pages/common.jsp"/>
</head>
<body id='srs_standard'>
<div align='justify'>
    <table cellspacing='0' width='100%' border='0' cellpadding='0'>
        <jsp:include flush="true" page="/WEB-INF/pages/common/header.jsp"/>
        <tr>
            <td valign='top'>
                <jsp:include flush="true" page="/WEB-INF/pages/common/menu_asset.jsp"/>
            </td>

            <td valign='top' width='100%'>
                <table cellspacing='0' width='100%' border='0' cellpadding='0'>
                    <tr>
                        <td class='messagebox'><span id='message'>Please add new details and click 'Add'.</span></td>
                    </tr>
                    <tr>
                        <td>
                            <form accept-charset='UNKNOWN' id='tabForm' method='post' name='tabForm' action='Dispatcher'
                                  enctype='application/x-www-form-urlencoded'>
                                <ul id='menu'>
                                    <li><a href='/asset/searchPage'>Search</a></li>
                                    <li class='current'>Add Asset</li>
                                </ul>
                                <input name='nvcm' type='hidden' value=';'/></form>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <table id='Green_TabContentTable' cellspacing='0' class='TabTable' cellpadding='0'>
                                <tr>
                                    <td><span><span><form accept-charset='UNKNOWN' id='AssetForm' method='post'
                                                          name='AssetForm' action='Dispatcher'
                                                          enctype='multipart/form-data'>
                                        <style type='text/css'>.type-file-box {
                                            position: relative;
                                            width: 260px
                                        }

                                        .type-file-file {
                                            position: absolute;
                                            top: 0;
                                            left: 0;
                                            height: 24px;
                                            filter: alpha(opacity:0);
                                            opacity: 0;
                                            width: 220px
                                        }</style>
                                        <script type='text/javascript' language='Javascript'>$(function () {
                                            var textButton = "<input type='text' name='textfield' id='textfield' class='inputtext'/><input type='button' name='button' id='button' value='Browse' />"
                                            $(textButton).insertBefore("#AttachmentId");
                                            $("#AttachmentId").change(function () {
                                                $("#textfield").val($("#AttachmentId").val());
                                            });
                                        });</script>
                                        <table width='100%' style='' border='0'>
                                            <tr>
                                                <td class='spokesoft_srs_th'>Asset Reference (*)</td>
                                                <td colspan='3' class='spokesoft_srs_tbody'><input class='inputtext'
                                                                                                   id='Reference'
                                                                                                   name='Reference'
                                                                                                   maxlength='50'
                                                                                                   value='' size='50'
                                                                                                   type='text'/></td>
                                            </tr>
                                            <tr>
                                                <td class='spokesoft_srs_th'>Description (*)</td>
                                                <td colspan='3' class='spokesoft_srs_tbody'><input class='inputtext'
                                                                                                   id='Description'
                                                                                                   name='Description'
                                                                                                   maxlength='200'
                                                                                                   value='' size='80'
                                                                                                   type='text'/></td>
                                            </tr>
                                            <tr>
                                                <td class='spokesoft_srs_th'>Customer Account (*)</td>
                                                <td colspan='3' class='spokesoft_srs_tbody'><select
                                                        onchange="javascript:AssetForm.nvcm.value='RootContext_330'; document.AssetForm.submit();"
                                                        id='CustomerAccount' class='inputtext' name='CustomerAccount'>
                                                    <option selected='selected' value='-1' label='Select an Account'>
                                                        Select an Account
                                                    </option>
                                                    <option value='429' label='100 Stephens green'>100 Stephens green
                                                    </option>
                                                    <option value='431' label='2 Harbourmaster place'>2 Harbourmaster
                                                        place
                                                    </option>
                                                    <option value='432' label='2 South anne street'>2 South anne
                                                        street
                                                    </option>
                                                    <option value='433' label='2/4/6/8 Landsdowne Road'>2/4/6/8
                                                        Landsdowne Road
                                                    </option>
                                                    <option value='584' label='24/26 City Quay '>24/26 City Quay
                                                    </option>
                                                    <option value='435' label='35-39 Shelbourne road'>35-39 Shelbourne
                                                        road
                                                    </option>
                                                    <option value='437' label='52 Broomhill'>52 Broomhill</option>
                                                    <option value='438' label='74 Pembroke Square'>74 Pembroke Square
                                                    </option>
                                                    <option value='440' label='80 Harcourt Street'>80 Harcourt Street
                                                    </option>
                                                    <option value='441' label='Abbey court apartments'>Abbey court
                                                        apartments
                                                    </option>
                                                    <option value='442' label='ABN Amro'>ABN Amro</option>
                                                    <option value='251'
                                                            label='Aegon UK Corporate Services Ltd (Irish Branch)'>Aegon
                                                        UK Corporate Services Ltd (Irish Branch)
                                                    </option>
                                                    <option value='129' label='Agilent Technologies'>Agilent
                                                        Technologies
                                                    </option>
                                                    <option value='645' label='AIB'>AIB</option>
                                                    <option value='631' label='Alexion Pharma International Trading'>
                                                        Alexion Pharma International Trading
                                                    </option>
                                                    <option value='635' label='Allcare Management Service Ltd'>Allcare
                                                        Management Service Ltd
                                                    </option>
                                                    <option value='106' label='An Bord Pleanala'>An Bord Pleanala
                                                    </option>
                                                    <option value='449' label='Anima Asset Management Ltd'>Anima Asset
                                                        Management Ltd
                                                    </option>
                                                    <option value='214' label='APV'>APV</option>
                                                    <option value='270' label='Aramark / Spokesoft Technologies'>Aramark
                                                        / Spokesoft Technologies
                                                    </option>
                                                    <option value='587' label='Aramark Food Services'>Aramark Food
                                                        Services
                                                    </option>
                                                    <option value='254' label='Aramark Healthcare'>Aramark Healthcare
                                                    </option>
                                                    <option value='275' label='Aramark Property'>Aramark Property
                                                    </option>
                                                    <option value='102' label='Aramark Workplace Solutions'>Aramark
                                                        Workplace Solutions
                                                    </option>
                                                    <option value='278' label='Arqiva Ltd'>Arqiva Ltd</option>
                                                    <option value='218' label='Arup Consulting Engineers'>Arup
                                                        Consulting Engineers
                                                    </option>
                                                    <option value='443' label='Ashtown Gate Business Park'>Ashtown Gate
                                                        Business Park
                                                    </option>
                                                    <option value='136' label='AXA'>AXA</option>
                                                    <option value='428' label='Ballymun Leisure Centre'>Ballymun Leisure
                                                        Centre
                                                    </option>
                                                    <option value='591' label='Bar Council'>Bar Council</option>
                                                    <option value='266' label='Barnardos'>Barnardos</option>
                                                    <option value='451' label='Beacon Court'>Beacon Court</option>
                                                    <option value='452' label='Beacon South Quarter Management Ltd'>
                                                        Beacon South Quarter Management Ltd
                                                    </option>
                                                    <option value='226' label='Biffa'>Biffa</option>
                                                    <option value='221' label='Blackrock Properties'>Blackrock
                                                        Properties
                                                    </option>
                                                    <option value='189' label='Blanchardstown Corporate Park'>
                                                        Blanchardstown Corporate Park
                                                    </option>
                                                    <option value='454' label='Block 1 Booterstown'>Block 1
                                                        Booterstown
                                                    </option>
                                                    <option value='457' label='Booterstown Public Areas'>Booterstown
                                                        Public Areas
                                                    </option>
                                                    <option value='627' label='Bord Gais'>Bord Gais</option>
                                                    <option value='648' label='Breastcheck'>Breastcheck</option>
                                                    <option value='458' label='BRENNANS INSURANCES'>BRENNANS
                                                        INSURANCES
                                                    </option>
                                                    <option value='110' label='Broadcasting Authority of Ireland'>
                                                        Broadcasting Authority of Ireland
                                                    </option>
                                                    <option value='620' label='Brothers of Charity Southern Services'>
                                                        Brothers of Charity Southern Services
                                                    </option>
                                                    <option value='103' label='Brown Thomas'>Brown Thomas</option>
                                                    <option value='169' label='BT Facilities Services'>BT Facilities
                                                        Services
                                                    </option>
                                                    <option value='168' label='BT Facilities Services Euro'>BT
                                                        Facilities Services Euro
                                                    </option>
                                                    <option value='626' label='BTFS'>BTFS</option>
                                                    <option value='660' label='CBRE'>CBRE</option>
                                                    <option value='224'
                                                            label='Central Bank & Financial Services of Ireland'>Central
                                                        Bank & Financial Services of Ireland
                                                    </option>
                                                    <option value='227' label='Certus'>Certus</option>
                                                    <option value='464' label='Chancery Hall'>Chancery Hall</option>
                                                    <option value='632' label='CMS Belfast'>CMS Belfast</option>
                                                    <option value='634' label='Coca-cola HBC Ireland Ltd'>Coca-cola HBC
                                                        Ireland Ltd
                                                    </option>
                                                    <option value='469' label='Comreg'>Comreg</option>
                                                    <option value='248' label='Convention Centre '>Convention Centre
                                                    </option>
                                                    <option value='470' label='Coolock retail park'>Coolock retail
                                                        park
                                                    </option>
                                                    <option value='243' label='Cork City Council (Irish Estates)'>Cork
                                                        City Council (Irish Estates)
                                                    </option>
                                                    <option value='200' label='Cork County Council'>Cork County
                                                        Council
                                                    </option>
                                                    <option value='267' label='Cork County Hall'>Cork County Hall
                                                    </option>
                                                    <option value='638' label='Currency Fair'>Currency Fair</option>
                                                    <option value='471' label='Custom House Plaza 2'>Custom House Plaza
                                                        2
                                                    </option>
                                                    <option value='472' label='Dame Street'>Dame Street</option>
                                                    <option value='161' label='Damovo Ireland Limited'>Damovo Ireland
                                                        Limited
                                                    </option>
                                                    <option value='233' label='Debenhams Retail PLC'>Debenhams Retail
                                                        PLC
                                                    </option>
                                                    <option value='241'
                                                            label="Denis and Dan O'Flynn (Irish Estates Cork)">Denis and
                                                        Dan O'Flynn (Irish Estates Cork)
                                                    </option>
                                                    <option value='474' label='Department of Transport'>Department of
                                                        Transport
                                                    </option>
                                                    <option value='475' label='Dexia'>Dexia</option>
                                                    <option value='271' label='DLR Leisure Services Ltd'>DLR Leisure
                                                        Services Ltd
                                                    </option>
                                                    <option value='600' label='Dodderbank'>Dodderbank</option>
                                                    <option value='593' label='Dublin Port'>Dublin Port</option>
                                                    <option value='476' label='Duetsche Bank'>Duetsche Bank</option>
                                                    <option value='477' label='E-bookers'>E-bookers</option>
                                                    <option value='163' label='EBS'>EBS</option>
                                                    <option value='196' label='EirGrid'>EirGrid</option>
                                                    <option value='225' label='Elavon'>Elavon</option>
                                                    <option value='659' label='Elavon Brussels (Syncada Europe BVBA).'>
                                                        Elavon Brussels (Syncada Europe BVBA).
                                                    </option>
                                                    <option value='590' label='Elavon Germany Helpdesk'>Elavon Germany
                                                        Helpdesk
                                                    </option>
                                                    <option value='588' label='Elavon Poland'>Elavon Poland</option>
                                                    <option value='658' label='Elavon Quintillion Limited'>Elavon
                                                        Quintillion Limited
                                                    </option>
                                                    <option value='263' label='ELAVON UK'>ELAVON UK</option>
                                                    <option value='198' label='EMC'>EMC</option>
                                                    <option value='647' label='ENET'>ENET</option>
                                                    <option value='646' label='Enterprise Ireland'>Enterprise Ireland
                                                    </option>
                                                    <option value='139' label='Equality Commission Northern Ireland'>
                                                        Equality Commission Northern Ireland
                                                    </option>
                                                    <option value='644' label='ESB'>ESB</option>
                                                    <option value='185' label='European Commission '>European
                                                        Commission
                                                    </option>
                                                    <option value='170' label='Eye and Ear Hospital'>Eye and Ear
                                                        Hospital
                                                    </option>
                                                    <option value='624' label='Failte Ireland'>Failte Ireland</option>
                                                    <option value='613' label='FAS Athlone'>FAS Athlone</option>
                                                    <option value='612' label='FAS Baldoyle'>FAS Baldoyle</option>
                                                    <option value='609' label='FAS Ballyfermot'>FAS Ballyfermot</option>
                                                    <option value='606' label='FAS Carrigaline'>FAS Carrigaline</option>
                                                    <option value='597' label='FAS CORK'>FAS CORK</option>
                                                    <option value='610' label='Fas Finglas '>Fas Finglas</option>
                                                    <option value='607' label='FAS Kilcohan'>FAS Kilcohan</option>
                                                    <option value='614' label='FAS Limerick '>FAS Limerick</option>
                                                    <option value='608' label='FAS Loughlinstown'>FAS Loughlinstown
                                                    </option>
                                                    <option value='615' label='FAS Shannon'>FAS Shannon</option>
                                                    <option value='611' label='Fas Tallaght'>Fas Tallaght</option>
                                                    <option value='616' label='FAS Tralee'>FAS Tralee</option>
                                                    <option value='596' label='FAS WATERFORD'>FAS WATERFORD</option>
                                                    <option value='594' label='FAS WEXFORD'>FAS WEXFORD</option>
                                                    <option value='649' label='Fexco'>Fexco</option>
                                                    <option value='261' label='Finglas Leisure Centre'>Finglas Leisure
                                                        Centre
                                                    </option>
                                                    <option value='480'
                                                            label='Finsbury Hse 79-81 Pembroke road Ballsbridge'>
                                                        Finsbury Hse 79-81 Pembroke road Ballsbridge
                                                    </option>
                                                    <option value='637' label='Firstcare Nursing Ireland'>Firstcare
                                                        Nursing Ireland
                                                    </option>
                                                    <option value='236' label='Fitzpatrick'>Fitzpatrick</option>
                                                    <option value='484' label='Food Safety Authority'>Food Safety
                                                        Authority
                                                    </option>
                                                    <option value='486' label='Fortis'>Fortis</option>
                                                    <option value='487' label='Gael Linn'>Gael Linn</option>
                                                    <option value='488' label='GAM'>GAM</option>
                                                    <option value='629' label='Gartner Ireland Limited'>Gartner Ireland
                                                        Limited
                                                    </option>
                                                    <option value='625' label='Genzyme Ireland'>Genzyme Ireland</option>
                                                    <option value='489' label='GEORGES COURT'>GEORGES COURT</option>
                                                    <option value='490' label='Georges Quay Mgmt Ltd'>Georges Quay Mgmt
                                                        Ltd
                                                    </option>
                                                    <option value='152' label='Gilead Sciences Ireland UC'>Gilead
                                                        Sciences Ireland UC
                                                    </option>
                                                    <option value='111' label='Google (Ireland)'>Google (Ireland)
                                                    </option>
                                                    <option value='494' label='Hainault House'>Hainault House</option>
                                                    <option value='495' label='Hambleden House'>Hambleden House</option>
                                                    <option value='497' label='Hanover Quay'>Hanover Quay</option>
                                                    <option value='201' label='Health Service Executive'>Health Service
                                                        Executive
                                                    </option>
                                                    <option value='138' label='Hewlett Packard Manufacturing Ltd'>
                                                        Hewlett Packard Manufacturing Ltd
                                                    </option>
                                                    <option value='173' label='Honeywell Aerospace Ireland Ltd'>
                                                        Honeywell Aerospace Ireland Ltd
                                                    </option>
                                                    <option value='650' label='HSBC'>HSBC</option>
                                                    <option value='498' label='Hume House'>Hume House</option>
                                                    <option value='137' label='IAA'>IAA</option>
                                                    <option value='651' label='ICON'>ICON</option>
                                                    <option value='209' label='IDA'>IDA</option>
                                                    <option value='633' label='IFAC'>IFAC</option>
                                                    <option value='501' label='IFSC South Block Limited'>IFSC South
                                                        Block Limited
                                                    </option>
                                                    <option value='504' label='Ilac centre'>Ilac centre</option>
                                                    <option value='643' label='Independent News & Media'>Independent
                                                        News & Media
                                                    </option>
                                                    <option value='636' label='Innovative Interfaces Inc'>Innovative
                                                        Interfaces Inc
                                                    </option>
                                                    <option value='250' label='Intel Ireland'>Intel Ireland</option>
                                                    <option value='506' label='IPC Leddington Limited'>IPC Leddington
                                                        Limited
                                                    </option>
                                                    <option value='511' label='Irish Life Assurance plc'>Irish Life
                                                        Assurance plc
                                                    </option>
                                                    <option value='512' label='Irish Life Common'>Irish Life Common
                                                    </option>
                                                    <option value='514' label='Irish Life International'>Irish Life
                                                        International
                                                    </option>
                                                    <option value='279' label='Iron Planet'>Iron Planet</option>
                                                    <option value='578' label='IT Carlow'>IT Carlow</option>
                                                    <option value='159' label="Japanese Ambassador's Residence">Japanese
                                                        Ambassador's Residence
                                                    </option>
                                                    <option value='212' label='KBC'>KBC</option>
                                                    <option value='517' label='KBC Finance Ireland'>KBC Finance
                                                        Ireland
                                                    </option>
                                                    <option value='579' label='KBC House'>KBC House</option>
                                                    <option value='657' label='Kennedy Law'>Kennedy Law</option>
                                                    <option value='519' label='KPMG'>KPMG</option>
                                                    <option value='520' label='Landsdowne House'>Landsdowne House
                                                    </option>
                                                    <option value='219' label='Lansdowne Old Wesley'>Lansdowne Old
                                                        Wesley
                                                    </option>
                                                    <option value='522' label='Law reform commision'>Law reform
                                                        commision
                                                    </option>
                                                    <option value='630' label='Liffey Meats'>Liffey Meats</option>
                                                    <option value='187' label='Maersk'>Maersk</option>
                                                    <option value='652' label='Marymount'>Marymount</option>
                                                    <option value='603' label='Merrion Village Mgt	'>Merrion Village
                                                        Mgt
                                                    </option>
                                                    <option value='252' label='MITIE Technical FM'>MITIE Technical FM
                                                    </option>
                                                    <option value='171' label='Most Management'>Most Management</option>
                                                    <option value='525' label='NCB Stockbrokers Limited'>NCB
                                                        Stockbrokers Limited
                                                    </option>
                                                    <option value='258' label='NIBRT Institute'>NIBRT Institute</option>
                                                    <option value='528' label='Novartis'>Novartis</option>
                                                    <option value='257' label='NSAI'>NSAI</option>
                                                    <option value='623' label='O2'>O2</option>
                                                    <option value='530' label='Orix Aviation'>Orix Aviation</option>
                                                    <option value='531' label='Park Rite Ltd'>Park Rite Ltd</option>
                                                    <option value='534' label='Pavilion Commercial 1 and 2'>Pavilion
                                                        Commercial 1 and 2
                                                    </option>
                                                    <option value='604' label='Pavillions Residential'>Pavillions
                                                        Residential
                                                    </option>
                                                    <option value='194' label='Permanent TSB'>Permanent TSB</option>
                                                    <option value='538' label='Pobal'>Pobal</option>
                                                    <option value='539' label='Poppintree Ind Estate'>Poppintree Ind
                                                        Estate
                                                    </option>
                                                    <option value='540' label='Portobello Dock'>Portobello Dock</option>
                                                    <option value='541' label='Price Water House Coopers'>Price Water
                                                        House Coopers
                                                    </option>
                                                    <option value='256' label='PRONI'>PRONI</option>
                                                    <option value='653' label='Q Logic'>Q Logic</option>
                                                    <option value='543' label='Raglan Hall'>Raglan Hall</option>
                                                    <option value='273' label='Ritz Carlton'>Ritz Carlton</option>
                                                    <option value='544' label='Riverside 4'>Riverside 4</option>
                                                    <option value='268' label='Royal Sun Alliance'>Royal Sun Alliance
                                                    </option>
                                                    <option value='229' label='RSA (Road Safety Authority)'>RSA (Road
                                                        Safety Authority)
                                                    </option>
                                                    <option value='546' label='Sackville Court'>Sackville Court</option>
                                                    <option value='642' label='Salesforce'>Salesforce</option>
                                                    <option value='547' label='San Paolo'>San Paolo</option>
                                                    <option value='274' label='Sanofi'>Sanofi</option>
                                                    <option value='622' label='SCOR'>SCOR</option>
                                                    <option value='548' label='Scottish Provident'>Scottish Provident
                                                    </option>
                                                    <option value='549' label='Seabank Court'>Seabank Court</option>
                                                    <option value='255' label='Segrave House'>Segrave House</option>
                                                    <option value='654' label='SEI Investment'>SEI Investment</option>
                                                    <option value='640' label='Sisters of St Louis'>Sisters of St
                                                        Louis
                                                    </option>
                                                    <option value='621' label='SONI'>SONI</option>
                                                    <option value='552' label='St Edmonds'>St Edmonds</option>
                                                    <option value='553' label='St Finians Apts'>St Finians Apts</option>
                                                    <option value='555' label='St Peters Square'>St Peters Square
                                                    </option>
                                                    <option value='160' label='St. Stephens Green House'>St. Stephens
                                                        Green House
                                                    </option>
                                                    <option value='1' label='Standard'>Standard</option>
                                                    <option value='589' label='Standard Life'>Standard Life</option>
                                                    <option value='556' label='Stephens Court'>Stephens Court</option>
                                                    <option value='557' label='Stephens Green House'>Stephens Green
                                                        House
                                                    </option>
                                                    <option value='655' label='Sumitrust'>Sumitrust</option>
                                                    <option value='134' label='Synopsys'>Synopsys</option>
                                                    <option value='561' label='The Broom Partnership'>The Broom
                                                        Partnership
                                                    </option>
                                                    <option value='639' label='The Chase Building'>The Chase Building
                                                    </option>
                                                    <option value='562' label='The Embassy of Japan'>The Embassy of
                                                        Japan
                                                    </option>
                                                    <option value='577' label='The English Market'>The English Market
                                                    </option>
                                                    <option value='563' label='The Nutley building'>The Nutley
                                                        building
                                                    </option>
                                                    <option value='564' label='The Spire'>The Spire</option>
                                                    <option value='565' label='The Sporting Emporium'>The Sporting
                                                        Emporium
                                                    </option>
                                                    <option value='124' label='Topaz (Shell Ireland Ltd)'>Topaz (Shell
                                                        Ireland Ltd)
                                                    </option>
                                                    <option value='165' label='Transaction Network Services'>Transaction
                                                        Network Services
                                                    </option>
                                                    <option value='656' label='Trinity Bio Tech'>Trinity Bio Tech
                                                    </option>
                                                    <option value='566' label='UBS Fund services'>UBS Fund services
                                                    </option>
                                                    <option value='228' label='Ulster Bank'>Ulster Bank</option>
                                                    <option value='567' label='Ulster Bank IFSC'>Ulster Bank IFSC
                                                    </option>
                                                    <option value='568' label='Ulster Bank, Georges Quay'>Ulster Bank,
                                                        Georges Quay
                                                    </option>
                                                    <option value='583' label='Valuation Office'>Valuation Office
                                                    </option>
                                                    <option value='662' label='vince01'>vince01</option>
                                                    <option value='570' label='Vision Consulting'>Vision Consulting
                                                    </option>
                                                    <option value='572' label='WEST LB'>WEST LB</option>
                                                    <option value='573' label='WEST PIER BUINESS CAMPUS'>WEST PIER
                                                        BUINESS CAMPUS
                                                    </option>
                                                    <option value='574' label='Westlink Industrial Estate'>Westlink
                                                        Industrial Estate
                                                    </option>
                                                    <option value='661' label='Westmooreland House'>Westmooreland
                                                        House
                                                    </option>
                                                    <option value='576' label='Woodford Business Park'>Woodford Business
                                                        Park
                                                    </option>
                                                    <option value='641' label='XL Services'>XL Services</option>
                                                </select><input id='AddAccountButton' value='Add Account'
                                                                class='pure-button' name='AddAccountButton'
                                                                onclick="window.location.href='/customerAccount/addPage'"
                                                                type='submit'/></td>
                                            </tr>
                                            <tr>
                                                <td class='spokesoft_srs_th'>Location (*)</td>
                                                <td colspan='3' class='spokesoft_srs_tbody'><span><select id='Location'
                                                                                                          name='Location'
                                                                                                          class='inputtext'>
                                                    <option value='-1' label='Please select an account.'>Please select
                                                        an account.
                                                    </option>
                                                </select></span></td>
                                            </tr>
                                            <tr>
                                                <td class='spokesoft_srs_th'>Group (*)</td>
                                                <td colspan="3" class='spokesoft_srs_tbody'>
                                                    <select id='AssetGroup'
                                                            name='AssetGroup'
                                                            class='inputtext'>
                                                        <option selected='selected' value='-1' label='No group'>No group
                                                        </option>
                                                    </select>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class='spokesoft_srs_th'>Manufacturer</td>
                                                <td colspan="3" class='spokesoft_srs_tbody'><input class='inputtext'
                                                                                                   id='Manufacturer'
                                                                                                   name='Manufacturer'
                                                                                                   maxlength='50'
                                                                                                   value='' size='30'
                                                                                                   type='text'/></td>
                                            </tr>
                                            <tr>
                                                <td class='spokesoft_srs_th'>Serial Number</td>
                                                <td colspan="3" class='spokesoft_srs_tbody'><input class='inputtext'
                                                                                                   id='SerialNumber'
                                                                                                   name='SerialNumber'
                                                                                                   maxlength='50'
                                                                                                   value='' size='30'
                                                                                                   type='text'/></td>
                                                </td>
                                            </tr>
                                        </table>
                                        <input id='UpdateButton' value='Add' class='pure-button' name='UpdateButton'
                                               onclick="submitInfo()"
                                               type='button'/></form><script
                                            language='Javascript'>var cal = Calendar.setup({
                                        animation: false,
                                        weekNumbers: true,
                                        fdow: 1,
                                        showTime: false,
                                        onSelect: function (cal, date) {
                                            this.hide();
                                            if (typeof (LastServicedTemp) != 'undefined') {
                                                LastServicedTemp = cal.selection.getDates()[0];
                                            }
                                            $('#LastServiced').change();
                                        }
                                    });
                                    cal.manageFields('LastServiced_trigger', 'LastServiced', '%d/%m/%Y');</script></span></span>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</div>
</body>
<script type="text/javascript">
    $.ajax({
        url: "/groups",
        type: 'GET',
        success: function (data) {
            $.each(data, function (i, value) {
                $("#AssetGroup").append("<option value='" + value.keyId + "'>" + value.name + "</option>");
            });
        },
    });

    function submitInfo() {

        if ($("#Reference").val() == "" || $("#Description").val() == "" || $("#Account").val() == "Please Choose" || $("#Location").val() == "Please Choose" || $("#Manufacturer").val() == "" || $("#SerialNumber").val() == "" || $("#AssetGroup").val() == "No group") {
            $("#message").text("Please select from available options AND empty field not allowed");
            setTimeout('$("#message").text("")', 2000);
        } else {
            $.ajax({
                url: "/asset",
                data: '{"assetReference":"' + $("#Reference").val() + '",' +
                ' "description":"' + $("#Description").val() + '",' + '"accountId":"1",' + ' "locationId":"1",' +
                '"manufacturer":"' + $("#Manufacturer").val() + '",' +
                '"serialNumber":"' + $("#SerialNumber").val() + '",' +
                ' "groupId":"' + $("#AssetGroup").val() + '"}',
                type: "POST",
                dataType: "json",
                contentType: "application/json",
                async: false,
                success: function (responseText) {
                    $("#info").text(responseText.message);

                    setTimeout('$("#message").text("")', 2000);
                },
                error: function () {
                    alert("Error");

                }
            });
        }
    }
</script>
</html>
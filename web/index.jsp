
<%@page import="java.io.OutputStream"%>
<%@page import="Models.Image"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>

        <meta charset="utf-8">

        <link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">
        <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
        <script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>

        <title>MyInstaGallery University Project</title>
        <meta charset="UTF-8" />

        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Item Blur Effect with CSS3 and jQuery - Using Box Shadows, Transform and Transitions" />
        <meta name="keywords" content="blur, css3, transition, jquery, box shadow, text shadow, articles, scale, transform, animation" />
        <meta name="author" content="Codrops" />
        <link rel="stylesheet" type="text/css" href="css/buttons.css" />
        <link rel="stylesheet" type="text/css" href="css/demo.css" />
        <link rel="stylesheet" type="text/css" href="css/style.css" />

        <script src="js/modernizr.custom.34978.js"></script>	



        <script>
            $(document).ready(function () {
                if (document.getElementById('data-toggle="disabledMsgButton"]') != null) {
                    $('[data-toggle="disabledMsgButton"]').tooltip();
                }
            });

            var openned = 0;
            setTimeout(function () {

                document.getElementById('ib-container2').style.display = "table";
                $("#ib-container2").animate({//top: "120%",
                    opacity: '1.0'}, 3000);
            }, 1500);
            function spinIconOff() {
                // setTimeout(function () {

                document.getElementsByClassName("message-box-icon")[0].style.display = "none";
                //  }, 1500);
            }
            function spinIconOn() {
                //   setTimeout(function () {

                document.getElementsByClassName("message-box-icon")[0].style.display = "block";
                //    }, 1500);
            }

            function lightsOff() {
                document.getElementById("galleryLights").style.display = "block";
                document.getElementById("galleryLights").style.opacity = "0.7";
                //$('#galleryLights').animate({opacity: "0.7"}, 1000);
            }
            function lightsOn() {

                document.getElementById("galleryLights").style.display = "none";
            }
            var activeMenu;
            var active;
            var opennedMenu = 0;
            function openMenuFrame(id, width, height) {
                if (id !== activeMenu) {

                    closeMenuFrame();
                    leaveImage();
                    activeMenu = id;
                    opennedMenu = 1;
                    if (id === "uploadImg") {
                        document.getElementById("uploadHeader").style.display = "none";
                        document.getElementById("uploadForm").style.display = "table";
                        document.getElementById("save").style.display = "table";
                    }
                    if (id === "findImages") {
                        document.getElementById("findImagesHeader").style.display = "none";
                        document.getElementById("SearchImagesForm").style.display = "table";
                        document.getElementById("searchButton").style.display = "table";
                    }
                    if (id === "findFriends") {
                        document.getElementById("findFriendsHeader").style.display = "none";
                        document.getElementById("SearchFriendsForm").style.display = "table";
                        document.getElementById("searchFriendsButton").style.display = "table";
                    }

                    document.getElementById(id).style.position = "absolute";
                    document.getElementById(id).style.left = "1%";
                    document.getElementById(id).style.top = "10%";
                    document.getElementById(id).style.background = "rgba(255,255,255,0.9)";
                    document.getElementById("closeMenuButton").style.visibility = "visible";

                    $('#' + id).animate({width: "200px",
                        height: "200px",
                        left: "50%",
                        marginLeft: "-100px", }, 800);

                    setTimeout(function () {
                        $('#' + id).animate({
                            top: "200%", }, 800);

                    }, 500);

                    if (id === "uploadImg") {
                        setTimeout(function () {
                            $('#save').animate({
                                top: "1900%",
                            }, 2000);
                        }, 1000);
                    }
                    if (id === "findImages") {
                        setTimeout(function () {
                            $('#searchButton').animate({
                                top: "1900%",
                            }, 2000);
                        }, 1000);
                    }
                    if (id === "findFriends") {
                        setTimeout(function () {
                            $('#searchFriendsButton').animate({
                                top: "1900%",
                            }, 2000);
                        }, 1000);
                    }
                }
            }

            function closeMenuFrame() {
                id = activeMenu;
                if (id != null) {
                    if (id === "uploadImg") {
                        document.getElementById("uploadHeader").style.display = "block";
                        document.getElementById("uploadForm").style.display = "none";
                    }
                    if (id === "findImages") {
                        document.getElementById("findImagesHeader").style.display = "block";
                        document.getElementById("SearchImagesForm").style.display = "none";
                    }
                    if (id === "findFriends") {
                        document.getElementById("findFriendsHeader").style.display = "block";
                        document.getElementById("SearchFriendsForm").style.display = "none";
                    }
                    opennedMenu = 0;


                    document.getElementById(id).style.position = "static";
                    document.getElementById(id).style.background = "rgba(255,255,255,0.5)";
                    document.getElementById("closeMenuButton").style.visibility = "hidden";

                    document.getElementById(id).style.marginLeft = "47px";
                    document.getElementById(id).style.width = "2.5px";
                    document.getElementById(id).style.height = "2.7px";

                    $('#' + id).animate({width: "140px",
                        height: '25px'}, 1000);

                    if (id === "uploadImg") {
                        setTimeout(function () {
                            $('#save').animate({
                                top: "4300%",
                            }, 2000);
                        }, 1000);
                        setTimeout(function () {
                            document.getElementById("save").style.display = "none";
                        }, 2500);

                    }
                    if (id === "findImages") {
                        setTimeout(function () {
                            $('#searchButton').animate({
                                top: "4300%",
                            }, 2000);
                        }, 1000);
                        setTimeout(function () {
                            document.getElementById("searchButton").style.display = "none";
                        }, 2500);

                    }
                    if (id === "findFriends") {
                        setTimeout(function () {
                            $('#searchFriendsButton').animate({
                                top: "4300%",
                            }, 2000);
                        }, 1000);
                        setTimeout(function () {
                            document.getElementById("searchFriendsButton").style.display = "none";
                        }, 2500);

                    }
                    activeMenu = null;
                }
            }







            function openImageFrame(id, height) {
                if (id !== active) {
                    oppened = 0;

                    leaveImage();
                    if (opennedMenu == 1) {
                        closeMenuFrame();
                    }
                    var idForm = id * 2.31111;
                    var idImg = id * 2.41111;
                    var idComN = id * 2.21111;
                    active = id;

                    height = document.getElementById(idComN).value;
                    if (typeof height === 'undefined') {
                        height = 5;
                    }
                    if (typeof idComN !== 'undefined') {
                        document.getElementById(idComN).style.display = "none";
                    }
                    var imgW = window.innerWidth / 4;
                    var imgH = window.innerHeight / 8;
                    if (typeof idImg !== 'undefined' && document.getElementById(idImg) != null) {
                        document.getElementById(idImg).style.clip = "auto";

                        var image = document.getElementById(idImg);
                        imgW = image.naturalWidth;
                        imgH = image.naturalHeight;

                        while (imgW > window.innerWidth * 0.5) {
                            imgW = imgW / 1.1;
                            imgH = imgH / 1.1;
                        }
                    }

                    document.getElementById(id).style.position = "absolute";
                    document.getElementById(id).style.margin = "auto";
                    document.getElementById(id).style.left = "0px";
                    document.getElementById(id).style.right = "0px";
                    document.getElementById(id).style.height = imgH / 50 + "px";
                    document.getElementById(id).style.width = imgW / 50 + "px";
                    document.getElementById("close").style.visibility = "visible";
                    if (typeof idImg !== 'undefined' && document.getElementById(idImg) != null) {
                        document.getElementById(idImg).style.width = imgW / 50 + "px";
                        document.getElementById(idImg).style.height = imgH / 50 + "px";
                    }
                    $('#' + id).animate({width: imgW,
                        height: 25 * (parseInt(height) + 10) + imgH,
                    }, 1000);
//                    $('#' + id).animate({width: imgW,
//                        height: 25 * (parseInt(height) + 10) + imgH,
//                        left: "50%",
//                        marginLeft: -imgW / 2, }, 1000);
                    setTimeout(function () {
                        document.getElementById(idForm).style.display = "table";
                        document.getElementById(idForm).style.marginTop = imgH + "px";
                    }, 500);
                    if (typeof idImg !== 'undefined' && document.getElementById(idImg) != null) {
                        setTimeout(function () {
                            document.getElementById(idImg).style.width = imgW + "px";
                            document.getElementById(idImg).style.height = imgH + "px";
                        }, 200);
                    }

                    $('body').scrollTop(0);

                } else {
                    oppened = 1;
                }

            }

            function leaveImage() {

                id = active;
                if (id != null && document.getElementById(id) != null) {
                    // setTimeout(function () {
                    var idForm = id * 2.31111;
                    var idImg = id * 2.41111;
                    var idComN = id * 2.21111;
                    var existingComN = document.getElementById(idComN);
                    if (existingComN != null) {
                        document.getElementById(idComN).style.display = "table";
                    }
                    document.getElementById("close").style.visibility = "hidden";
                    var image = document.getElementById(idImg);
                    if (image != null) {
                        var imgW = image.naturalWidth;
                        var imgH = image.naturalHeight;
                    }
                    while (imgW > 200) {
                        imgW = imgW / 1.1;
                        imgH = imgH / 1.1;
                    }

                    document.getElementById(id).style.margin = "15px";
                    if (typeof idImg !== 'undefined' && document.getElementById(idImg) != null) {
                        document.getElementById(idImg).style.width = imgW + "px";
                        document.getElementById(idImg).style.height = imgH + "px";
                        document.getElementById(idImg).style.clip = "rect(0px,200px,100px,0px)";
                        document.getElementById(idImg).style.position = "static";
                    }
                    document.getElementById(idForm).style.display = "none";
                    document.getElementById(id).style.position = "static";

                    document.getElementById(id).style.width = "10px";
                    document.getElementById(id).style.height = "7px";
                    document.getElementById(id).style.marginLeft = "47px";

                    $('#' + id).animate({width: "200px",
                        //left: "0%",
                        //marginLeft: "47px",
                        height: '140px'}, 1000);
                    if (typeof idImg !== 'undefined' && document.getElementById(idImg) != null) {
                        setTimeout(function () {
                            document.getElementById(idImg).style.position = "absolute";
                        }, 1000);
                    }
                    active = null;
                }
            }
            function increaseSizeCom(id) {
                var commentsCount = id * 2.21111;

                var h = document.getElementById(commentsCount).value;



                var idImg = id * 2.41111;
                var imgH = document.getElementById(idImg).style.height;
                newH = 25 * (parseInt(h) + 10) + parseInt(imgH);

                document.getElementById(id).style.height = newH + "px";

            }


        </script>








        <script type="text/javascript">
            //AJAX========================================================================================================================================
            function getXMLObject()  //XML OBJECT
            {
                var xmlHttp = false;
                try {
                    xmlHttp = new ActiveXObject("Msxml2.XMLHTTP")  // For Old Microsoft Browsers
                } catch (e) {
                    try {
                        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP")  // For Microsoft IE 6.0+
                    } catch (e2) {
                        xmlHttp = false   // No Browser accepts the XMLHTTP Object then false
                    }
                }
                if (!xmlHttp && typeof XMLHttpRequest != 'undefined') {
                    xmlHttp = new XMLHttpRequest(); //For Mozilla, Opera Browsers
                }
                return xmlHttp; // Mandatory Statement returning the ajax object created
            }

            var xmlhttp = new getXMLObject(); //xmlhttp holds the ajax object
            var commentsID;
            function ajaxAddComment(newCommentID, imgID) {
                var getdate = new Date(); //Used to prevent caching during ajax call
                if (xmlhttp) {

                    var comment = document.getElementById(newCommentID).value;
                    commentsID = "comments" + newCommentID;
                    xmlhttp.open("POST", "AddCommentServlet?comment=" + comment + "&imgID=" + imgID, true); //gettime will be the servlet name
                    xmlhttp.onreadystatechange = handleServerResponseComments;
                    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
                    xmlhttp.send();
                }
            }

            function ajaxOpenFrame(newCommentID, imgID) {

                if (oppened == 0) {
                    var getdate = new Date(); //Used to prevent caching during ajax call
                    if (xmlhttp) {

                        var comment = "";
                        commentsID = "comments" + newCommentID;
                        xmlhttp.open("POST", "AddCommentServlet?comment=" + comment + "&imgID=" + imgID, true); //gettime will be the servlet name
                        xmlhttp.onreadystatechange = handleServerResponseComments;
                        xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
                        xmlhttp.send();
                    }
                }
                openned = 1;
            }

            function handleServerResponseComments() {
                if (xmlhttp.readyState == 4) {
                    if (xmlhttp.status == 200) {
                        document.getElementById(commentsID).innerHTML = xmlhttp.responseText; //Update the HTML Form element
                    } else {
                        alert("Error during AJAX call. Please try again");
                    }
                }
            }


            function ajaxDeleteComment(imgID) {
                var getdate = new Date(); //Used to prevent caching during ajax call
                if (xmlhttp) {

                    var command = "delete";
                    xmlhttp.open("POST", "ImageOperationsServlet?command=" + command + "&imgID=" + imgID, true); //gettime will be the servlet name
                    xmlhttp.onreadystatechange = handleServerResponseDeleteImg;
                    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
                    xmlhttp.send();
                }
            }
            function handleServerResponseDeleteImg() {
                if (xmlhttp.readyState == 4) {
                    if (xmlhttp.status == 200) {
                        var resp = xmlhttp.responseText;
                        //alert(resp);
                        //document.getElementById(commentsID).innerHTML = xmlhttp.responseText; //Update the HTML Form element
                    } else {
                        alert("Error during AJAX call. Please try again");
                    }
                }
            }
            //comments count
            var xmlhttp2 = new getXMLObject(); //xmlhttp holds the ajax object

            var commentID2 = 0;
            function ajaxGetCommentsCount(imgID) {
                var getdate = new Date(); //Used to prevent caching during ajax call
                if (xmlhttp2) {

                    var command = "getCommentsCount";
                    commentID2 = imgID;
                    xmlhttp2.open("POST", "ImageOperationsServlet?command=" + command + "&imgID=" + imgID, true); //gettime will be the servlet name
                    xmlhttp2.onreadystatechange = handleServerGetCommentsCount;
                    xmlhttp2.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
                    xmlhttp2.send();
                }
            }
            function handleServerGetCommentsCount() {
                if (xmlhttp2.readyState == 4) {
                    if (xmlhttp2.status == 200) {
                        var resp = xmlhttp2.responseText;

                        id2 = commentID2 * 2.21111;
                        document.getElementById(id2).innerHTML = xmlhttp2.responseText;
                        document.getElementById(id2).value = xmlhttp2.responseText;//Update the HTML Form element
                    } else {
                        alert("Error during AJAX call. Please try again");
                    }
                }
            }
            //get gallery 
            var xmlhttp3 = new getXMLObject(); //xmlhttp holds the ajax object
            function ajaxGetGallery(usrID, tag) {


                var getdate = new Date(); //Used to prevent caching during ajax call
                if (xmlhttp3) {

                    xmlhttp3.open("POST", "GalleryServlet?userID=" + usrID + "&tag=" + tag, true); //gettime will be the servlet name
                    xmlhttp3.onreadystatechange = handleServerResponseGallery;
                    xmlhttp3.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
                    xmlhttp3.send();
                    spinIconOn()
                }


            }

            function handleServerResponseGallery() {
                if (xmlhttp3.readyState == 4) {
                    if (xmlhttp3.status == 200) {
                        document.getElementById("ib-container2").innerHTML = xmlhttp3.responseText; //Update the HTML Form element
                        spinIconOff();
                        galleryBlurEffect();
                    } else {
                        alert("Error during AJAX call. Please try again");
                    }
                }
            }
            //Upload Image
            var xmlhttp4 = new getXMLObject(); //xmlhttp holds the ajax object
            function ajaxUploadImage() {


                var getdate = new Date(); //Used to prevent caching during ajax call
                if (xmlhttp4) {
                    var form = document.getElementById("uploadFormOrg");
                    var photo = document.getElementById("photo");


                    var nametag = document.getElementById('nametag').value;
                    var type = document.getElementById('type').checked;
                    // alert(type);
                    var profile = document.getElementById('prof').checked;

                    var fd = new FormData();
                    fd.append("nametag", nametag);
                    fd.append("type", type);
                    fd.append("profile", profile);
                    fd.append("photo", photo.files[0]);

                    xmlhttp4.open("POST", "UploadImgServlet", true);
                    xmlhttp4.onreadystatechange = handleServerResponseUpload;
                    xmlhttp4.send(fd);

                    spinIconOn();
                }


            }

            function handleServerResponseUpload() {
                if (xmlhttp4.readyState == 4) {
                    if (xmlhttp4.status == 200) {




                        var req = xmlhttp4.responseText;
                        if (xmlhttp4.responseText == "") {
                            document.getElementById("uploadMsg").innerHTML = "<p style=\"color:red; \">No image Selected</p>";
                            spinIconOff();
                        } else {
                            $("#ib-container2").prepend(xmlhttp4.responseText);
                            spinIconOff();
                            document.getElementById("uploadMsg").innerHTML = "<p style=\"color:green; \">Successfuly Uploaded</p>";

                        }
                        galleryBlurEffect();
                        // document.getElementById("uploadMsg").innerHTML = xmlhttp4.responseText;

                        //document.getElementById("ib-container2").innerHTML = xmlhttp4.responseText+old_html;

                    } else {
                        alert("Error during AJAX call. Please try again");
                    }
                }
            }

//Search Image
            var xmlhttp5 = new getXMLObject(); //xmlhttp holds the ajax object
            function ajaxSearchImage() {


                var getdate = new Date(); //Used to prevent caching during ajax call
                if (xmlhttp5) {
                    var tag = document.getElementById('nametagSearch').value;
                    xmlhttp5.open("POST", "SearchImagesServlet?tag=" + tag, true); //gettime will be the servlet name
                    xmlhttp5.onreadystatechange = handleServerResponseSearchImage;
                    xmlhttp5.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
                    xmlhttp5.send();
                    spinIconOn()


                }


            }

            function handleServerResponseSearchImage() {
                if (xmlhttp5.readyState == 4) {
                    if (xmlhttp5.status == 200) {
                        document.getElementById("ib-container2").innerHTML = xmlhttp5.responseText; //Update the HTML Form element
                        spinIconOff();
                        galleryBlurEffect();

                    } else {
                        alert("Error during AJAX call. Please try again");
                    }
                }
            }



//Search Friends
            var xmlhttp6 = new getXMLObject(); //xmlhttp holds the ajax object
            function ajaxSearchFriend() {


                var getdate = new Date(); //Used to prevent caching during ajax call
                if (xmlhttp6) {
                    var username = document.getElementById('friendsSearchInput').value;
                    xmlhttp6.open("POST", "SearchFriendsServlet?username=" + username, true); //gettime will be the servlet name
                    xmlhttp6.onreadystatechange = handleServerResponseSearchFriend;
                    xmlhttp6.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
                    xmlhttp6.send();
                    spinIconOn()


                }


            }

            function handleServerResponseSearchFriend() {
                if (xmlhttp6.readyState == 4) {
                    if (xmlhttp6.status == 200) {
                        document.getElementById("ib-container2").innerHTML = xmlhttp6.responseText; //Update the HTML Form element
                        spinIconOff();
                        galleryBlurEffect();

                    } else {
                        alert("Error during AJAX call. Please try again");
                    }
                }
            }

            //Send Friend Request Friends
            var xmlhttp7 = new getXMLObject(); //xmlhttp holds the ajax object
            function ajaxSendFriendRequest(sender, receiver) {


                var getdate = new Date(); //Used to prevent caching during ajax call
                if (xmlhttp7) {
                    var username = document.getElementById('friendsSearchInput').value;
                    xmlhttp7.open("POST", "SendFriendRequestServlet?sender=" + sender + "&receiver=" + receiver, true); //gettime will be the servlet name
                    xmlhttp7.onreadystatechange = handleServerResponseSendFriendRequest;
                    xmlhttp7.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
                    xmlhttp7.send();
                    spinIconOn()


                }


            }

            function handleServerResponseSendFriendRequest() {
                if (xmlhttp7.readyState == 4) {
                    if (xmlhttp7.status == 200) {

                        var resp = xmlhttp7.responseText;
                        document.getElementById("dialog-3").innerHTML = resp;

                        $("#dialog-3").dialog({
                            autoOpen: false,
                            hide: "puff",
                            show: "slide",
                            height: 200
                        });
                        $("#dialog-3").dialog("open");
                        //document.getElementById("ib-container2").innerHTML = xmlhttp6.responseText; //Update the HTML Form element
                        spinIconOff();
                        //galleryBlurEffect();

                    } else {
                        alert("Error during AJAX call. Please try again");
                    }
                }
            }

            //AJAX========================================================================================================================================


            function deleteImgConf(id) {

                //  if (confirm("Are you Sure that you want to delete this image?") == true) {
                ajaxDeleteComment(id);
                document.getElementById(id).style.display = "none";
                //call ajax
                //} else {

                //}


            }


        </script>

    </head>
    <body onload="javascript:spinIconOff();">
        <%
            if (session.getAttribute("is_logged") == "True") {
        %>   
        <div id="dialog-3" title="Friend Request" style="display:none;">This my first jQuery UI Dialog!</div>


        <div class="container">
            <div class="header">
                <a href="http://tympanus.net/Tutorials/ExperimentsBackgroundClipText/">
                    <strong>User Guide for:</strong>MyInstaGallery
                </a>
                <span class="right">
                    <a href="http://tympanus.net/codrops/2011/12/14/item-blur-effect-with-css3-and-jquery/">
                        <strong><a  href="LogoutServlet"  >log out</a></strong>
                    </a>
                </span>
                <div class="clr"></div>
            </div>

            <section class="ib-container" id="ib-container" style="
                     position: absolute;
                     width:1140px;     
                     top:90%;  
                     left:0;
                     right:0;
                     margin-left:auto;
                     margin-right:auto;

                     opacity:1; display:table;" >




                <article onmouseover="javascript:lightsOff();" onmouseleave="javascript:lightsOn();" onclick="javascript:openMenuFrame('findImages', 0, 0)" id="findImages"  style="height:25px;margin-left:47px;">
                    <header> 

                        <header>
                            <h3 id="findImagesHeader"  style="font-size:1.3em;;margin: 0 auto; display:block; text-align: center;height:40px;padding-top:0px;">
                                Find images
                            </h3>
                            <div id="SearchImagesForm" style="display:none">
                                <div id="imgSearchMsg"  >
                                    Search Images by tag:
                                </div>
                                <br><input type="text" id="nametagSearch" name="nametagSearch"   placeholder="Nametag" size="50"/>
                            </div>
                        </header>

                        </form> 
                    </header>
                </article>
                <article onmouseover="javascript:lightsOff();" onmouseleave="javascript:lightsOn();"  onclick="javascript:openMenuFrame('profile', 400, 400)" id="profile"  style="height:25px;margin-left:47px;">
                    <header> 
                        <h3><a  href="#" style="font-size:1.3em;;margin: 0 auto; display:block; text-align: center;height:40px;padding-top:0px;">
                                My Profile</a>
                        </h3>

                    </header>
                </article>
                <article onmouseover="javascript:lightsOff();" onmouseleave="javascript:lightsOn();" onclick="javascript:openMenuFrame('uploadImg', 0, 0)" id="uploadImg" style="height:25px;margin-left:47px;margin-left:47px;">
                    <header>
                        <h3 id="uploadHeader"  style="font-size:1.3em;;margin: 0 auto; display:block; text-align: center;height:40px;padding-top:0px;">
                            Upload Image
                        </h3>
                        <div id="uploadForm" style="display:none">
                            <div id="uploadMsg"  >
                                Upload You Image here.
                            </div>

                            <form name="myForm"  method="post" action="UploadImageServlet" id="uploadFormOrg"    enctype="multipart/form-data" >
                                <br><input type="text" id="nametag" name="nametag"   placeholder="Nametag" size="50"/>
                                <br>
                                <table>
                                    <tr>
                                        <td>
                                            <br>
                                        </td> 

                                    </tr>
                                    <tr>
                                        <td>
                                            Public Pic:
                                        </td> 
                                        <td>
                                            <input type="checkbox" name="type" id="type"   checked="checked" style="width:35px;float:left;">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Profile Pic:
                                        </td> 
                                        <td>
                                            <input type="checkbox"  id="prof"   style="width:35px;float:left;">
                                        </td>
                                    </tr>
                                </table> 



                                <br><input type="file" name="photo" id="photo" size="50"/></td>

                            </form>
                        </div>
                    </header>
                </article>



                <article onmouseover="javascript:lightsOff();"onmouseleave="javascript:lightsOn();"  onclick="javascript:openMenuFrame('findFriends', 0, 0)" id="findFriends"  style="height:25px;margin-left:47px;">
                    <header>
                        <h3 id="findFriendsHeader"  style="font-size:1.3em;;margin: 0 auto; display:block; text-align: center;height:40px;padding-top:0px;">
                            Find Friends
                        </h3>
                        <div id="SearchFriendsForm" style="display:none">
                            <div id="friendsSearchMsg"  >
                                Search Friends by username:
                            </div>
                            <br><input type="text" id="friendsSearchInput"    placeholder="Username" size="50"/>
                        </div>
                    </header>
                </article>
                <article onclick="javascript:spinIconOn();
                        ajaxGetGallery('<%= session.getAttribute("user")%>', '');"  style="height:25px;margin-left:47px;">
                    <header> 
                        <h3><a  href="#" style="font-size:1.3em;;margin: 0 auto; display:block; text-align: center;height:40px;padding-top:0px;">Gallery</a></h3>

                    </header>
                </article>

            </section>

            <div style="position: absolute; width: 175px; height: 60px; left: 0px; right:0px;margin:auto;top: 4300%; display:none" id="save">
                <button onclick="javascript: ajaxUploadImage();"  class="button button--nina button--border-thin button--round-s" data-text="Save" id="myButton">
                    <span>S</span><span>a</span><span>v</span><span>e</span>  
                </button>
            </div>
            <div style="position: absolute; width: 175px; height: 60px; left: 0px; right:0px;margin:auto;top: 4300%; display:none" id="searchButton">
                <button onclick="javascript: ajaxSearchImage();"  class="button button--nina button--border-thin button--round-s" data-text="Search" id="myButton">
                    <span>S</span><span>e</span><span>a</span><span>r</span><span>c</span><span>h</span>  
                </button>
            </div>

            <div style="position: absolute; width: 175px; height: 60px; left: 0px; right:0px;margin:auto;top: 4300%; display:none" id="searchFriendsButton">
                <button onclick="javascript: ajaxSearchFriend();"  class="button button--nina button--border-thin button--round-s" data-text="Search" id="myButton">
                    <span>S</span><span>e</span><span>a</span><span>r</span><span>c</span><span>h</span>  
                </button>
            </div>












            <a href="#" id="close"             onclick="leaveImage();" style="position:absolute;color:white;left:0;right:0;visibility:hidden">Close</a>
            <a href="#" id="closeMenuButton"   onclick="closeMenuFrame();" style="position:absolute;color:white;left:0;right:0;visibility:hidden">Close</a>
            <div style=" position: absolute; z-index: 1; left:   0%; text-align: center;margin-top:-5%;  width:100%; " >

            </div>

            <hr style="position:absolute;top:550%;width:96%;left:50%;margin-left:-48%;">
            <div class="message-box-icon" style="position:absolute;top:1600%;z-index:10; display: block;left:0%;right:0%;margin:auto; " >

            </div>

            <section class="ib-container" id="ib-container2" style="
                     position: absolute;
                     width:100%;     
                     top:630%;  
                     left:0;
                     right:0;
                     margin-left:auto;
                     margin-right:auto;

                     opacity:0.1; display:none;" >

                <div id="galleryLights"   style="position:absolute;width:100%;height:100%;background-color:black;opacity:0.0;display:none"></div>
            </section>


            <script type="text/javascript">
                $(function () {

                    var $container = $('#ib-container'),
                            $articles = $container.children('article'),
                            timeout;
                    $articles.on('mouseenter', function (event) {

                        var $article = $(this);
                        clearTimeout(timeout);
                        timeout = setTimeout(function () {

                            if ($article.hasClass('active'))
                                return false;
                            $articles.not($article.removeClass('blur').addClass('active'))
                                    .removeClass('active')
                                    .addClass('blur');
                        }, 65);
                    });
                    $container.on('mouseleave', function (event) {

                        clearTimeout(timeout);
                        $articles.removeClass('active blur');
                    });
                });</script>

            <script type="text/javascript">
                function galleryBlurEffect() {

                    $(document).ready(function () {
                        var $container = $('#ib-container2'),
                                $articles = $container.children('article'),
                                timeout;
                        $articles.on('mouseenter', function (event) {

                            var $article = $(this);
                            clearTimeout(timeout);
                            timeout = setTimeout(function () {

                                if ($article.hasClass('active'))
                                    return false;
                                $articles.not($article.removeClass('blur').addClass('active'))
                                        .removeClass('active')
                                        .addClass('blur');
                            }, 65);
                        });
                        $container.on('mouseleave', function (event) {

                            clearTimeout(timeout);
                            $articles.removeClass('active blur');
                        });
                    }
                    );

                }
            </script>

            <%
            } else {
            %>   
            <script>
                window.location = "login.jsp";
            </script>
            <%
                }
            %> 


    </body>
</html>
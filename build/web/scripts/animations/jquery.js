/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function animateTop(top) {

    document.getElementById('ib-container').style.display = "table";
    $("#ib-container").animate({marginTop: top,
        opacity: '1.0'}, 2000);
}
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
        if (width == 0 && height == 0) {
            width = "200px";
            height = "200px";
        } else {
            width = width + "px";
            height = height + "px";
        }
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
        if (id === "profile") {
            document.getElementById("profileHeader").style.display = "none";
            document.getElementById("MyProfile").style.display = "table";
            document.getElementById("showMyFriends").style.display = "table";
            document.getElementById("showFriendRequest").style.display = "table";
        }

        document.getElementById(id).style.position = "absolute";
        document.getElementById(id).style.left = "1%";
        document.getElementById(id).style.top = "10%";
        document.getElementById(id).style.background = "rgba(255,255,255,0.9)";
        document.getElementById(id).style.marginLeft = "auto";
        document.getElementById(id).style.marginRight = "auto";
        document.getElementById("closeMenuButton").style.visibility = "visible";
        $('#' + id).animate({width: width,
            height: height,
            left: "0",
            right: "0",
        }, 800);
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
        if (id === "profile") {
            document.getElementById("profileHeader").style.display = "block";
            document.getElementById("MyProfile").style.display = "none";
            document.getElementById("showMyFriends").style.display = "none";
            document.getElementById("showFriendRequest").style.display = "none";
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

//blur effects
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
});
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

 
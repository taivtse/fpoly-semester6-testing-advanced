<%--
  Created by IntelliJ IDEA.
  User: vothanhtai - Date: 4/17/19 - Time: 15:23
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Connect Now</title>
    <link rel="icon" type="image/x-icon" href="/assets/images/favicon.png">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,600" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/assets/css/style-all.css">
    <link rel="stylesheet" type="text/css" href="/assets/css/style-home.css">
    <link rel="stylesheet" href="/assets/css/camera.css">
    <link rel="shortcut icon" type="image/png" href="images/favicon.png"/>
</head>

<body>
<header>
    <div class="container-fluid">
        <div class="row navbar-wrapper p-md-3">
            <nav class="navbar navbar-expand-md navbar-dark content-wrapper">
                <a class="navbar-brand" href="#">
                    <img src="/assets/images/ConnectNow-logo.png" alt="" style="width: 180px">
                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse justify-content-md-end" id="navbarSupportedContent">
                    <ul class="navbar-nav">
                        <li class="nav-item active">
                            <a class="nav-link text-content" href="#" id="btn-home">HOME <span
                                    class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-content" href="#" id="btn-about">ABOUT US</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-content" href="#" id="btn-tour">BEST TOUR</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-content" href="#" id="btn-destination">DESTINATION</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-content" href="#" id="btn-gallery">GALLERY</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-content" href="#" id="btn-register">REGISTER</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
        <div class="carousel-wrapper row">
            <div class="camera_wrap" id="camera_wrap">
                <div data-src="/assets/images/bg_header1.jpg"></div>
                <div data-src="/assets/images/bg_header2.jpg"></div>
                <div data-src="/assets/images/bg_header3.jpg"></div>
                <div data-src="/assets/images/bg_header4.jpg"></div>
                <div data-src="/assets/images/bg_header5.jpg"></div>
            </div><!-- #camera_wrap -->
            <div class="carousel-caption-wrapper text-center">
                <h1 class="header-title">CONNECT NOW<span class="color-purple"></span></h1>
                <p class="text-content" style="color: white">
                    Free and secure calls and messages to anyone, anywhere
                    <br>
                    Keep your conversations going no matter where you are.
                </p>
                <div class="btn-header-wrapper">
                    <button class="btn-transparent btn-custom text-content">GET STARTED</button>
                    <button class="btn-purple btn-custom text-content">TAKE A TOUR</button>
                </div>
            </div>
        </div>
    </div>
</header>
<div class="row wellcome-wrapper margin-model content-wrapper">
    <div class="col-12 col-sm-7 col-md-8 wellcome-left-col">
        <div class="about-us-title">
            <h3 class="font-weight-bold">FREE <span class="color-purple">MESSAGING</span></h3>
            <h3>WHENEVER, WHEREVER</h3>
        </div>
        <p class="text-content">“Send free one-on-one and group texts to your friends
            anytime, anywhere!
            <br>
            CONNECT NOW is available for a variety of smartphone devices
            (iPhone, Android, Windows Phone, BlackBerry, and Nokia)
            and even your PC.”</p>
    </div>
    <div class="col-12 col-sm-5 col-md-4 wellcome-right-col image-box-model">
        <img src="/assets/images/free_messaging.png" alt="wellcome img" class="img-fluid">
    </div>
</div>
<div class="row wellcome-wrapper margin-model content-wrapper">
    <div class="col-12 col-sm-5 col-md-4 wellcome-left-col image-box-model p-0">
        <img src="/assets/images/free_calling.png" alt="wellcome img" class="img-fluid">
    </div>
    <div class="col-12 col-sm-7 col-md-8 wellcome-right-col pl-5">
        <div class="about-us-title">
            <h3 class="font-weight-bold">Free <span class="color-purple">Voice & Video Calls</span></h3>
            <h3>Call anyone as often as you want</h3>
        </div>
        <p class="text-content">“Free international voice and video calls
            make it easy to stay connected.
            <br>
            Currently available for iPhone, iPad, Android,
            Windows Phone, PC (Windows and Mac),
            and LINE Lite on Android.”</p>
    </div>
</div>
<div class="row wellcome-wrapper margin-model content-wrapper">
    <div class="col-12 col-sm-7 col-md-8 wellcome-left-col">
        <div class="about-us-title">
            <h3 class="font-weight-bold">Exciting <span class="color-purple">Stickers</span></h3>
            <h3>Jazz Up Your Chats</h3>
        </div>
        <p class="text-content">“Share exactly how you’re feeling by choosing from
            over 10,000 stickers and emoticons!
            <br>
            Visit the Sticker Shop to discover original stickers
            of your favorite characters and celebrities.”</p>
    </div>
    <div class="col-12 col-sm-5 col-md-4 wellcome-right-col image-box-model">
        <img src="/assets/images/free_sticker.png" alt="wellcome img" class="img-fluid">
    </div>
</div>
<div class="row wellcome-wrapper margin-model content-wrapper">
    <div class="col-12 col-sm-5 col-md-4 wellcome-left-col image-box-model p-0">
        <img src="/assets/images/free_sharing.png" alt="wellcome img" class="img-fluid">
    </div>
    <div class="col-12 col-sm-7 col-md-8 wellcome-right-col pl-5">
        <div class="about-us-title">
            <h3 class="font-weight-bold">From <span class="color-purple">Photo and Video</span></h3>
            <h3>Sharing to Voice Messages</h3>
        </div>
        <p class="text-content">“CONNECT NOW lets you share photos, videos, voice messages,
            contacts, and location information in the moment.”</p>
    </div>
</div>
<hr class="boder-line">
<div class="row feature-wrapper margin-model content-wrapper">
    <div class="choose-us">
        <h3 class="text-center font-weight-bold">Enhanced security features</h3>
        <p class="text-center text-title m-4">The information you share is safeguarded by our security systems so
            you never have to think twice about what you can or can’t share when you’re using Connect Now.</p>
    </div>
    <div class="col-12 col-sm-4">
        <div class="feature-header">
            <img src="/assets/images/s1.jpg" alt="">
            <span class="feature-title font-weight-bold text-title color-purple">Protected along the way</span>
        </div>
        <p class="text-content text-center">Messages are encrypted as they travel across the internet from your
            device to your recipient’s.</p>
    </div>

    <div class="col-12 col-sm-4">
        <div class="feature-header">
            <img src="/assets/images/s2.jpg" alt="">
            <span class="feature-title font-weight-bold text-title color-purple">End-to-end encryption</span>
        </div>
        <p class="text-content text-center">Encryption keys exist on user devices and nowhere else. So, no one—not
            even Connect Now can read your messages.</p>
    </div>

    <div class="col-12 col-sm-4">
        <div class="feature-header">
            <img src="/assets/images/s3.jpg" alt="">
            <span class="feature-title font-weight-bold text-title color-purple">Trusted contacts</span>
        </div>
        <p class="text-content text-center">Verify the identity of who you’re chatting with by exchanging secret
            keys. Connect Now notifies you if anything about the contact’s details changes.</p>
    </div>
</div>
<div class="container-fluid slogan-wrapper p-0">
    <div class="solgan-overlay">
        <h3 class="slogan-title text-white">High quality. Low rates.</h3>
        <p style="color: white; font-size: 0.9em">Make free calls to people on Connect Now, or get the best rates
            for quality international calls to any landline or mobile in the world with Connect Now Out.</p>
        <div class="row countdown justify-content-center">
            <div id="clock" class="time-count">
                <div class="time-entry days"><span>0</span> Days</div>
                <div class="time-entry hours"><span>0</span> Hours</div>
                <div class="time-entry minutes"><span>0</span> Minutes</div>
                <div class="time-entry seconds"><span>0</span> Seconds</div>
            </div>
        </div>
        <button class="btn-purple btn-custom text-content">READ MORE</button>
    </div>
</div>
<div class="services-wrapper margin-model content-wrapper">
    <div class="title-wrapper">
        <div class="line-background"></div>
        <h2 class="text-title font-weight-bold m-0">SOME IMAGES</h2>
    </div>
    <div class="grid">
        <figure class="effect-roxy">
            <img src="/assets/images/some_image1.jpg"/>
            <figcaption>
                <h2><span>LOGIN</span></h2>
                <button class="btn-custom btn-transparent show-light-box">Full Size</button>
            </figcaption>
        </figure>
        <figure class="effect-roxy">
            <img src="/assets/images/some_image2.jpg"/>
            <figcaption>
                <h2><span>ACCESS</span></h2>
                <button class="btn-custom btn-transparent show-light-box">Full Size</button>
            </figcaption>
        </figure>
        <figure class="effect-roxy">
            <img src="/assets/images/some_image3.jpg"/>
            <figcaption>
                <h2><span>CHAT</span></h2>
                <button class="btn-custom btn-transparent show-light-box">Full Size</button>
            </figcaption>
        </figure>
        <figure class="effect-roxy">
            <img src="/assets/images/some_image4.jpg"/>
            <figcaption>
                <h2><span>FEATURES</span></h2>
                <button class="btn-custom btn-transparent show-light-box">Full Size</button>
            </figcaption>
        </figure>
        <figure class="effect-roxy">
            <img src="/assets/images/some_image5.jpg"/>
            <figcaption>
                <h2><span>COMMUNITY</span></h2>
                <button class="btn-custom btn-transparent show-light-box">Full Size</button>
            </figcaption>
        </figure>
        <figure class="effect-roxy">
            <img src="/assets/images/some_image6.jpg"/>
            <figcaption>
                <h2><span>EXTENSIONS</span></h2>
                <button class="btn-custom btn-transparent show-light-box">Full Size</button>
            </figcaption>
        </figure>

    </div>
    <div class="clear-both"></div>
</div>
<div class="container-fluid p-0 contact-wrapper">
    <div
            class="content-wrapper d-flex justify-content-center flex-column flex-sm-row align-items-center justify-content-sm-between align-items-sm-center h-100">
        <h3 class="contact-title text-white mb-2 mb-sm-0">Sign in with Connect Now to get started.</h3>
        <button class="btn-transparent btn-custom text-content">CONNECT NOW</button>
    </div>
</div>
<div class="container">
    <div class="title-wrapper">
        <div class="line-background"></div>
    </div>
    <img src="/assets/images/Main-Image-VLN.png" alt="" style="width: 100%; object-fit: cover">
    <div class="title-wrapper">
        <div class="line-background"></div>
    </div>
</div>
<footer class="container-fluid">
    <form action="">
        <div class="row content-wrapper newletters-wrapper text-white px-3 px-md-4">
            <div class="col-12 col-md-4 d-flex flex-column align-items-center align-items-md-start mb-0 mb-md-2">
                <h3 class="text-title">REGISTER FOR NEWLETTER</h3>
                <h3 class="text-content">Get Lastest Company News</h3>
            </div>
            <div class="col-8 col-sm-8 col-md-5 d-flex align-items-center justify-content-center">
                <input type="text" placeholder="Enter Your Email Address" class="text-content">
            </div>
            <div class="col-4 col-sm-4 col-md-3 d-flex align-items-center justify-content-end">
                <input type="submit" class="btn-transparent btn-custom text-content" value="SUBSCRIBE">
            </div>
        </div>
    </form>
    <div class="row content-wrapper footer-wrapper">
        <div class="col-12 col-lg-6">
            <div class="footer-introduction">
                <img src="/assets/images/ConnectNow-logo.png" alt="" class="m-auto d-block m-md-0">
                <p class="text-content mt-1">“There are very few people in the world who have gathered as much
                    first-hand knowledge about long-term world travel as Nomadic Matt. Filled with insider
                    strategies and resources, it’s a valuable primer for your upcoming adventures.”</p>
            </div>
        </div>
        <div class="col-4 col-lg-2 d-flex justify-content-center align-items-end">
            <ul class="footer-list p-0 w-75">
                <li><a href="" class="text-content">HOME</a></li>
                <li><a href="" class="text-content">ABOUT US</a></li>
                <li><a href="" class="text-content">SERVICES</a></li>
                <li><a href="" class="text-content">PORTFOLIO</a></li>
            </ul>
        </div>
        <div class="col-4 col-lg-2 d-flex justify-content-center align-items-end">
            <ul class="footer-list p-0 w-75">
                <li><a href="" class="text-content">LEGAL NOTICE</a></li>
                <li><a href="" class="text-content">CAREER</a></li>
                <li><a href="" class="text-content">SUPPORT</a></li>
                <li><a href="" class="text-content">SITEMAP</a></li>
            </ul>
        </div>
        <div class="col-4 col-lg-2 d-flex justify-content-center align-items-end">
            <ul class="footer-list p-0 w-75">
                <li><a href="" class="text-content">TEAM</a></li>
                <li><a href="" class="text-content">TESTIMONIAL</a></li>
                <li><a href="" class="text-content">PRICE</a></li>
                <li><a href="" class="text-content">BLOG</a></li>
            </ul>
        </div>
    </div>
    <div class="footer-coppyright content-wrapper row">
        <div class="col-8 d-flex align-items-center">
            <div class="text-content">© Connect Now - All Rights Reserved</div>
            <div class="social">
                <a href=""><i class="fab fa-facebook-f"></i></a>
                <a href=""><i class="fab fa-twitter"></i></a>
                <a href=""><i class="fab fa-instagram"></i></a>
            </div>
        </div>
        <div class="col-4 social-icon d-flex justify-content-end align-items-center">
            <a href="#"><img src="/assets/images/icon_fb.png" alt=""></a>
            <a href="#"><img src="/assets/images/icon_tw.png" alt=""></a>
            <a href="#"><img src="/assets/images/icon_is.png" alt=""></a>
        </div>
    </div>
</footer>
<div class="light-box">
    <div id="btn-close"><span>X</span></div>
    <img src="" alt="" id="image-content">
</div>
<script type="text/javascript" src="/assets/js/jquery-3.3.1.min.js"></script>
<script type='text/javascript' src="/assets/js/jquery.easing.1.3.js"></script>
<script type='text/javascript' src="/assets/js/camera.min.js"></script>
<script type="text/javascript" src="/assets/js/bootstrap.min.js"></script>
<script>
    jQuery(function () {
        jQuery('#camera_wrap').camera({
            thumbnails: false,
            navigation: false,
            playPause: false,
            loader: '',
            hover: false,
            time: 2000
        });

        var endDay = $('.time-entry.days span');
        var endHour = $('.time-entry.hours span');
        var endMinute = $('.time-entry.minutes span');
        var endSecond = $('.time-entry.seconds span');
        var endTime = new Date(Date.parse(new Date()) + 15 * 24 * 60 * 60 * 1000);

        // ---------------------- CLOCK
        setInterval(function () {
            var distance = Date.parse(endTime) - Date.parse(new Date());

            var seconds = Math.floor((distance / 1000) % 60);
            var minutes = Math.floor((distance / 1000 / 60) % 60);
            var hours = Math.floor((distance / (1000 * 60 * 60)) % 24);
            var days = Math.floor(distance / (1000 * 60 * 60 * 24));

            endDay.text(days);
            endHour.text(hours);
            endMinute.text(minutes);
            endSecond.text(seconds);
        }, 1000);
        // ---------------------- CLOCK

        $('.light-box').fadeOut(0);
        // ------------------------- LIGHT BOX
        $('.show-light-box').each(function () {
            $(this).click(function () {
                var src = $(this).parent().parent().find("img").attr('src');
                $('#image-content').attr("src", src);
                $('.light-box').fadeIn(300);
            })
        });
        $('#btn-close').click(function () {
            $('.light-box').fadeOut(300);
        })
        // ------------------------- LIGHT BOX

        // ------------------------- SCROLL PAGE
        var isScrolling = true;
        $(window).scroll(function () {
            if (window.pageYOffset > $('.wellcome-wrapper').offset().top - 300) {
                $('.navbar-wrapper').addClass('scroll');
            } else if (window.pageYOffset < 300) {
                if (isScrolling) {
                    $('.navbar-wrapper').removeClass('scroll');
                } else {
                    isScrolling = true;
                }
            }
        });
        $('#btn-home').click(function () {
            isScrolling = false;
            $("html, body").animate({scrollTop: 400}, "slow");
            resetNavLink(this);
        });
        $('#btn-about').click(function () {
            isScrolling = false;
            $("html, body").animate({scrollTop: $('.wellcome-wrapper').offset().top - 90}, "slow");
            resetNavLink(this);
        });
        $('#btn-tour').click(function () {
            isScrolling = false;
            $("html, body").animate({scrollTop: $('.slogan-wrapper').offset().top - 90}, "slow");
            resetNavLink(this);
        });
        $('#btn-destination').click(function () {
            isScrolling = false;
            $("html, body").animate({scrollTop: $('.services-wrapper').offset().top - 90}, "slow");
            resetNavLink(this);
        });
        $('#btn-gallery').click(function () {
            isScrolling = false;
            $("html, body").animate({scrollTop: $('.portfolio-wrapper').offset().top - 90}, "slow");
            resetNavLink(this);
        });
        $('#btn-register').click(function () {
            isScrolling = false;
            $("html, body").animate({scrollTop: $('.register-wrapper ').offset().top - 90}, "slow");
            resetNavLink(this);
        });
        // ------------------------- SCROLL PAGE
    });

    function resetNavLink(item) {
        $('.nav-item').each(function () {
            $(this).removeClass('active');
        })
        item.classList.add('active')
    }
</script>
</body>

</html>
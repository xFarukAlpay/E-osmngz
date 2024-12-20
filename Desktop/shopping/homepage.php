<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>SefraymShop</title>
  <link rel="stylesheet" href="css/bootstrap.css">
  <link rel="stylesheet" href="css/style.css">
  <link rel="icon" href="gallery/logo.png">
  <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="font-awesome/css/all.css">
</head>

<body>
  <!------------------------------------------------------Header---------------------------------------------------->
  <nav class="navbar navbar-expand-lg navbar-light bg-white" style="max-height:70px;z-index:10;">
    <a class="navbar-brand" href="homepage.html"><span id="bd-title"><img src="gallery/navbrd.png"
          style="max-height:50px;">SefraymShop</span></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navdp" aria-controls="navdp"
      aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse bg-white" style="width:100%;" id="navdp">
      <form class="form-inline bg-white  my-2 my-lg-0 mrl">
        <input class="form-control mr-sm-2 srh-w bg-white" style="width:500px;" type="search" placeholder="Arama..."
          aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Arama</button>
      </form>
      <a href="login.php" class="btn btn-danger reg1">  <?php
      // Kullanıcı oturumunu başlat
      session_start();
      // Kullanıcı adını navbar'da yazdır
      if (isset($_SESSION['username'])) {
        echo '<span class="navbar-text"><strong>' . $_SESSION['username'] . '</strong></span>';
      } else {
          echo '<a href="login.php" class="btn btn-danger reg1">Kayıt ol</a>';
      }
      ?></a>
      <a href="cart.html" class="btn btn-info reg2"><i class="fas fa-shopping-cart"></i> Sepet &nbsp;<span
          id="cartCount" class="badge badge-light ms-1">0</span></a>

    </div>

  </nav>
  <nav class="nav2">
    <ul class="ul2">
      <li id="one"><a href="ruj.html">Rujlar</a></li>
      <li id="two"><a href="maskaralar.html">Maskaralar </a></li>
      <li id="three"><a href="allık.html">Allıklar</a></li>
      <li id="four"><a href="farlar.html">Farlar</a></li>
      <li id="five"><a href="nemlendirici.html">Nemlendiriciler</a></li>
      <li id="six"><a href="aydınlatıcı.html">Aydınlatıcılar</a></li>
      <li id="seven"><a href="parfümler.html">Parfümler</a></li>
      <li id="eight"><a href="#">Makyaj Bazları</a></li>
    </ul>
  </nav>
  <!------------------------------------------------------Header---------------------------------------------------->

  <!------------------------------------------------------Carousel---------------------------------------------------->
  <div id="carousel1" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
      <li data-target="#carousel1" data-slide-to="0" class="active"></li>
      <li data-target="#carousel1" data-slide-to="1"></li>
      <li data-target="#carousel1" data-slide-to="2"></li>
      <li data-target="#carousel1" data-slide-to="3"></li>
    </ol>
    <div class="carousel-inner">
      <div class="carousel-item active">
        <img src="gallery/1.jpg" class="d-block w-100 img-fluid" alt="1">
      </div>
      <div class="carousel-item">
        <img src="gallery/2.jpg" class="d-block w-100 img-fluid" alt="2">
      </div>
      <div class="carousel-item">
        <img src="gallery/3.jpg" class="d-block w-100 img-fluid" alt="3">
      </div>
      <div class="carousel-item">
        <img src="gallery/4.jpg" class="d-block w-100 img-fluid" alt="4">
      </div>
    </div>
    <a class="carousel-control-prev" href="#carousel1" role="button" data-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carousel1" role="button" data-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>

  <!------------------------------------------------------Carousel---------------------------------------------------->

  <!------------------------------------------------------Cards---------------------------------------------------->
  <div class="container-fluid pt-2 pb-2" style="background-color:#F0FFFF; border-bottom:1px solid darkgray;">
    <div class="row">
      <div class="col-sm-12">
        <div id="inm" class="carousel slide" data-ride="carousel">
          <div class="carousel-inner">
            <div class="carousel-item active">
              <div class="container">
                <div class="row">
                  <div class="col-sm-6 col-lg-3">
                    <div class="card">
                      <img src="gallery/card1.jpg" class="img-fluid" alt="card1">
                      <div class="card-body text-center">
                        <h4 class="card-title">Guerlain</h4>
                        <p class="text-muted">Mikroküre Yapılı Makyaj Bazı <br> 3.495 TL</p>
                        <button class="w-100 btn btn-dark btn-custom addToCart" type="submit">Sepete Ekle</button>
                        <br><br>
                        <a href="./infos/info.html" class="w-100 btn btn-sm btn-secondary bg-white text-dark"
                          role="button">Ürünü Görüntüle</a>
                      </div>
                    </div>
                  </div>


                  <div class="col-sm-6 col-lg-3 mm">
                    <div class="card">
                      <img src="gallery/card2.jpg" class="img-fluid" alt="card1">
                      <div class="card-body text-center">
                        <h4 class="card-title">Tom Ford</h4>
                        <p class="text-muted">
                          Lip Color Ultra Shine Ete Brulant <br> 850 TL</p>
                        <button class="w-100 btn btn-dark btn-custom addToCart" type="submit">Sepete Ekle</button>
                        <br><br>
                        <a href="./infos/info7.html" class="w-100 btn btn-sm btn-secondary bg-white text-dark"
                          role="button">Ürünü Görüntüle</a>
                      </div>
                    </div>
                  </div>
                  <div class="col-sm-6 col-lg-3 mm">
                    <div class="card">
                      <img src="gallery/card3.jpg" class="img-fluid" alt="card1">
                      <div class="card-body text-center">
                        <h4 class="card-title">Guerlain</h4>
                        <p class="text-muted">Guerlain Kiss Kiss Shine Bloom Ruj <br> 2.990 TL </p>
                        <button class="w-100 btn btn-dark btn-custom addToCart" type="submit">Sepete Ekle</button>
                        <br><br>
                        <a href="./infos/info2.html" class="w-100 btn btn-sm btn-secondary bg-white text-dark"
                          role="button">Ürünü Görüntüle</a>
                      </div>
                    </div>
                  </div>
                  <div class="col-sm-6 col-lg-3 mm">
                    <div class="card">
                      <img src="gallery/card4.jpg" class="img-fluid" alt="card1">
                      <div class="card-body text-center">
                        <h4 class="card-title">Nars</h4>
                        <p class="text-muted">Afterglow Lip Balm Clean Cut <br> 1.420 TL</p>
                        <button class="w-100 btn btn-dark btn-custom addToCart" type="submit">Sepete Ekle</button>
                        <br><br>
                        <a href="./infos/info3.html" class="w-100 btn btn-sm btn-secondary bg-white text-dark"
                          role="button">Ürünü Görüntüle</a>
                      </div>
                    </div>
                  </div>

                </div>
              </div>
            </div>
            <div class="carousel-item">
              <div class="container">
                <div class="row">
                  <div class="col-sm-6 col-lg-3">
                    <div class="card">
                      <img src="gallery/card5.jpg" class="img-fluid" alt="card1">
                      <div class="card-body text-center">
                        <h4 class="card-title">Lancome</h4>
                        <p class="text-muted">L'Absolu Gloss 212 <br> 002 no <br> 1.480 TL</p>
                        <button class="w-100 btn btn-dark btn-custom addToCart" type="submit">Sepete Ekle</button>
                        <br><br>
                        <a href="./infos/info5.html" class="w-100 btn btn-sm btn-secondary bg-white text-dark"
                          role="button">Ürünü Görüntüle</a>
                      </div>
                    </div>
                  </div>
                  <div class="col-sm-6 col-lg-3">
                    <div class="card">
                      <img src="gallery/card6.jpg" class="img-fluid" alt="card1">
                      <div class="card-body text-center">
                        <h4 class="card-title">Maybelline</h4>
                        <p class="text-muted">Lash Sensational Sky High Maskara <br> 495 TL</p>
                        <button class="w-100 btn btn-dark btn-custom addToCart" type="submit">Sepete Ekle</button>
                        <br><br>
                        <a href="./infos/info5.html" class="w-100 btn btn-sm btn-secondary bg-white text-dark"
                          role="button">Ürünü Görüntüle</a>
                      </div>
                    </div>
                  </div>
                  <div class="col-sm-6 col-lg-3">
                    <div class="card">
                      <img src="gallery/card2.jpg" class="img-fluid" alt="card1">
                      <div class="card-body text-center">
                        <h4 class="card-title">Tom Ford</h4>
                        <p class="text-muted">Lip Color Ultra Shine Ete Brulant  <br>1800 TL </p>
                        <button class="w-100 btn btn-dark btn-custom addToCart" type="submit">Sepete Ekle</button>
                        <br><br>
                        <a href="./infos/info7.html" class="w-100 btn btn-sm btn-secondary bg-white text-dark"
                          role="button">Ürünü Görüntüle</a>
                      </div>
                    </div>
                  </div>
                  <div class="col-sm-6 col-lg-3">
                    <div class="card">
                      <img src="gallery/card3.jpg" class="img-fluid" alt="card1">
                      <div class="card-body text-center">
                        <h4 class="card-title">Guerlain</h4>
                        <p class="text-muted">Guerlain Kiss Kiss Shine Bloom Ruj  <br> 2.990 TL</p>
                        <button class="w-100 btn btn-dark btn-custom addToCart" type="submit">Sepete Ekle</button>
                        <br><br>
                        <a href="./infos/info8.html" class="w-100 btn btn-sm btn-secondary bg-white text-dark"
                          role="button">Ürünü Görüntüle</a>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>


          </div>
          <a class="carousel-control-prev" style="margin-left:20px; width:50px;" href="#inm" role="button"
            data-slide="prev">
            <span class="carousel-control-prev-icon card-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" style="margin-right:20px; width:50px;" href="#inm" role="button"
            data-slide="next">
            <span class="carousel-control-next-icon card-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>

        </div>
      </div>
    </div>
  </div>

  <div class="container-fluid" style="background-color:#F0F8FF; border-bottom:1px solid darkgray; overflow:hidden;">
    <div class="row mb-3">
      <div class="col-sm-12 ">
        <h4 class="cd-h4 mt-3 mb-3">Favoriler</h4>

        <div class="card-group">
          <div class="card col-sm-4 col-lg-2 card2sty">
            <img src="gallery/laptop1.jpg" style="margin:5px; max-height:200px; max-width:200px;" alt="lap1"
              class="image-fluid">
            <div class="card-body cd-txt">
              <h4 class="card-title">Hermès <br>  Rose Pommette Allık</h4>
              <p class="text-muted txt-sz">1.550 TL<br></p>
              <button class="w-100 btn btn-dark btn-custom addToCart" type="submit">Sepete Ekle</button>
              <br><br>
              <a href="./infos/info2.html" class="w-100 btn btn-sm btn-secondary bg-white text-dark" role="button">Ürünü Görüntüle</a>
            </div>
          </div>
          <div class="card col-sm-4 col-lg-2 card2sty">
            <img src="gallery/laptop2.webp" style="margin:5px; max-height:200px; max-width:200px;" alt="lap2"
              class="image-fluid">
            <div class="card-body cd-txt">
              <h4 class="card-title"> Clinique High Impact Zero Gravity Mascara</h4>
              <p class="text-muted txt-sz">175 TL<br></p>
              <button class="w-100 btn btn-dark btn-custom addToCart" type="submit">Sepete Ekle</button>
              <br><br>
              <a href="./infos/info2.html" class="w-100 btn btn-sm btn-secondary bg-white text-dark" role="button">Ürünü Görüntüle</a>
            </div>
          </div>
          <div class="card col-sm-4 col-lg-2 card2sty">
            <img src="gallery/laptop3.jpg" style="margin:5px; max-height:200px; max-width:200px;" alt="lap3"
              class="image-fluid">
            <div class="card-body cd-txt">
              <h4 class="card-title">Valentino <br> Valentino Donna Parfüm</h4>
              <p class="text-muted txt-sz">2220 TL</p>
              <button class="w-100 btn btn-dark btn-custom addToCart" type="submit">Sepete Ekle</button>
              <br><br>
              <a href="./infos/info2.html" class="w-100 btn btn-sm btn-secondary bg-white text-dark" role="button">Ürünü Görüntüle</a>
            </div>
          </div>
          <div class="card col-sm-4 col-lg-2 card2sty">
            <img src="gallery/laptop4.jpg" style="margin:5px; max-height:200px; max-width:200px;" alt="lap4"
              class="image-fluid">
            <div class="card-body cd-txt">
              <h4 class="card-title">Valentino <br> Valentino Donna Parfüm</h4>
              <p class="text-muted txt-sz">930 TL</p>
              <button class="w-100 btn btn-dark btn-custom addToCart" type="submit">Sepete Ekle</button>
              <br><br>
              <a href="./infos/info2.html" class="w-100 btn btn-sm btn-secondary bg-white text-dark" role="button">Ürünü Görüntüle</a>
            </div>
          </div>
          <div class="card col-sm-4 col-lg-2 card2sty">
            <img src="gallery/laptop5.jpg" style="margin:5px; max-height:200px; max-width:200px;" alt="lap5"
              class="image-fluid">
            <div class="card-body cd-txt">
              <h4 class="card-title">Giorgio Armani <br> Ga Lumınous Silk Highlighter</h4>
              <p class="text-muted txt-sz">1400 TL</p>
              <button class="w-100 btn btn-dark btn-custom addToCart" type="submit">Sepete Ekle</button>
              <br><br>
              <a href="./infos/info2.html" class="w-100 btn btn-sm btn-secondary bg-white text-dark" role="button">Ürünü Görüntüle</a>
            </div>
          </div>
          <div class="card col-sm-4 col-lg-2 card2sty">
            <img src="gallery/laptop6.jpg" style="margin:5px; max-height:200px; max-width:200px;" alt="lap2"
              class="image-fluid">
            <div class="card-body cd-txt">
              <h4 class="card-title">Giorgio Armani <br> Eyes To Kill Stellar  Göz Farı</h4>
              <p class="text-muted txt-sz">1250 TL</p>
              <button class="w-100 btn btn-dark btn-custom addToCart" type="submit">Sepete Ekle</button>
              <br><br>
              <a href="./infos/info2.html" class="w-100 btn btn-sm btn-secondary bg-white text-dark" role="button">Ürünü Görüntüle</a>
            </div>
          </div>
        </div>
      </div>
    </div>
    <br><br><br>
  </div>

  <!------------------------------------------------------Card2---------------------------------------------------->

  <!------------------------------------------------------Maskaralar ---------------------------------------------------->
  <div class="container-fluid" style="background-color:#F0F8FF; border-bottom:1px solid darkgray; overflow:hidden;">
    <div class="row">
      <img src="gallery/mb1.png" class=" mt-2 mb-2 col-6 col-sm-4 col-lg-3 image-fluid"
        onclick="window.location.assign('https://www.google.com')">
      <img src="gallery/mb2.jpg" class=" mt-2 mb-2 col-6 col-sm-4 col-lg-3 image-fluid"
        onclick="window.location.assign('https://www.google.com')">
      <img src="gallery/mb3.jpg" class=" mt-2 mb-2 col-6 col-sm-4 col-lg-3 image-fluid"
        onclick="window.location.assign('https://www.google.com')">
      <img src="gallery/mb4.jpg" class=" mt-2 mb-2 col-6 col-sm-4 col-lg-3 image-fluid"
        onclick="window.location.assign('https://www.google.com')">
    </div>
  </div>
  <!------------------------------------------------------Maskaralar ---------------------------------------------------->

  <!------------------------------------------------------Footer---------------------------------------------------->
  <footer class="footdes">
    <div class="container-fluid footer-1">
      <div class="row">
        <div class="col-sm-4 foocol">
          <h4 class="text-white fh4">Hakkımızda</h4>
          <p class="text-white">Hoş geldiniz! Biz Sefraym Shopping, online alışverişinizi daha kolay, keyifli ve güvenli
            hale getirmek için buradayız. Misyonumuz, müşterilerimize en kaliteli ürünleri sunarken mükemmel bir
            alışveriş deneyimi sağlamaktır.

            Sefraym Shopping, kurulduğu günden beri müşteri memnuniyetini ve güvenini ön planda tutarak hizmet
            vermektedir. Geniş ürün yelpazemizde herkesin ihtiyacına uygun ürünleri bulabilirsiniz. Giyim, Rujlar ,
            ev dekorasyonu, Nemlendiriciler ve daha fazlası gibi çeşitli kategorilerde binlerce ürün sunuyoruz. </p>
        </div>
        <div class="col-sm-4 foocol">
          <h4 class="text-white fh4">Categories</h4>
          <i class="fas fa-tv text-white"> <a href="ruj.html"
              style="text-decoration: none; list-style:none; display:inline-block;">Rujlar</a></i> <br />
          <i class="fas fa-mobile text-white"> <a href="maskaralar.html"
              style="text-decoration: none; list-style:none; display:inline-block;">Maskaralar </a></i> <br />
          <i class="fas fa-laptop text-white"> <a href="laptops.html"
              style="text-decoration: none; list-style:none; display:inline-block;">Allıklar</a></i> <br />
          <i class="fas fa-utensils text-white"> <a href="#"
              style="text-decoration: none; list-style:none; display:inline-block;">Farlar </a></i> <br />
          <i class="fas fa-book text-white"> <a href="#"
              style="text-decoration: none; list-style:none; display:inline-block;">Nemlendiriciler</a></i> <br />
          <i class="fas fa-tshirt text-white"> <a href="#"
              style="text-decoration: none; list-style:none; display:inline-block;">Aydınlatıcılar </a></i> <br />
          <i class="fas fa-running text-white"> <a href="#"
              style="text-decoration: none; list-style:none; display:inline-block;">Parfümler</a></i> <br />
          <i class="fas fa-rupee-sign text-white"> <a href="#"
              style="text-decoration: none; list-style:none; display:inline-block;">Makyaj Bazları</a></i> <br />
        </div>


        <div class="col-sm-4 foocol">
          <h4 class="text-white fh4">İletişime geç</h4>
          <span style="color:antiquewhite; text-transform:uppercase;">Address:</span><span class="text-white">
            SefraymShop , Kütahya Dumlupınar Üniversitesi</span><br />
          <i class="fas fa-envelope text-white"></i> <span
            style="color:antiquewhite; text-transform:uppercase;">Mail:</span><span class="text-white"
            style="overflow-wrap: break-word;"> faruk.alpay@dpu.edu.tr</span><br />
          <i class="fas fa-phone-alt text-white"></i> <span
            style="color:antiquewhite; text-transform:uppercase;">Telefon:</span><span class="text-white">
            (+90)5416945536</span> <br />
          <br />
          <br />
          <pc class="text-white">Sorularınız ve ihtiyaçlarınız için bizimle iletişime geçin <a
              href="mailto:faruk.alpay@dpu.edu.tr">mail</a>yada telefon.</p>
        </div>
      </div>
      <div class="row">
        <div class="footer-2 col-sm foocol-2">
          <div class="footer-2-div">
            <a href="https://www.facebook.com"><i class="fab fa-facebook text-white"></i></a>
            <a href="https://www.twitter.com"><i class="fab fa-twitter text-white"></i></a>
            <a href="https://www.linkedin.com"><i class="fab fa-linkedin-in text-white"></i></a>
            <a href="https://www.instagram.com"><i class="fab fa-instagram text-white"></i></a>

          </div>
        </div>
      </div>
    </div>
  </footer>
  <!------------------------------------------------------Footer---------------------------------------------------->

  <script src="products.js" charset="utf-8"></script>

  <script src="js/jquery.js"></script>
  <script src="js/bootstrap.js"></script>
</body>

</html>
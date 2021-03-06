<!DOCTYPE html>
<html lang="en">
<meta charset="utf-8" />
<title>Pocetna stranica</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<style>
body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
.w3-third img{margin-bottom: -6px; opacity: 0.8; cursor: pointer}
.w3-third img:hover{opacity: 1}
</style>
<body class="w3-light-grey w3-content" style="max-width:1600px">

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-bar-block w3-white w3-animate-left w3-text-grey w3-collapse w3-top w3-center" style="z-index:3;width:300px;font-weight:bold" id="mySidebar"><br>
  <h3 class="w3-padding-64 w3-center"><b>SALON<br>LEPOTE</b></h3>
  <a href="javascript:void(0)" onclick="w3_close()" class="w3-bar-item w3-button w3-padding w3-hide-large">CLOSE</a>
  <a href="/SalonLepote/auth/loginPage" onclick="w3_close()" class="w3-bar-item w3-button">LOGIN</a> 
  <a href="#about" onclick="w3_close()" class="w3-bar-item w3-button">O NAMA</a> 
  <a href="#contact" onclick="w3_close()" class="w3-bar-item w3-button">KONTAKT</a>
  <a href="/SalonLepote/auth/getSveUsluge" onclick="w3_close()" class="w3-bar-item w3-button">USLUGE</a>
</nav>

<!-- Top menu on small screens -->
<header class="w3-container w3-top w3-hide-large w3-white w3-xlarge w3-padding-16">
  <span class="w3-left w3-padding">SALON LEPOTE</span>
  <a href="javascript:void(0)" class="w3-right w3-button w3-white" onclick="w3_open()">☰</a>
</header>

<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px">

  <!-- Push down content on small screens --> 
  <div class="w3-hide-large" style="margin-top:83px"></div>
  
  <!-- Photo grid -->
  <div class="w3-row">
    <div class="w3-third">
      <img src="${pageContext.request.contextPath}/slike/1.jpg" style="width:100%" onclick="onClick(this)" alt="Slika1">
      <img src="${pageContext.request.contextPath}/slike/2.jpg" style="width:100%" onclick="onClick(this)" alt="Slika2">
      <img src="${pageContext.request.contextPath}/slike/3.jpeg" style="width:100%" onclick="onClick(this)" alt="Slika3">
    </div>

    <div class="w3-third">
      <img src="${pageContext.request.contextPath}/slike/4.jpg" style="width:100%" onclick="onClick(this)" alt="Slika4">
      <img src="${pageContext.request.contextPath}/slike/5.jpg" style="width:100%" onclick="onClick(this)" alt="Slika5">
      <img src="${pageContext.request.contextPath}/slike/6.jpg" style="width:100%" onclick="onClick(this)" alt="Slika6">
    </div>
    
    <div class="w3-third">
      <img src="${pageContext.request.contextPath}/slike/7.jfif" style="width:100%" onclick="onClick(this)" alt="Slika7">
      <img src="${pageContext.request.contextPath}/slike/8.jpg" style="width:100%" onclick="onClick(this)" alt="Slika8">
      <img src="${pageContext.request.contextPath}/slike/9.jfif" style="width:100%" onclick="onClick(this)" alt="Slika9">
    </div>
  </div>

  
  <!-- Modal for full size images on click-->
  <div id="modal01" class="w3-modal w3-black" style="padding-top:0" onclick="this.style.display='none'">
    <span class="w3-button w3-black w3-xlarge w3-display-topright">×</span>
    <div class="w3-modal-content w3-animate-zoom w3-center w3-transparent w3-padding-64">
      <img id="img01" class="w3-image">
      <p id="caption"></p>
    </div>
  </div>

  <!-- About section -->
  <div class="w3-container w3-dark-grey w3-center w3-text-light-grey w3-padding-32" id="about">
    <h4><b>O nama</b></h4>
    <div class="w3-content w3-justify" style="max-width:600px">
      <p>
     Prijatan i moderno uredjen prostor naseg salona, ljubazno i
		strucno osoblje pruzice Vam tretmane i opustanje kakvo zasluzujete.
		Svakom klijentu pristupamo individualno i zajedno saradjujemo kako bi
		odabrali najbolji tretman i preparate. Cilj nam je da svaki klijent iz
		naseg salona izadje sa osmehom na licu. Uverite se u kvalitet naseg
		salona. Dobrodosli :)
      </p>
      <p>email:saraculic30@gmail.com</p>
      <p>tel: 5353 35531</p>
      <hr class="w3-opacity">
      
      <h4 class="w3-padding-16">Poklon vaucer</h4>
      <div class="w3-row-padding" style="margin:0 -16px">
        <div class="w3-half w3-margin-bottom">
          <ul class="w3-ul w3-white w3-center w3-opacity w3-hover-opacity-off">
            <li class="w3-black w3-xlarge w3-padding-32">Paket 1</li>
            <li class="w3-padding-16">Anticelulit masaze x5</li>
            <li class="w3-padding-16">Piling</li>
            <li class="w3-padding-16">Depilacija</li>
            <li class="w3-padding-16">Tretman lica</li>
            <li class="w3-padding-16">
              <h2>10000 RSD</h2>
            </li>
            <li class="w3-light-grey w3-padding-24">
            </li>
          </ul>
        </div>
        
        <div class="w3-half">
          <ul class="w3-ul w3-white w3-center w3-opacity w3-hover-opacity-off">
            <li class="w3-black w3-xlarge w3-padding-32">Paket 2</li>
            <li class="w3-padding-16">Oblikovanje obrva</li>
            <li class="w3-padding-16">Hemijski piling lica</li>
            <li class="w3-padding-16">Hidratacija lica</li>
            <li class="w3-padding-16">Uklanjanje podocnjaka</li>
            <li class="w3-padding-16">
              <h2>15000 RSD</h2>
            </li>
            <li class="w3-light-grey w3-padding-24">
 
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>

  <!-- Contact section -->
  <div class="w3-container w3-light-grey w3-padding-32 w3-padding-large" id="contact">
    <div class="w3-content" style="max-width:600px">
      <h4 class="w3-center"><b>Ostavi komentar</b></h4>
      <form action="/action_page.php" target="_blank">
        <div class="w3-section">
          <label>Name</label>
          <input class="w3-input w3-border" type="text" name="Name" required>
        </div>
        <div class="w3-section">
          <label>Email</label>
          <input class="w3-input w3-border" type="text" name="Email" required>
        </div>
        <div class="w3-section">
          <label>Message</label>
          <input class="w3-input w3-border" type="text" name="Message" required>
        </div>
        <button type="submit" class="w3-button w3-block w3-black w3-margin-bottom"><a href="/SalonLepote/auth/loginPage">Send Message</a></button>
      </form>
    </div>
  </div>

  

<!-- End page content -->
</div>

<script>
// Script to open and close sidebar
function w3_open() {
  document.getElementById("mySidebar").style.display = "block";
  document.getElementById("myOverlay").style.display = "block";
}
 
function w3_close() {
  document.getElementById("mySidebar").style.display = "none";
  document.getElementById("myOverlay").style.display = "none";
}

// Modal Image Gallery
function onClick(element) {
  document.getElementById("img01").src = element.src;
  document.getElementById("modal01").style.display = "block";
  var captionText = document.getElementById("caption");
  captionText.innerHTML = element.alt;
}

</script>


</body>
</html>

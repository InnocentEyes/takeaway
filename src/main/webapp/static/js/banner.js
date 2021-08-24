(function ($) {
  $(function () {
    var slider = $(".slider").flickity({
      imagesLoaded: true,
      percentPosition: false,
      prevNextButtons: false, //true = enable buttons
      initialIndex: 3,
      pageDots: false, //true = enable dots
      groupCells: 1,
      selectedAttraction: 0.2,
      friction: 0.8,
      draggable: true
    });

    //this enables clicking on cards
    slider.on(
      "staticClick.flickity",
      function (event, pointer, cellElement, cellIndex) {
        if (typeof cellIndex == "number") {
          slider.flickity("selectCell", cellIndex);
        }
      }
    );

    //this resizes the cards and centers the carousel because it tends to move a few pixels to the right if .resize() and .reposition() aren't used
    var flkty = slider.data("flickity");
    flkty.selectedElement.classList.add("is-custom-selected");
    flkty.resize();
    flkty.reposition();
    let time = 0;
    function reposition() {
      flkty.reposition();
      if (time++ < 10) {
        requestAnimationFrame(reposition);
      } else {
        $(".flickity-prev-next-button").css("pointer-events", "auto");
      }
    }
    requestAnimationFrame(reposition);

    //this expands the cards when in focus
    flkty.on("settle", () => {
      $(".card").removeClass("is-custom-selected");
      $(".flickity-prev-next-button").css("pointer-events", "none");
      flkty.selectedElement.classList.add("is-custom-selected");

      let time = 0;
      function reposition() {
        flkty.reposition();
        if (time++ < 10) {
          requestAnimationFrame(reposition);
        } else {
          $(".flickity-prev-next-button").css("pointer-events", "auto");
        }
      }
      requestAnimationFrame(reposition);
    });

    //this reveals the carousel
    $(".carousel").addClass("animation-reveal");
    $(".carousel").css("opacity", "0");
    flkty.resize();
    flkty.reposition();
    setTimeout(() => {
      $(".carousel").removeClass("animation-reveal");
      $(".carousel").css("opacity", "1");
      flkty.resize();
      flkty.reposition();
      let time = 0;
      function reposition() {
        flkty.reposition();
        if (time++ < 10) {
          requestAnimationFrame(reposition);
        }
      }
      requestAnimationFrame(reposition);
    }, 1000);
  });
})(jQuery);
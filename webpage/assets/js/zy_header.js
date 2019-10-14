      $(document).ready(function () {
          $(".nav-child1").hover(function () {
          $(this).children(".master1").addClass("master1-hover");
          $(this).children(".child1").stop(true, true).slideDown("fast");
          $(this).children(".child2").stop(true, true).slideDown("fast");
      },
      function () {
          $(this).children(".master1").removeClass("master1-hover");
          $(this).children(".child1").stop(true, true).slideUp("fast");
          $(this).children(".child2").stop(true, true).slideUp("fast");
      });
          $(".nav-left2-2").click(function () {
          if ($(this).find(".nav-left2-3").css("display") == "none") {
          $(".nav-left2-3").stop(true, true).slideUp("fast");
      }
          $(this).find(".nav-left2-3").stop(true, true).slideToggle("fast");
      });
      $(".qq1").click(function () {
          if ($("#right").is(":hidden")) {
          $("#right").css("display", "block");
      }
      else {
          $("#right").css("display", "none");
      }
      });
      })
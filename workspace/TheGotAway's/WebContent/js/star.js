var starRating = function(){
  var $star = $(".star-input"),
      $result = $star.find("output b");
  $(document)
    .on("focusin", ".star-input>.input", function(){
    $(this).addClass("focus");
    
  })
    .on("focusout", ".star-input>.input", function(){
    var $this = $(this);
    setTimeout(function(){
      if($this.find(":focus").length === 0){
        $this.removeClass("focus");
      }
    }, 100);
  })
    .on("change", ".star-input :radio", function(){
    	$('output>b').text($(this).next().text());
  })
    .on("mouseover", ".star-input label", function(){
    	$('output>b').text($(this).text());
  })
    .on("mouseleave", ".star-input>.input", function(){
    var $checked = $(".star-input").find(":checked");
    if($checked.length == 0){
    	$('output>b').text("0");
    } else {
      $('output>b').text($checked.next().text());
    }
  })
};
starRating();
console.log("다시");
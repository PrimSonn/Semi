var gnb_date = new Date();

var gnbSvcs = {
	"svc_lst1" : [{"id":"game","name":"게임","sname":"게임","link":"http://game.naver.com/"},
		{"id":"weather","name":"날씨","sname":"날씨","link":"http://weather.naver.com/"},
		{"id":"shopping","name":"네이버쇼핑","sname":"네이버쇼핑","link":"http://shopping.naver.com/"},
		{"id":"navercast","name":"네이버캐스트","sname":"네이버캐스트","link":"http://navercast.naver.com/"},
		{"id":"cloud","name":"네이버클라우드","sname":"클라우드","link":"http://cloud.naver.com/"},
		{"id":"naverpay","name":"네이버페이","sname":"네이버페이","link":"http://order.pay.naver.com/home"},
		{"id":"news","name":"뉴스","sname":"뉴스","link":"http://news.naver.com/"},
		{"id":"comic","name":"만화/웹툰","sname":"만화/웹툰","link":"http://comic.naver.com/"},
		{"id":"memo","name":"메모","sname":"메모","link":"http://memo.naver.com/"},
		{"id":"mail","name":"메일","sname":"메일","link":"http://mail.naver.com/"},
		{"id":"music","name":"뮤직","sname":"뮤직","link":"http://music.naver.com/"},
		{"id":"land","name":"부동산","sname":"부동산","link":"http://land.naver.com/"},
		{"id":"bookmark","name":"북마크","sname":"북마크","link":"http://bookmark.naver.com/"},
		{"id":"blog","name":"블로그","sname":"블로그","link":"http://section.blog.naver.com/"},
		{"id":"dic","name":"사전","sname":"사전","link":"http://dic.naver.com/"},
		{"id":"software","name":"소프트웨어","sname":"소프트웨어","link":"http://software.naver.com/main.nhn"},
		{"id":"sports","name":"스포츠","sname":"스포츠","link":"http://sports.news.naver.com/"},
		{"id":"ya9","name":"야구9단","sname":"야구9단","link":"http://ya9.naver.com/?adtr=A19A132"},
		{"id":"movie","name":"영화","sname":"영화","link":"http://movie.naver.com/"},
		{"id":"office","name":"오피스","sname":"오피스","link":"http://office.naver.com/"},
		{"id":"novel","name":"웹소설","sname":"웹소설","link":"http://novel.naver.com/webnovel/weekday.nhn"},
		{"id":"auto","name":"자동차","sname":"자동차","link":"http://auto.naver.com/"},
		{"id":"contact","name":"주소록","sname":"주소록","link":"http://contact.naver.com/"},
		{"id":"finance","name":"증권(금융)","sname":"증권(금융)","link":"http://stock.naver.com/"},
		{"id":"map","name":"지도","sname":"지도","link":"http://map.naver.com/"},
		{"id":"kin","name":"지식iN","sname":"지식iN","link":"http://kin.naver.com/"},
		{"id":"terms","name":"지식백과","sname":"지식백과","link":"http://terms.naver.com/"},
		{"id":"book","name":"책","sname":"책","link":"http://book.naver.com/"},
		{"id":"cafe","name":"카페","sname":"카페","link":"http://section.cafe.naver.com/"},
		{"id":"calendar","name":"캘린더","sname":"캘린더","link":"http://calendar.naver.com/"},
		{"id":"photo","name":"포토갤러리","sname":"포토갤러리","link":"http://photo.naver.com/"},
		{"id":"nstore","name":"N스토어","sname":"N스토어","link":"http://nstore.naver.com/"},
		{"id":"navertv","name":"네이버TV","sname":"네이버TV","link":"http://tv.naver.com/"}],
	"svc_lst2" : [{"id":"krdic","name":"국어사전","sname":"국어","link":"http://krdic.naver.com/"},
		{"id":"endic","name":"영어/영영사전","sname":"영어/영영","link":"http://endic.naver.com/"},
		{"id":"hanja","name":"한자사전","sname":"한자사전","link":"http://hanja.naver.com/"},
		{"id":"jpdic","name":"일어사전","sname":"일본어","link":"http://jpdic.naver.com/"},
		{"id":"cndic","name":"중국어사전","sname":"중국어","link":"http://cndic.naver.com/"},
		{"id":"frdic","name":"프랑스어사전","sname":"프랑스어","link":"http://frdic.naver.com/"},
		{"id":"dedic","name":"독일어사전","sname":"독일어","link":"http://dedic.naver.com/dedic/"},
		{"id":"rudic","name":"러시아어사전","sname":"러시아어","link":"http://rudic.naver.com/?sLn=kr"},
		{"id":"vndic","name":"베트남어사전","sname":"베트남어","link":"http://vndic.naver.com/"},
		{"id":"spdic","name":"스페인어사전","sname":"스페인어","link":"http://spdic.naver.com/"},
		{"id":"translate","name":"번역기","sname":"번역기","link":"http://translate.naver.com/"}],
	"svc_lst3" : [{"id":"grafolio","name":"그라폴리오","sname":"그라폴리오","link":"http://grafolio.net/"},
		{"id":"post","name":"포스트","sname":"포스트","link":"http://post.naver.com/"},
		{"id":"luncherapp","name":"도돌런처","sname":"도돌런처","link":"http://dodol.naver.com:10080/recommendtheme/get.camp"},
		{"id":"band","name":"밴드","sname":"밴드","link":"http://band.us/"},
		{"id":"line","name":"라인","sname":"라인","link":"http://line.naver.jp/ko/"}]
};

var gnbWholeSvc = [
	{"name":"N스토어", "query":["N스토어", "엔스토어", "앤스토어"], "link":"http://nstore.naver.com/", "clickCd":"gnbSR_nstore"},
	{"name":"QR코드", "query":["QR코드", "큐알코드"], "link":"http://qr.naver.com/", "clickCd":"gnbSR_qr"},
	{"name":"네이버TV", "query":["네이버TV", "navertv", "네이버티비"], "link":"http://tv.naver.com/", "clickCd":"gnbSR_tvcast"},
	{"name":"가계부", "query":["가계부"], "link":"http://moneybook.naver.com/", "clickCd":"gnbSR_moneybook"},
	{"name":"개발자센터", "query":["개발자센터"], "link":"http://developer.naver.com/", "clickCd":"gnbSR_developer"},
	{"name":"검색광고", "query":["검색광고"], "link":"http://searchad.naver.com", "clickCd":"gnbSR_searchad"},
	{"name":"검색등록", "query":["검색등록"], "link":"https://submit.naver.com/", "clickCd":"gnbSR_searchsubmit"},
	{"name":"게시중단 요청 서비스", "query":["게시중단요청서비스"], "link":"http://inoti.naver.com/inoti/claim.nhn?m=purpose", "clickCd":"gnbSR_stoppost"},
	{"name":"게임", "query":["게임"], "link":"http://game.naver.com/", "clickCd":"gnbSR_game"},
	{"name":"고객센터", "query":["고객센터"], "link":"https://help.naver.com", "clickCd":"gnbSR_help"},
	{"name":"국어사전", "query":["국어사전"], "link":"http://krdic.naver.com/", "clickCd":"gnbSR_krdic"},
	{"name":"그라폴리오", "query":["그라폴리오", "grafolio"], "link":"http://www.grafolio.net/", "clickCd":"gnbSR_grafolio"},
	{"name":"그린인터넷", "query":["그린인터넷"], "link":"http://green.naver.com/", "clickCd":"gnbSR_green"},
	{"name":"글로벌회화", "query":["글로벌회화"], "link":"http://phrasebook.naver.com/", "clickCd":"gnbSR_phrasebook"},
	{"name":"나눔글꼴", "query":["나눔글꼴"], "link":"http://hangeul.naver.com/font", "clickCd":"gnbSR_nanum"},
	{"name":"날씨", "query":["날씨"], "link":"http://weather.naver.com/", "clickCd":"gnbSR_weather"},
	{"name":"내정보", "query":["내정보"], "link":"https://nid.naver.com/user2/help/myInfo.nhn?menu=home", "clickCd":"gnbSR_myinfo"},
	{"name":"네이버me", "query":["네이버me", "네이버미"], "link":"http://me.naver.com", "clickCd":"gnbSR_me"},
	{"name":"네이버SE", "query":["네이버SE"], "link":"http://se.naver.com", "clickCd":"gnbSR_se"},
	{"name":"네이버랩", "query":["네이버랩"], "link":"http://lab.naver.com/", "clickCd":"gnbSR_lab"},
	{"name":"네이버쇼핑", "query":["지식쇼핑", "네이버쇼핑"], "link":"http://shopping.naver.com/", "clickCd":"gnbSR_shopping"},
	{"name":"네이버쇼핑입점", "query":["네이버쇼핑입점"], "link":"http://join.shopping.naver.com/index.nhn", "clickCd":"gnbSR_shopjoin"},
	{"name":"네이버캐스트", "query":["네이버캐스트"], "link":"http://navercast.naver.com/", "clickCd":"gnbSR_navercast"},
	{"name":"네이버트렌드", "query":["네이버트렌드", "네이버트랜드"], "link":"http://trend.naver.com", "clickCd":"gnbSR_trend"},
	{"name":"네이버페이", "query":["네이버페이", "네이버pay"], "link":"http://order.pay.naver.com/home", "clickCd":"gnbSR_pay"},
	{"name":"네이버 Works", "query":["네이버Works", "네이버웍스"], "link":"https://works.naver.com/", "clickCd":"gnbSR_works"},
	{"name":"네이버 캐쉬", "query":["네이버캐쉬"], "link":"https://bill.naver.com/pay/index.nhn", "clickCd":"gnbSR_cash"},
	{"name":"네이버클라우드", "query":["N드라이브", "엔드라이브", "앤드라이브", "네이버클라우드", "클라우드"], "link":"http://cloud.naver.com/index.nhn", "clickCd":"gnbSR_ndrive"},
	{"name":"뉴스", "query":["뉴스"], "link":"http://news.naver.com/", "clickCd":"gnbSR_news"},
	{"name":"뉴스라이브러리", "query":["뉴스라이브러리"], "link":"http://newslibrary.naver.com/search/searchByDate.nhn", "clickCd":"gnbSR_newslibrary"},
	{"name":"뉴스스탠드", "query":["뉴스스탠드"], "link":"http://newsstand.naver.com/", "clickCd":"gnbSR_newsstand"},
	{"name":"단어장", "query":["단어장"], "link":"http://wordbook.naver.com/", "clickCd":"gnbSR_wordbook"},
	{"name":"단축URL", "query":["단축URL"], "link":"http://me2.do/", "clickCd":"gnbSR_url"},
	{"name":"독일어사전", "query":["독일어사전"], "link":"http://dedic.naver.com/", "clickCd":"gnbSR_dedic"},
	{"name":"디스플레이광고", "query":["디스플레이광고"], "link":"http://displayad.naver.com/", "clickCd":"gnbSR_displayad"},
	{"name":"라틴어사전", "query":["라틴어사전"], "link":"http://ladic.naver.com", "clickCd":"gnbSR_ladic"},
	{"name":"러시아어사전", "query":["러시아어사전"], "link":"http://rudic.naver.com", "clickCd":"gnbSR_rudic"},
	{"name":"마일리지", "query":["마일리지"], "link":"http://mileage.naver.com/customer/home", "clickCd":"gnbSR_mileage"},
	{"name":"매거진캐스트", "query":["매거진캐스트"], "link":"http://navercast.naver.com/magazine_list.nhn", "clickCd":"gnbSR_magazine"},
	{"name":"메모", "query":["메모"], "link":"http://memo.naver.com/", "clickCd":"gnbSR_memo"},
	{"name":"메일", "query":["메일"], "link":"http://mail.naver.com/", "clickCd":"gnbSR_mail"},
	{"name":"모바일팜", "query":["모바일팜"], "link":"http://www.mobilefarms.com/", "clickCd":"gnbSR_mobilefarms"},
	{"name":"몽골어사전", "query":["몽골어사전"], "link":"http://mndic.naver.com/", "clickCd":"gnbSR_mndic"},
	{"name":"문자메시지", "query":["문자메시지"], "link":"http://webmsg.naver.com/message/webmsg_main.php", "clickCd":"gnbSR_message"},
	{"name":"뮤직", "query":["뮤직"], "link":"http://music.naver.com/", "clickCd":"gnbSR_music"},
	{"name":"미디어플레이어", "query":["미디어플레이어"], "link":"http://tools.naver.com/service/mediaplayer/index.nhn", "clickCd":"gnbSR_mediaplayer"},
	{"name":"백신", "query":["백신"], "link":"http://tools.naver.com/service/vaccine/index.nhn", "clickCd":"gnbSR_vaccine"},
	{"name":"번역기", "query":["번역기"], "link":"http://translate.naver.com/", "clickCd":"gnbSR_translate"},
	{"name":"베트남어사전", "query":["베트남어사전"], "link":"http://vndic.naver.com", "clickCd":"gnbSR_vndic"},
	{"name":"부동산", "query":["부동산"], "link":"http://land.naver.com/", "clickCd":"gnbSR_land"},
	{"name":"북마크", "query":["북마크"], "link":"http://bookmark.naver.com/", "clickCd":"gnbSR_bookmark"},
	{"name":"브랜드스토어", "query":["브랜드스토어"], "link":"http://nhnstore.naver.com/", "clickCd":"gnbSR_brandstore"},
	{"name":"블로그", "query":["블로그"], "link":"http://section.blog.naver.com/", "clickCd":"gnbSR_blog"},
	{"name":"비밀번호 찾기", "query":["비밀번호찾기"], "link":"https://nid.naver.com/user/help.nhn?todo=pwinquiry", "clickCd":"gnbSR_findpw"},
	{"name":"사전", "query":["사전"], "link":"http://dic.naver.com/", "clickCd":"gnbSR_dic"},
	{"name":"산지직송", "query":["산지직송"], "link":"http://checkout.naver.com/sanji/m/index.nhn", "clickCd":"gnbSR_sanji"},
	{"name":"소프트웨어(자료실)", "query":["소프트웨어(자료실)"], "link":"http://software.naver.com/", "clickCd":"gnbSR_software"},
	{"name":"스타일윈도우", "query":["스타일윈도우"], "link":"http://stylewindow.naver.com/home?f=nsearch", "clickCd":"gnbSR_stylewindow"},
	{"name":"스토리", "query":["스토리"], "link":"http://story.naver.com/naverbrand/main.nhn", "clickCd":"gnbSR_story"},
	{"name":"스토어팜", "query":["스토어팜"], "link":"http://sell.storefarm.naver.com/", "clickCd":"gnbSR_storefarm"},
	{"name":"스페인어사전", "query":["스페인어사전"], "link":"http://spdic.naver.com/", "clickCd":"gnbSR_spdic"},
	{"name":"스포츠", "query":["스포츠", "네이버스포츠"], "link":"http://sports.news.naver.com/", "clickCd":"gnbSR_sports"},
	{"name":"스포츠/라디오", "query":["스포츠/라디오"], "link":"http://sports.news.naver.com/radio/index.nhn", "clickCd":"gnbSR_sports_radio"},
	{"name":"스포츠/프로야구", "query":["스포츠/프로야구"], "link":"http://sports.news.naver.com/sports/index.nhn?category=baseball", "clickCd":"gnbSR_sports_baseball"},
	{"name":"신고센터", "query":["신고센터"], "link":"https://help.naver.com/support/reportCenter/home.nhn", "clickCd":"gnbSR_reportcenter"},
	{"name":"아이디 찾기", "query":["아이디찾기"], "link":"https://nid.naver.com/user/help.nhn?todo=idinquiry", "clickCd":"gnbSR_findid"},
	{"name":"아이템팩토리", "query":["아이템팩토리"], "link":"http://item2.naver.com/", "clickCd":"gnbSR_itemfactory"},
	{"name":"알바니아어사전", "query":["알바니아어사전"], "link":"http://aldic.naver.com/", "clickCd":"gnbSR_aldic"},
	{"name":"애널리틱스", "query":["애널리틱스", "analytics"], "link":"http://analytics.naver.com/", "clickCd":"gnbSR_analytics"},
	{"name":"연예", "query":["연예"], "link":"http://news.naver.com/main/main.nhn?mode=LSD&mid=shm&sid1=106", "clickCd":"gnbSR_news_ent"},
	{"name":"연예/스타캐스트", "query":["연예/스타캐스트"], "link":"http://news.naver.com/main/hotissue/sectionList.nhn?mid=hot&sid1=106&cid=941214", "clickCd":"gnbSR_news_starcast"},
	{"name":"열린연단", "query":["열린연단"], "link":"http://openlectures.naver.com/", "clickCd":"gnbSR_openlectures"},
	{"name":"영어/영영사전", "query":["영어/영영사전"], "link":"http://endic.naver.com/", "clickCd":"gnbSR_endic"},
	{"name":"영화", "query":["영화"], "link":"http://movie.naver.com/index.html", "clickCd":"gnbSR_movie"},
	{"name":"오늘의신문", "query":["오늘의신문"], "link":"http://newspaper.naver.com", "clickCd":"gnbSR_newspaper"},
	{"name":"오픈캐스트", "query":["오픈캐스트"], "link":"http://opencast.naver.com/", "clickCd":"gnbSR_opencast"},
	{"name":"오피스", "query":["오피스"], "link":"http://office.naver.com/", "clickCd":"gnbSR_office"},
	{"name":"우즈베크어사전", "query":["우즈베크어사전"], "link":"http://uzdic.naver.com/", "clickCd":"gnbSR_uzdic"},
	{"name":"우크라이나어사전", "query":["우크라이나어사전"], "link":"http://uadic.naver.com/", "clickCd":"gnbSR_uadic"},
	{"name":"웹마스터도구", "query":["웹마스터"], "link":"http://webmastertool.naver.com/", "clickCd":"gnbSR_webmastertool"},
	{"name":"웹소설", "query":["웹소설"], "link":"http://novel.naver.com", "clickCd":"gnbSR_webnovel"},
	{"name":"웹툰/만화", "query":["웹툰/만화"], "link":"http://comic.naver.com/index.nhn", "clickCd":"gnbSR_comic"},
	{"name":"위시카드", "query":["위시카드"], "link":"http://m.shopping.naver.com/wishcard/index.nhn", "clickCd":"gnbSR_wishcard"},
	{"name":"인도네시아어사전", "query":["인도네시아어사전"], "link":"http://iddic.naver.com/", "clickCd":"gnbSR_iddic"},
	{"name":"인물검색", "query":["인물검색"], "link":"http://people.search.naver.com/", "clickCd":"gnbSR_peoplesearch"},
	{"name":"일본어사전", "query":["일본어사전"], "link":"http://jpdic.naver.com/", "clickCd":"gnbSR_jpdic"},
	{"name":"자동차", "query":["자동차"], "link":"http://auto.naver.com/", "clickCd":"gnbSR_auto"},
	{"name":"작은창사전", "query":["작은창사전"], "link":"http://endic.naver.com/popManager.nhn?m=miniPopMain", "clickCd":"gnbSR_minidic"},
	{"name":"저작권 보호센터", "query":["저작권보호센터"], "link":"https://cpc.naver.com/cpc/index.nhn", "clickCd":"gnbSR_copyright"},
	{"name":"전문정보(학술)", "query":["전문정보(학술)"], "link":"http://academic.naver.com/", "clickCd":"gnbSR_academic"},
	{"name":"조지아어사전", "query":["조지아어사전"], "link":"http://gedic.naver.com/", "clickCd":"gnbSR_gedic"},
	{"name":"주소록", "query":["주소록"], "link":"http://contact.naver.com/", "clickCd":"gnbSR_contact"},
	{"name":"중국어사전", "query":["중국어사전"], "link":"http://cndic.naver.com/", "clickCd":"gnbSR_cndic"},
	{"name":"쥬니어네이버/헬로잉글리쉬", "query":["쥬니버/헬로잉글리쉬", "쥬니어네이버/헬로잉글리쉬"], "link":"http://study.jr.naver.com/english/", "clickCd":"gnbSR_jr_english"},
	{"name":"쥬니어네이버", "query":["쥬니버", "쥬니어네이버"], "link":"http://jr.naver.com/", "clickCd":"gnbSR_jr"},
	{"name":"쥬니어네이버/TV만화", "query":["쥬니버/TV만화", "쥬니어네이버/TV만화", "쥬니버/티비만화", "쥬니어네이버/티비만화"], "link":"http://fun.jr.naver.com/tv/", "clickCd":"gnbSR_jr_tvcomic"},
	{"name":"쥬니어네이버/게임랜드", "query":["쥬니버/게임랜드", "쥬니어네이버/게임랜드"], "link":"http://game.jr.naver.com/game/", "clickCd":"gnbSR_jr_game"},
	{"name":"쥬니어네이버/공룡나라", "query":["쥬니버/공룡나라", "쥬니어네이버/공룡나라"], "link":"http://study.jr.naver.com/dinosaurs/", "clickCd":"gnbSR_jr_dinosaurs"},
	{"name":"쥬니어네이버/동요세상", "query":["쥬니버/동요세상", "쥬니어네이버/동요세상"], "link":"http://study.jr.naver.com/dongyo/", "clickCd":"gnbSR_jr_dongyo"},
	{"name":"쥬니어네이버/동화여행", "query":["쥬니버/동화여행", "쥬니어네이버/동화여행"], "link":"http://study.jr.naver.com/donghwa/", "clickCd":"gnbSR_jr_donghwa"},
	{"name":"쥬니어네이버/디즈니", "query":["쥬니버/디즈니", "쥬니어네이버/디즈니"], "link":"http://fun.jr.naver.com/disney", "clickCd":"gnbSR_jr_disney"},
	{"name":"쥬니어네이버/레고", "query":["쥬니버/레고", "쥬니어네이버/레고"], "link":"http://fun.jr.naver.com/lego/", "clickCd":"gnbSR_jr_lego"},
	{"name":"쥬니어네이버/로보카폴리", "query":["쥬니버/로보카폴리", "쥬니어네이버/로보카폴리"], "link":"http://fun.jr.naver.com/poli/", "clickCd":"gnbSR_jr_poli"},
	{"name":"쥬니어네이버/만화책", "query":["쥬니버/만화책", "쥬니어네이버/만화책"], "link":"http://fun.jr.naver.com/comic/", "clickCd":"gnbSR_jr_comicbook"},
	{"name":"쥬니어네이버/뽀로로 놀이교실", "query":["쥬니버/뽀로로놀이교실", "쥬니어네이버/뽀로로놀이교실"], "link":"http://pororo.jr.naver.com/", "clickCd":"gnbSR_jr_pororo"},
	{"name":"쥬니어네이버/사파리", "query":["쥬니버/사파리", "쥬니어네이버/사파리"], "link":"http://study.jr.naver.com/safari/", "clickCd":"gnbSR_jr_safari"},
	{"name":"쥬니어네이버/성폭력 예방", "query":["쥬니버/성폭력예방", "쥬니어네이버/성폭력예방"], "link":"http://study.jr.naver.com/forchild/", "clickCd":"gnbSR_jr_forchild"},
	{"name":"쥬니어네이버/세서미 스트리트", "query":["쥬니버/세서미스트리트", "쥬니어네이버/세서미스트리트"], "link":"http://study.jr.naver.com/sesame/", "clickCd":"gnbSR_jr_sesame"},
	{"name":"쥬니어네이버/스케치북", "query":["쥬니버/스케치북", "쥬니어네이버/스케치북"], "link":"http://fun.jr.naver.com/sketchbook/", "clickCd":"gnbSR_jr_sketchbook"},
	{"name":"쥬니어네이버/스티커샵", "query":["쥬니버/스티커샵", "쥬니어네이버/스티커샵"], "link":"http://fun.jr.naver.com/shop/", "clickCd":"gnbSR_jr_stickershop"},
	{"name":"쥬니어네이버/아바타랜드", "query":["쥬니버/아바타랜드", "쥬니어네이버/아바타랜드"], "link":"http://avatar.jr.naver.com/", "clickCd":"gnbSR_jr_avatar"},
	{"name":"쥬니어네이버/어린이 실종예방", "query":["쥬니버/어린이실종예방", "쥬니어네이버/어린이실종예방"], "link":"http://study.jr.naver.com/mia/", "clickCd":"gnbSR_jr_missing"},
	{"name":"쥬니어네이버/엔크의 에너지 대모험", "query":["쥬니버/엔크의에너지대모험", "쥬니어네이버/엔크의에너지대모험"], "link":"http://fun.jr.naver.com/enc/index.nhn", "clickCd":"gnbSR_jr_enc"},
	{"name":"쥬니어네이버/우리들솜씨", "query":["쥬니버/우리들솜씨", "쥬니어네이버/우리들솜씨"], "link":"http://fun.jr.naver.com/artist/", "clickCd":"gnbSR_jr_artist"},
	{"name":"쥬니어네이버/유아세상", "query":["쥬니버/유아세상", "쥬니어네이버/유아세상"], "link":"http://study.jr.naver.com/babystudy/", "clickCd":"gnbSR_jr_baby"},
	{"name":"쥬니어네이버/코코몽", "query":["쥬니버/코코몽", "쥬니어네이버/코코몽"], "link":"http://fun.jr.naver.com/cocomong/", "clickCd":"gnbSR_jr_cocomong"},
	{"name":"쥬니어네이버/트리플래닛", "query":["쥬니버/트리플래닛", "쥬니어네이버/트리플래닛"], "link":"http://game.jr.naver.com/treeplanet/", "clickCd":"gnbSR_jr_treeplanet"},
	{"name":"증권/금융", "query":["증권/금융"], "link":"http://finance.naver.com/", "clickCd":"gnbSR_finance"},
	{"name":"지도", "query":["지도"], "link":"http://map.naver.com/", "clickCd":"gnbSR_map"},
	{"name":"지도/교통상황", "query":["지도/교통상황"], "link":"http://map.naver.com/?menu=location&dlevel=9&traffic=on&cctv=on", "clickCd":"gnbSR_map_traffic"},
	{"name":"지도/길찾기", "query":["지도/길찾기"], "link":"http://map.naver.com/?menu=route", "clickCd":"gnbSR_map_route"},
	{"name":"지도/실시간버스", "query":["지도/실시간버스"], "link":"http://map.naver.com/?menu=bus&perimeter=0&type=BUS_ROUTE", "clickCd":"gnbSR_map_bus"},
	{"name":"지도/지하철", "query":["지도/지하철"], "link":"http://map.naver.com/?menu=subway", "clickCd":"gnbSR_map_subway"},
	{"name":"지도/테마지도", "query":["지도/테마지도"], "link":"http://map.naver.com/?menu=openmap&openmap=1", "clickCd":"gnbSR_map_theme"},
	{"name":"지식iN", "query":["지식iN", "지식인"], "link":"http://kin.naver.com/", "clickCd":"gnbSR_kin"},
	{"name":"지식백과", "query":["지식백과"], "link":"http://terms.naver.com/", "clickCd":"gnbSR_terms"},
	{"name":"지역정보샵", "query":["지역정보샵"], "link":"http://localshop.naver.com", "clickCd":"gnbSR_localshop"},
	{"name":"쪽지", "query":["쪽지"], "link":"http://mail.naver.com/note/", "clickCd":"gnbSR_note"},
	{"name":"책", "query":["책"], "link":"http://book.naver.com/", "clickCd":"gnbSR_book"},
	{"name":"카페", "query":["카페"], "link":"http://section.cafe.naver.com/", "clickCd":"gnbSR_cafe"},
	{"name":"카페지원센터", "query":["카페지원센터"], "link":"http://cafe.naver.com/cafesupport/", "clickCd":"gnbSR_cafesupport"},
	{"name":"캄보디아어사전", "query":["캄보디아어사전"], "link":"http://khdic.naver.com/", "clickCd":"gnbSR_khdic"},
	{"name":"캘린더", "query":["캘린더"], "link":"http://calendar.naver.com/", "clickCd":"gnbSR_calendar"},
	{"name":"캡쳐", "query":["캡쳐"], "link":"http://tools.naver.com/service/capture", "clickCd":"gnbSR_capture"},
	{"name":"크로스미디어", "query":["크로스미디어"], "link":"http://crossmedia.naver.com", "clickCd":"gnbSR_crossmedia"},
	{"name":"클리너", "query":["클리너"], "link":"http://tools.naver.com/service/cleaner/index.nhn", "clickCd":"gnbSR_cleaner"},
	{"name":"터키어사전", "query":["터키어사전"], "link":"http://trdic.naver.com/", "clickCd":"gnbSR_trdic"},
	{"name":"투데이픽", "query":["투데이픽"], "link":"http://ntodaypick.naver.com/todaypick/m/index.nhn", "clickCd":"gnbSR_todaypick"},
	{"name":"툴바/툴즈", "query":["툴바/툴즈"], "link":"http://tools.naver.com", "clickCd":"gnbSR_tools"},
	{"name":"파트너센터", "query":["파트너센터"], "link":"https://www.navercorp.com/ko/company/partnersLine.nhn", "clickCd":"gnbSR_partner"},
	{"name":"포르투갈어사전", "query":["포르투갈어사전"], "link":"http://ptdic.naver.com", "clickCd":"gnbSR_ptdic"},
	{"name":"포스트", "query":["포스트", "POST"], "link":"http://post.naver.com/main.nhn", "clickCd":"gnbSR_post"},
	{"name":"포스트 에디터", "query":["포스트에디터", "posteditor", "post에디터"], "link":"http://editor.post.naver.com/", "clickCd":"gnbSR_posteditor"},
	{"name":"포토갤러리", "query":["포토갤러리"], "link":"http://new.photo.naver.com/", "clickCd":"gnbSR_photo"},
	{"name":"포토뷰어", "query":["포토뷰어"], "link":"http://tools.naver.com/service/photoviewer", "clickCd":"gnbSR_photoviewer"},
	{"name":"포토인화", "query":["포토인화"], "link":"http://photoprint.naver.com/", "clickCd":"gnbSR_photoprint"},
	{"name":"프라이버시센터", "query":["프라이버시센터"], "link":"http://privacy.naver.com", "clickCd":"gnbSR_privacy"},
	{"name":"프랑스어사전", "query":["프랑스어사전"], "link":"http://frdic.naver.com/", "clickCd":"gnbSR_frdic"},
	{"name":"한영번역기", "query":["한영번역기"], "link":"http://translate.naver.com/#/ko/en", "clickCd":"gnbSR_translate_en"},
	{"name":"한일번역기", "query":["한일번역기"], "link":"http://translate.naver.com/#/ko/ja", "clickCd":"gnbSR_translate_jp"},
	{"name":"한자사전", "query":["한자사전"], "link":"http://hanja.naver.com/", "clickCd":"gnbSR_hanjadic"},
	{"name":"항공권", "query":["항공권"], "link":"http://flights.search.naver.com/", "clickCd":"gnbSR_flights"},
	{"name":"해피빈", "query":["해피빈"], "link":"http://happybean.naver.com/", "clickCd":"gnbSR_happybean"},
	{"name":"회원가입", "query":["회원가입"], "link":"https://nid.naver.com/user2/join.nhn?m=init&lang=ko_KR", "clickCd":"gnbSR_join"}
];

var gnbSvcsArr = gnbSvcs.svc_lst1.concat(gnbSvcs.svc_lst2).concat(gnbSvcs.svc_lst3);

function gnbSvcFromId(value){
	for (var i = 0; i < gnbSvcsArr.length; i++) {
		if(gnbSvcsArr[i].id == value){
			return gnbSvcsArr[i];
		}
	};
}

function makeGnbSvcList(gnb_html_buffer){

	gnb_html_buffer.push("<div class=\"gnb_svc_lst1\">");

	var addServiceList = function(ulClassName, serviceList, html_buffer) {
		html_buffer.push("<ul class='" + ulClassName + "'>");
		for (var i=0, len=serviceList.length; i < len; i++) {
 			if (serviceList[i].id == 'naverpay') {
 				html_buffer.push("<li class=\"gnb_event\"><input type=\"checkbox\" id=\"nsvc_" + serviceList[i].id + "\" name=\"selmenu\" class=\"gnb_input_check\" value=\"\"> <label for=\"nsvc_" + serviceList[i].id + "\">" + serviceList[i].name + "</label><em class=\"ic_gnb_new\">New</em></li>");
 			} else{
 				html_buffer.push("<li><input type=\"checkbox\" id=\"nsvc_" + serviceList[i].id + "\" name=\"selmenu\" class=\"gnb_input_check\" value=\"\"> <label for=\"nsvc_" + serviceList[i].id + "\">" + serviceList[i].name + "</label></li>");	
 			};
		}
		html_buffer.push("</ul>");
	};

	addServiceList("gnb_first", gnbSvcs.svc_lst1.slice(0, 13), gnb_html_buffer);
	addServiceList("", gnbSvcs.svc_lst1.slice(13, 26), gnb_html_buffer);
	addServiceList("", gnbSvcs.svc_lst1.slice(26, gnbSvcs.svc_lst1.length), gnb_html_buffer);

	gnb_html_buffer.push("</div>");
	gnb_html_buffer.push("<div class=\"svc_lst2\">");
	gnb_html_buffer.push("<div class=\"svc_spc gnb_first\">");
	gnb_html_buffer.push("<strong><a href=\"http://dic.naver.com/\">어학사전</a></strong>");

	addServiceList("", gnbSvcs.svc_lst2, gnb_html_buffer);

	gnb_html_buffer.push("</div>");
	gnb_html_buffer.push("<div class=\"svc_spc\">");
	gnb_html_buffer.push("<strong>인기/신규서비스</strong>");

	addServiceList("", gnbSvcs.svc_lst3, gnb_html_buffer);

	gnb_html_buffer.push("</div>");
	gnb_html_buffer.push("</div>");
}

var gnb_html_buffer = [];
gnb_html_buffer.push("<strong class=\"blind\">사용자 링크</strong>");
gnb_html_buffer.push("<ul class=\"gnb_lst\" id=\"gnb_lst\" style=\"display:none\">");
gnb_html_buffer.push("<li class=\"gnb_login_li\" id=\"gnb_login_layer\">");
gnb_html_buffer.push("<a class=\"gnb_btn_login\" href=\"#\" id=\"gnb_login_button\"><span class=\"gnb_bg\"></span><span class=\"gnb_bdr\"></span><span class=\"gnb_txt\">로그인</span></a>");
gnb_html_buffer.push("</li>");
gnb_html_buffer.push("<li class=\"gnb_my_li\" id=\"gnb_my_layer\" style=\"display:none\">");
gnb_html_buffer.push("<div class=\"gnb_my_namebox\" id=\"gnb_my_namebox\">");
gnb_html_buffer.push("<a href=\"javascript:;\" class=\"gnb_my\" onclick=\"gnbUserLayer.clickToggle(); return false;\">");
gnb_html_buffer.push("<img id=\"gnb_profile_img\" src=\"data:image/gif;base64,R0lGODlhAQABAAD/ACwAAAAAAQABAAACADs%3D\" width=\"26\" height=\"26\" alt=\"내 프로필 이미지\"><span id=\"gnb_profile_filter_mask\" class=\"filter_mask\"></span>");
gnb_html_buffer.push(" <span class=\"gnb_name\" id=\"gnb_name1\"></span>");
gnb_html_buffer.push("<em class=\"blind\">내정보 보기</em>");
gnb_html_buffer.push("<span class=\"ico_arrow\"></span>");
gnb_html_buffer.push("</a>");
gnb_html_buffer.push("<a href=\"#\" class=\"gnb_emp\" id=\"gnb_emp\">(임직원혜택)</a>");
gnb_html_buffer.push("</div>");
gnb_html_buffer.push("<div class=\"gnb_my_lyr\" id=\"gnb_my_lyr\">");
gnb_html_buffer.push("<div class=\"gnb_my_content\">");
gnb_html_buffer.push("<div class=\"gnb_img_area\">");
gnb_html_buffer.push("<span class=\"gnb_mask\"></span>");
gnb_html_buffer.push("<img src=\"data:image/gif;base64,R0lGODlhAQABAAD/ACwAAAAAAQABAAACADs%3D\" width=\"80\" height=\"80\" alt=\"\">");
gnb_html_buffer.push("<a href=\"https://nid.naver.com/user2/api/naverProfile.nhn?m=checkIdType\" class=\"gnb_change\"><span class=\"blind\">프로필 사진 변경</span></a>");
gnb_html_buffer.push("</div>");
gnb_html_buffer.push("<div class=\"gnb_txt_area\">");
gnb_html_buffer.push("<p class=\"gnb_account\">");
gnb_html_buffer.push("<span class=\"gnb_name\" id=\"gnb_name2\"><a class=\"gnb_nick\" href=\"https://nid.naver.com/user2/api/naverProfile.nhn?m=checkIdType\">_</a>님</span>");
gnb_html_buffer.push("<a class=\"gnb_btn_login\" href=\"#\" id=\"gnb_logout_button\"><span class=\"gnb_bg\"></span><span class=\"gnb_bdr\"></span><span class=\"gnb_txt\">로그아웃</span></a>");
gnb_html_buffer.push("</p>");
gnb_html_buffer.push("<a href=\"http://mail.naver.com\" class=\"gnb_mail_address\">@naver.com</a>");
gnb_html_buffer.push("<ul class=\"gnb_edit_lst\">");
//gnb_html_buffer.push("<li class=\"gnb_profile\"><a href=\"http://me.naver.com/main.nhn?openProfile=true\">프로필 수정</a></li>");
gnb_html_buffer.push("<li class=\"gnb_info\"><a href=\"https://nid.naver.com/user2/help/myInfo.nhn?menu=home\">내정보</a></li>");
gnb_html_buffer.push("<li class=\"gnb_secure\" id=\"gnb_secure_lnk\"><a href=\"https://nid.naver.com/user2/help/myInfo.nhn?m=viewSecurity&menu=security\">보안설정</a></li>");
gnb_html_buffer.push("</ul>");
gnb_html_buffer.push("<p class=\"gnb_pay_check\" id=\"gnb_pay_check\">");
gnb_html_buffer.push("<em>N Pay</em><a href=\"http://pay.naver.com\" id=\"gnb_pay_point\"><span>내 페이포인트</span></a>");
gnb_html_buffer.push("</p>");
gnb_html_buffer.push("</div>");
gnb_html_buffer.push("</div>");
gnb_html_buffer.push("<div class=\"gnb_my_community\">");
gnb_html_buffer.push("<a href=\"http://blog.naver.com/MyBlog.nhn\" class=\"gnb_blog\">내 블로그</a>");
gnb_html_buffer.push("<a href=\"http://section.cafe.naver.com\" class=\"gnb_cafe\">가입한 카페</a>");
gnb_html_buffer.push("<a href=\"http://pay.naver.com\" class=\"gnb_pay\"><span>N Pay</span></a>");
gnb_html_buffer.push("</div>");
gnb_html_buffer.push("<a href=\"#\" class=\"gnb_my_interface\" style=\"display:none\"><span class=\"blind\">환경설정</span></a>");
gnb_html_buffer.push("</div>");
gnb_html_buffer.push("<iframe id=\"gnb_my_lyr_iframe\" title=\"빈 프레임\" class=\"gnb_pad_lyr\" name=\"padding\" width=\"0\" height=\"0\" scrolling=\"no\" frameborder=\"0\" style=\"top:34px;right:-4px;width:320px;height:174px;display:none;opacity:0;-ms-filter:alpha(opacity=0)\"></iframe>");
gnb_html_buffer.push("</li>");
gnb_html_buffer.push("");
gnb_html_buffer.push("<li class=\"gnb_notice_li\" id=\"gnb_notice_layer\" style=\"display:none\">");
gnb_html_buffer.push("<a href=\"javascript:;\" class=\"gnb_notice\" onclick=\"gnbNaverMeLayer.clickToggle(); return false;\">");
gnb_html_buffer.push("<span class=\"blind\">알림</span>");
gnb_html_buffer.push("<span class=\"gnb_icon\"></span>");
gnb_html_buffer.push("<em class=\"gnb_ico_num\" id=\"gnb_me_menu\" style=\"display:none\"><span class=\"gnb_ico_new\"><span class=\"gnb_count\" id=\"gnb_me_count\"></span></span></em>");
gnb_html_buffer.push("<span class=\"ico_arrow\"></span>");
gnb_html_buffer.push("</a>");
gnb_html_buffer.push("");
gnb_html_buffer.push("<div class=\"gnb_notice_lyr\" id=\"gnb_notice_lyr\">");
gnb_html_buffer.push("<div class=\"svc_noti svc_panel\">");
gnb_html_buffer.push("<div class=\"svc_scroll\">");
gnb_html_buffer.push("<div class=\"svc_head\">");
gnb_html_buffer.push("<strong class=\"gnb_tit\">전체 알림</strong>");
gnb_html_buffer.push("<div class=\"task_right\">");
gnb_html_buffer.push("<button onclick=\"gnbNaverMeLayer.deleteReadList(this, event);\" id=\"gnb_btn_read_noti_del\">읽은 알림 삭제</button>");
gnb_html_buffer.push("<button onclick=\"gnbNaverMeLayer.showDeleteAlert();\" id=\"gnb_btn_all_noti_del\">모두 삭제</button>");
gnb_html_buffer.push("</div>");
gnb_html_buffer.push("</div>");
gnb_html_buffer.push("<div class=\"svc_body\" id=\"gnb_naverme_layer\">");
gnb_html_buffer.push("</div>");
gnb_html_buffer.push("</div>");
gnb_html_buffer.push("<div class=\"gnb_ly_alert\" id=\"gnb_ly_alert\" style=\"display: none;\">");
gnb_html_buffer.push("<p class=\"gnb_msg\"><strong>알림을 모두 삭제하시겠습니까?</strong></p>");
gnb_html_buffer.push("<div class=\"gnb_btns\">");
gnb_html_buffer.push("<button id=\"ly_alert_confirm\" onclick=\"gnbNaverMeLayer.deleteAllList(this, event);\">확인</button>");
gnb_html_buffer.push("<button onclick=\"gnbNaverMeLayer.hideDeleteAlert();\">취소</button>");
gnb_html_buffer.push("</div>");
gnb_html_buffer.push("<button class=\"gnb_btn_close\" onclick=\"gnbNaverMeLayer.hideDeleteAlert();\"><i>레이어 닫기</i></button>");
gnb_html_buffer.push("</div>");
gnb_html_buffer.push("<a href=\"http://me.naver.com/box/noti.nhn\" class=\"gnb_notice_all\">내 알림 전체보기</a>");
gnb_html_buffer.push("</div>");
gnb_html_buffer.push("</div>");
gnb_html_buffer.push("<iframe id=\"gnb_notice_lyr_iframe\" title=\"빈 프레임\" class=\"gnb_pad_lyr\" name=\"padding\" width=\"0\" height=\"0\" scrolling=\"no\" frameborder=\"0\" style=\"top:34px;right:-4px;width:299px;height:332px;display:none;opacity:0;-ms-filter:alpha(opacity=0)\"></iframe>");
gnb_html_buffer.push("</li>");
gnb_html_buffer.push("");
gnb_html_buffer.push("<li class=\"mail_li\" id=\"gnb_mail_layer\" style=\"display:none\">");
gnb_html_buffer.push("<a href=\"http://mail.naver.com\" class=\"gnb_mail\">");
gnb_html_buffer.push("<span class=\"blind\">메일</span>");
gnb_html_buffer.push("<span class=\"gnb_icon\"></span>");
gnb_html_buffer.push("<em class=\"gnb_ico_num\" id=\"gnb_mail_menu\" style=\"display:none\"><span class=\"gnb_ico_new\"><span class=\"gnb_count\" id=\"gnb_mail_count\"></span></span></em>");
gnb_html_buffer.push("</a>");
gnb_html_buffer.push("</li>");
gnb_html_buffer.push("");
gnb_html_buffer.push("<li class=\"gnb_service_li\" id=\"gnb_service_layer\">");
gnb_html_buffer.push("<a href=\"javascript:;\" class=\"gnb_service\" onclick=\"gnbMoreLayer.clickToggle(); return false;\">");
gnb_html_buffer.push("<span class=\"blind\">서비스 더보기</span>");
gnb_html_buffer.push("<span class=\"gnb_icon\"></span>");
gnb_html_buffer.push("<span class=\"ico_arrow\"></span>");
gnb_html_buffer.push("</a>");
gnb_html_buffer.push("");
gnb_html_buffer.push("<div class=\"gnb_service_lyr\" id=\"gnb_service_lyr\">");
gnb_html_buffer.push("<div class=\"gnb_favorite_search\" id=\"gnb_favorite_search\">");
gnb_html_buffer.push("<div class=\"gnb_favorite_area\">");
gnb_html_buffer.push("<div class=\"gnb_favorite_lstwrp\">");
gnb_html_buffer.push("<div class=\"gnb_first_visit\" style=\"display:none\">");
gnb_html_buffer.push("<span class=\"blind\">나만의 즐겨찾기를 추가해 보세요!</span>");
gnb_html_buffer.push("<a href=\"#\" class=\"gnb_close\"><span class=\"blind\">닫기</span></a>");
gnb_html_buffer.push("</div>");
gnb_html_buffer.push("");
gnb_html_buffer.push("<strong class=\"blind\">즐겨찾는 서비스</strong>");
gnb_html_buffer.push("<ul class=\"gnb_favorite_lst\" id=\"gnb_favorite_lst\">");
gnb_html_buffer.push("<li class=\"gnb_add\"><a href=\"#\"><span class=\"ic_add\"></span>추가</a></li>");
gnb_html_buffer.push("<li class=\"gnb_add\"><a href=\"#\"><span class=\"ic_add\"></span>추가</a></li>");
gnb_html_buffer.push("<li class=\"gnb_add\"><a href=\"#\"><span class=\"ic_add\"></span>추가</a></li>");
gnb_html_buffer.push("<li class=\"gnb_add\"><a href=\"#\"><span class=\"ic_add\"></span>추가</a></li>");
gnb_html_buffer.push("</ul>");
gnb_html_buffer.push("<a href=\"#\" class=\"gnb_my_interface\"  onclick=\"gnbMoreLayer.clickToggleWhole(); return false;\"><span class=\"blind\">즐겨찾기 설정</span></a>");
gnb_html_buffer.push("</div>");
gnb_html_buffer.push("</div>");
gnb_html_buffer.push("<div class=\"gnb_search_area\">");
gnb_html_buffer.push("<div class=\"gnb_search_box\" onmouseover=\"gnb_search.mouseOver(this);\" onmouseout=\"gnb_search.mouseOut(this);\">");
gnb_html_buffer.push("<input id=\"gnb_svc_search_input\" type=\"text\" title=\"서비스 검색\" value=\"더 많은 서비스를 간편하게 시작하세요!\"  onfocus=\"gnb_search.clearInput(this);\" onblur=\"gnb_search.resetInput(this);\" onkeydown=\"gnb_search.keyDown(event);\" onkeyup=\"gnb_search.keyUp(event);\">");
gnb_html_buffer.push("<a href=\"#\" class=\"gnb_del_txt\" id=\"gnb_del_txt\" style=\"display:none\"><span class=\"blind\">삭제</span></a>");
gnb_html_buffer.push("<div class=\"gnb_pop_input\" id=\"gnb_pop_input\" tabindex=\"0\" onfocus=\"gnb_search.searchPopOnMouse = true; return false;\" onfocusout=\"gnb_search.searchPopOnMouse = false; return false;\" onmouseover=\"gnb_search.searchPopOnMouse = true; return false;\" onmouseout=\"gnb_search.searchPopOnMouse = false; return false;\" style=\"display:none\">");
gnb_html_buffer.push("<ul class=\"gnb_pop_lst\">");
gnb_html_buffer.push("</ul>");
gnb_html_buffer.push("</div>");
gnb_html_buffer.push("</div>");
gnb_html_buffer.push("<div class=\"gnb_search_lstwrp\">");
gnb_html_buffer.push("<ul class=\"gnb_search_lst gnb_first\">");
gnb_html_buffer.push("<li class=\"gnb_first\"><a href=\"http://cafe.naver.com/\">카페</a></li>");
gnb_html_buffer.push("<li><a href=\"http://news.naver.com/\">뉴스</a></li>");
gnb_html_buffer.push("<li><a href=\"http://map.naver.com/\">지도</a></li>");
gnb_html_buffer.push("<li><a href=\"http://sports.news.naver.com/\">스포츠</a></li>");
gnb_html_buffer.push("<li><a href=\"http://game.naver.com/\">게임</a></li>");
gnb_html_buffer.push("</ul>");
gnb_html_buffer.push("<ul class=\"gnb_search_lst\">");
gnb_html_buffer.push("<li class=\"gnb_first\"><a href=\"http://section.blog.naver.com/\">블로그</a></li>");
gnb_html_buffer.push("<li><a href=\"http://post.naver.com/main.nhn\">포스트</a></li>");
gnb_html_buffer.push("<li><a href=\"http://dic.naver.com/\">사전</a></li>");
gnb_html_buffer.push("<li><a href=\"http://kin.naver.com/\">지식iN</a></li>");
gnb_html_buffer.push("<li><a href=\"http://weather.naver.com/\">날씨</a></li>");
gnb_html_buffer.push("</ul>");
gnb_html_buffer.push("<ul class=\"gnb_search_lst\">");
gnb_html_buffer.push("<li class=\"gnb_first\"><a href=\"http://mail.naver.com/\">메일</a></li>");
gnb_html_buffer.push("<li><a href=\"http://stock.naver.com/\">증권</a></li>");
gnb_html_buffer.push("<li><a href=\"http://land.naver.com/\">부동산</a></li>");
gnb_html_buffer.push("<li><a href=\"http://music.naver.com/\">뮤직</a></li>");
gnb_html_buffer.push("<li><a href=\"http://book.naver.com\">책</a></li>");
gnb_html_buffer.push("</ul>");
gnb_html_buffer.push("<ul class=\"gnb_search_lst\">");
gnb_html_buffer.push("<li class=\"gnb_first\"><a href=\"http://shopping.naver.com/\">쇼핑</a></li>");
gnb_html_buffer.push("<li><a href=\"http://comic.naver.com/\">웹툰</a></li>");
gnb_html_buffer.push("<li><a href=\"http://movie.naver.com/\">영화</a></li>");
gnb_html_buffer.push("<li><a href=\"http://cloud.naver.com/\">클라우드</a></li>");
gnb_html_buffer.push("<li><a href=\"http://auto.naver.com/\">자동차</a></li>");
gnb_html_buffer.push("</ul>");
gnb_html_buffer.push("</div>");
gnb_html_buffer.push("</div>");
gnb_html_buffer.push("<div class=\"gnb_banner\"><a href=\"http://campaign.naver.com/pointevent/\" class=\"gnb_service_event\"><img id=\"gnb_promo\" alt=\"네이버페이 | " + (gnb_date.getMonth() + 1) + "월 이벤트\" width=\"265\" height=\"47\" src=\"https://ssl.pstatic.net/static/common/gnb/2014/promo_npay.png\"></a></div>");
gnb_html_buffer.push("<div class=\"gnb_linkwrp\"><a href=\"http://www.naver.com/more.html\" class=\"gnb_service_all\" id=\"gnb_service_all\">전체 서비스 보기</a></div>");
gnb_html_buffer.push("</div>");
gnb_html_buffer.push("");
gnb_html_buffer.push("<div class=\"gnb_svc_more\" id=\"gnb_svc_more\" style=\"\">");
gnb_html_buffer.push("<strong class=\"blind\">네이버 주요 서비스</strong>");
gnb_html_buffer.push("<div class=\"gnb_bg_top\"></div>");
gnb_html_buffer.push("<div class=\"gnb_svc_hd\"><strong class=\"gnb_svc_tit\">바로가기 설정</strong><span class=\"link\"><a href=\"http://www.naver.com/more.html\">전체 서비스 보기</a></span></div>");
gnb_html_buffer.push("<div class=\"gnb_svc_lstwrp\">");
makeGnbSvcList(gnb_html_buffer);
gnb_html_buffer.push("</div>");
gnb_html_buffer.push("<div class=\"svc_btnwrp\">");
gnb_html_buffer.push("<div class=\"svc_btns\">");
gnb_html_buffer.push("<button class=\"gnb_save\" onclick=\"if(gnbFavorite.addService()){gnbMoreLayer.clickToggleWhole()} return false;\"><strong class=\"blind\">확인</strong></button>");
gnb_html_buffer.push("<button class=\"gnb_close\" onclick=\"gnbFavorite.cancel(); return false;\"><span class=\"blind\">취소</span></button>");
gnb_html_buffer.push("<button class=\"gnb_return\" onclick=\"gnbFavorite.resetService(); return false;\"><span class=\"blind\">초기 설정으로 변경</span></button>");
gnb_html_buffer.push("</div>");
gnb_html_buffer.push("</div>");
gnb_html_buffer.push("<div class=\"gnb_bg_btm\"></div>");
gnb_html_buffer.push("</div>");
gnb_html_buffer.push("</div>");
gnb_html_buffer.push("<iframe id=\"gnb_service_lyr_iframe\" title=\"빈 프레임\" class=\"gnb_pad_lyr\" name=\"padding\" width=\"0\" height=\"0\" scrolling=\"no\" frameborder=\"0\" style=\"display:none;top:34px;right:297px;width:585px;height:385px;opacity:0;-ms-filter:alpha(opacity=0)\"></iframe>");
gnb_html_buffer.push("<iframe id=\"gnb_svc_more_iframe\" title=\"빈 프레임\" class=\"gnb_pad_lyr\" name=\"padding\" width=\"0\" height=\"0\" scrolling=\"no\" frameborder=\"0\" style=\"display:none;top:34px;right:-4px;width:295px;height:385px;opacity:0;-ms-filter:alpha(opacity=0)\"></iframe>");
gnb_html_buffer.push("</li>");
gnb_html_buffer.push("</ul>");

var gnb_html = gnb_html_buffer.join("");


var gnb_css_buffer = [];
gnb_css_buffer.push("@charset \"UTF-8\";");
gnb_css_buffer.push("/* NTS UIT Development Office YJH 140717 */");
gnb_css_buffer.push("a.gnb_my, .gnb_icon, #gnb .gnb_my_interface, #gnb .gnb_ico_num .gnb_ico_new, #gnb .gnb_ico_num .gnb_ico_new .gnb_count, .gnb_lst .ico_arrow, a.gnb_my .filter_mask, .gnb_my_lyr, .gnb_my_li .gnb_my_content .gnb_mask, .gnb_my_li .gnb_my_content .gnb_change, .gnb_my_li .gnb_my_content .gnb_edit_lst li, .gnb_my_li .gnb_my_content .gnb_pay_check em, #gnb .gnb_my_li .gnb_my_community a.gnb_pay span, .gnb_notice_li .gnb_notice_lyr, .gnb_notice_li .svc_list .gnb_ico_mail, .gnb_notice_li .svc_list .gnb_btn_remove span, .gnb_notice_li .svc_list .gnb_btn_remove i, .gnb_notice_li .gnb_error .gnb_ico_error, .gnb_ly_alert .gnb_btn_close i, .gnb_first_visit, .gnb_search_box, .gnb_search_box .gnb_del_txt, .gnb_svc_more .gnb_svc_lstwrp li.gnb_event em.ic_gnb_new, .gnb_svc_more .svc_btnwrp button {background: url(https://ssl.pstatic.net/static/common/gnb/one/sp_gnb_v14.png) no-repeat -999px -999px;}");
gnb_css_buffer.push(".gnb_favorite_area, .gnb_search_area, .gnb_banner, .gnb_linkwrp{background:url(https://ssl.pstatic.net/static/common/gnb/2014/bg_svclyr2_v2.png) no-repeat -999px -999px}");
gnb_css_buffer.push("#gnb .gnb_my_li .gnb_my_community a, .gnb_notice_li .gnb_notice_all, a.gnb_service_all, .gnb_svc_more .svc_btns{display:block;height:38px;border-top:1px solid #ebebeb;background-color:#f8f8f8;text-align:center;font-weight:bold;text-decoration:none;letter-spacing:-1px;line-height:38px}");
gnb_css_buffer.push("#gnb .gnb_my_li .gnb_my_community a:visited, .gnb_notice_li .gnb_notice_all:visited, a.gnb_service_all:visited, .gnb_svc_more .svc_btns:visited{color:#444}");
gnb_css_buffer.push(".gnb_login_li, .gnb_my_li, .gnb_notice_li, .mail_li, .gnb_service_li{float:left;margin-right:2px;overflow:visible}");
gnb_css_buffer.push(".gnb_login_li a, .gnb_my_li a, .gnb_notice_li a, .mail_li a, .gnb_service_li a{position:relative;z-index:100}");
gnb_css_buffer.push("a.gnb_my, .gnb_icon{position:relative}");
gnb_css_buffer.push("#gnb{position:relative;z-index:2147483646;font-family:'나눔고딕',NanumGothic,'돋움',Dotum,'Apple SD Gothic Neo',Helvetica,Sans-serif !important;color:#444;font-size:12px;letter-spacing:0 !important;line-height:normal !important;text-align:left !important}");
gnb_css_buffer.push("#gnb div, #gnb p, #gnb span, #gnb em, #gnb strong, #gnb h1, #gnb h2, #gnb h3, #gnb h4, #gnb h5, #gnb h6, #gnb ul, #gnb ol, #gnb li, #gnb dl, #gnb dt, #gnb dd, #gnb table, #gnb th, #gnb td, #gnb form, #gnb fieldset, #gnb legend, #gnb input, #gnb textarea, #gnb button, #gnb label{font-family:'나눔고딕',NanumGothic,'돋움',Dotum,'Apple SD Gothic Neo',Helvetica,Sans-serif !important}");
gnb_css_buffer.push("#gnb a, #gnb label, #gnb button{cursor:pointer}");
gnb_css_buffer.push("#gnb a, #gnb a:visited, #gnb a:active, #gnb a:focus{color:#444}");
gnb_css_buffer.push("#gnb a:hover{color:#444;text-decoration:underline}");
gnb_css_buffer.push("#gnb input::-ms-clear{display:none}");
gnb_css_buffer.push("#gnb em{font-style:normal}");
gnb_css_buffer.push("#gnb ul{list-style:none}");
gnb_css_buffer.push("#gnb .blind{display:block;overflow:hidden;position:absolute;top:-1000em;left:0;width:1px;height:1px;margin:0;padding:0;font-size:0;line-height:0}");
gnb_css_buffer.push("#gnb .gnb_my_interface{padding:5px;position:absolute;top:12px;right:8px;display:block;width:17px;height:16px;background-position:-90px 5px}");
gnb_css_buffer.push("#gnb .gnb_my_interface:hover{background-position:-90px -20px}");
gnb_css_buffer.push("#gnb .gnb_pad_lyr{position:absolute}");
gnb_css_buffer.push("#gnb .gnb_ico_num{display:block;position:absolute;top:1px;width:40px;text-align:center}");
gnb_css_buffer.push("#gnb .gnb_ico_num .gnb_ico_new{height:15px;display:inline-block;background-position:-331px 0;zoom:1}");
gnb_css_buffer.push("#gnb .gnb_ico_num .gnb_ico_new .gnb_count{position:relative;top:0;right:-5px;height:15px;margin:0;padding:0 4px 0 1px;display:inline-block;*display:inline;vertical-align:top;background-position:100% 0;text-indent:-2px;font-family:tahoma !important;font-weight:bold;color:#fff;zoom:1}");
gnb_css_buffer.push("#gnb .gnb_ico_num .gnb_ico_new .plus{margin:1px -1px 0 2px;font-size:8px;display:inline-block;color:#fff;vertical-align:top}");
gnb_css_buffer.push(":root #gnb .gnb_pad_lyr{opacity:1 !important;background:#fff}");
gnb_css_buffer.push(".gnb_lst{margin:0;padding:0;zoom:1}");
gnb_css_buffer.push(".gnb_lst:after{display:block;clear:both;content:''}");
gnb_css_buffer.push(".gnb_lst ul{margin:0;padding:0}");
gnb_css_buffer.push(".gnb_lst .ico_arrow{display:none;position:absolute;left:50%;top:27px;width:10px;height:8px;margin-left:-5px;background-position:-175px -10px}");
gnb_css_buffer.push(".gnb_lyr_opened .gnb_my_lyr, .gnb_lyr_opened .gnb_service_lyr, .gnb_lyr_opened .gnb_notice_lyr, .gnb_lyr_opened .ico_arrow{display:block !important}");
gnb_css_buffer.push(".gnb_login_li{height:23px;padding:5px 7px 0 0}");
gnb_css_buffer.push(".gnb_btn_login, .gnb_bg, .gnb_bdr{display:inline-block;width:46px;height:20px;font-size:12px}");
gnb_css_buffer.push(".gnb_btn_login{position:relative}");
gnb_css_buffer.push(".gnb_bg{background-color: #fff;opacity: 0.05;filter: alpha(opacity=5);}");
gnb_css_buffer.push(".gnb_bdr{position:absolute;top: -1px;left: -1px;width: 46px;height: 20px;border: 1px solid #000;opacity: 0.12;filter: alpha(opacity=12);}");
gnb_css_buffer.push(".gnb_txt{position:absolute;top:0;left:0;width:45px;height:20px;padding-left:1px;line-height:21px;color:#777;text-align:center}");
gnb_css_buffer.push(".gnb_btn_login:hover{text-decoration:none !important}");
gnb_css_buffer.push(".gnb_account .gnb_btn_login{width:54px;margin:-1px 0 0 4px;vertical-align:top}");
gnb_css_buffer.push(".gnb_account .gnb_bdr{width:52px}");
gnb_css_buffer.push(".gnb_account .gnb_txt{width:53px}");
gnb_css_buffer.push(".gnb_my_li{margin-right:7px}");
gnb_css_buffer.push(".gnb_my_namebox{padding:2px 9px 0 0;background-repeat:no-repeat;background-position:100% 50%;zoom:1}");
gnb_css_buffer.push(".gnb_my_namebox:after{display:block;clear:both;content:''}");
gnb_css_buffer.push("a.gnb_my{float:left;display:block;font-size:0;vertical-align:middle}");
gnb_css_buffer.push("a.gnb_my .filter_mask {position: absolute;top: -1px;left: -1px;z-index: 1;width: 28px;height: 28px;background-position: -260px -60px;}");
gnb_css_buffer.push("a.gnb_my img{vertical-align:top;border-radius:16px}");
gnb_css_buffer.push("a.gnb_my .gnb_name{margin-right:-1px;padding-left:5px;display:inline-block;height:28px;line-height:28px;vertical-align:top;font-size:11px;color:#444}");
gnb_css_buffer.push("a.gnb_my:visited{color:#444}");
gnb_css_buffer.push("a.gnb_my:hover, a.gnb_my:active, a.gnb_my:visited, a.gnb_my:focus{text-decoration:none !important}");
gnb_css_buffer.push("a.gnb_my:hover .gnb_name{text-decoration:underline}");
gnb_css_buffer.push("a.gnb_my .ico_arrow{top:25px;margin-left:8px}");
gnb_css_buffer.push(".gnb_my_namebox a.gnb_emp{float:left;display:inline-block;height:28px;margin-left:3px;line-height:28px;font-size:11px;color:#777 !important}");
gnb_css_buffer.push(".gnb_my_lyr{display:none;position:absolute;top:26px;right:-8px;padding:9px 5px 4px 4px;width:316px;height:172px;background-position:-2px -1310px;z-index:10}");
gnb_css_buffer.push(".gnb_my_lyr.gnb_groupid{height:144px;background-position:-2px -1500px}");
gnb_css_buffer.push(".gnb_my_lyr.gnb_groupid .gnb_my_content{height:80px}");
gnb_css_buffer.push(".gnb_my_lyr.gnb_groupid.gnb_longid1{height:144px;background-position:-2px -1664px}");
gnb_css_buffer.push(".gnb_my_lyr.gnb_groupid.gnb_longid2{height:144px;background-position:-2px -1828px}");
gnb_css_buffer.push(".gnb_my_lyr.gnb_longid1{width:318px;background-position:-2px -1118px}");
gnb_css_buffer.push(".gnb_my_lyr.gnb_longid2{width:348px;background-position:-2px -926px}");
gnb_css_buffer.push(".gnb_my_li .gnb_my_content{zoom:1;height:108px;padding:15px 0 10px 15px}");
gnb_css_buffer.push(".gnb_my_li .gnb_my_content:after{display:block;clear:both;content:''}");
gnb_css_buffer.push(".gnb_my_li .gnb_my_content .gnb_img_area{float:left;position:relative;display:block;width:80px}");
gnb_css_buffer.push(".gnb_my_li .gnb_my_content .gnb_img_area img{vertical-align:top}");
gnb_css_buffer.push(".gnb_my_li .gnb_my_content .gnb_mask{position:absolute;top:0;left:0;display:block;width:80px;height:80px;background-position:-70px -60px}");
gnb_css_buffer.push(".gnb_my_li .gnb_my_content .gnb_change{position:absolute;bottom:-2px;left:-2px;display:block;width:28px;height:28px;background-position:-140px 0px}");
gnb_css_buffer.push(".gnb_my_li .gnb_my_content .gnb_change:hover{background-position:-140px -30px}");
gnb_css_buffer.push(".gnb_my_li .gnb_my_content .gnb_txt_area{float:left;width:212px;margin:5px 0 0 9px}");
gnb_css_buffer.push(".gnb_longid1 .gnb_my_content .gnb_txt_area{width:210px}");
gnb_css_buffer.push(".gnb_longid2 .gnb_my_content .gnb_txt_area{width:235px}");
gnb_css_buffer.push(".gnb_my_li .gnb_my_content .gnb_account{margin-bottom:3px;font-size:0}");
gnb_css_buffer.push(".gnb_my_li .gnb_my_content .gnb_name{color:#777;font-size:14px}");
gnb_css_buffer.push(".gnb_my_li .gnb_my_content .gnb_name a{display:inline-block;vertical-align:top;font-weight:bold;color:#444}");
gnb_css_buffer.push(".gnb_my_li .gnb_my_content a.gnb_mail_address{font-family:tahoma;color:#777 !important;font-size:14px}");
gnb_css_buffer.push(".gnb_my_li .gnb_my_content .gnb_edit_lst{zoom:1;margin-top:9px !important}");
gnb_css_buffer.push(".gnb_my_li .gnb_my_content .gnb_edit_lst:after{display:block;clear:both;content:''}");
gnb_css_buffer.push(".gnb_my_li .gnb_my_content .gnb_edit_lst li{float:left;padding-left:8px;margin-left:8px;background-position:-290px -25px}");
gnb_css_buffer.push(".gnb_my_li .gnb_my_content .gnb_edit_lst li.gnb_info{padding-left:0;margin-left:0;background:none}");
gnb_css_buffer.push(".gnb_my_li .gnb_my_content .gnb_edit_lst a{color:#019a30 !important;text-decoration:underline;letter-spacing:-1px}");
gnb_css_buffer.push(".gnb_my_li .gnb_my_content .gnb_pay_check{height:16px;margin:16px -4px 0 0 !important}");
gnb_css_buffer.push("@media screen and (min-width: 0\\0) { .gnb_my_li .gnb_my_content .gnb_pay_check{margin-top:17px} }");
gnb_css_buffer.push(".gnb_my_li .gnb_my_content .gnb_pay_check em{display:inline-block;width:16px;height:16px;background-position:-300px -309px;margin:0 4px 0 0;overflow:hidden;font-size:0;line-height:0;vertical-align:top}");
gnb_css_buffer.push(".gnb_my_li .gnb_my_content .gnb_pay_check a{font-size:14px;letter-spacing:-1px;line-height:16px;vertical-align:top}");
gnb_css_buffer.push(".gnb_my_li .gnb_my_content .gnb_pay_check span{padding-right:5px}");
gnb_css_buffer.push(".gnb_my_li .gnb_my_content .gnb_pay_check strong{font-family:tahoma;letter-spacing:0;word-spacing:-30px}");
gnb_css_buffer.push(".gnb_my_li .gnb_my_content .gnb_pay_check a, .gnb_my_li .gnb_my_content .gnb_pay_check span, .gnb_my_li .gnb_my_content .gnb_pay_check strong{font-size:14px;color:#019a30 !important}");
gnb_css_buffer.push("#gnb .gnb_my_li .gnb_my_community{clear:both;zoom:1}");
gnb_css_buffer.push("#gnb .gnb_my_li .gnb_my_community:after{display:block;clear:both;content:''}");
gnb_css_buffer.push("#gnb .gnb_my_li .gnb_my_community a{float:left;width:106px;margin-right: 0;border-right:1px solid #ebebeb}");
gnb_css_buffer.push("#gnb .gnb_my_li .gnb_my_community a.gnb_pay{width:102px;border-right:0;line-height:0}");
gnb_css_buffer.push("#gnb .gnb_my_li .gnb_my_community a.gnb_pay span{display:inline-block;width:41px;height:16px;background-position:-300px -334px;margin:11px auto 0;font-size:0;line-height:0}");
gnb_css_buffer.push("#gnb .gnb_my_li .gnb_my_community a:active, #gnb .gnb_my_li .gnb_my_community a:focus, #gnb .gnb_my_li .gnb_my_community a:visited{text-decoration:none !important}");
gnb_css_buffer.push("#gnb .gnb_my_li .gnb_my_community a:hover{text-decoration:underline !important}");
gnb_css_buffer.push("#gnb .gnb_my_lyr.gnb_longid1 .gnb_my_community a{width:105px}");
gnb_css_buffer.push("#gnb .gnb_my_lyr.gnb_longid1 .gnb_my_community a.gnb_pay{width:106px}");
gnb_css_buffer.push("#gnb .gnb_my_lyr.gnb_longid2 .gnb_my_community a{width:115px}");
gnb_css_buffer.push("#gnb .gnb_my_lyr.gnb_longid2 .gnb_my_community a.gnb_pay{width:116px}");
gnb_css_buffer.push("#gnb.gnb_one .gnb_my_community a, #gnb.gnb_one_small .gnb_my_community a{margin-right: 0 !important;}");
gnb_css_buffer.push(".gnb_notice_li a.gnb_notice{display:block;width:15px;height:17px;padding:7px 9px 4px;text-decoration:none !important}");
gnb_css_buffer.push(".gnb_notice_li a.gnb_notice .gnb_ico_num{left:1px;top:0}");
gnb_css_buffer.push(".gnb_notice_li a.gnb_notice .gnb_icon{display:block;width:15px;height:17px;background-position:-3px -60px}");
gnb_css_buffer.push(".gnb_notice_li a.gnb_notice:hover .gnb_icon{background-position:-38px -60px;text-decoration:none !important}");
gnb_css_buffer.push(".gnb_notice_li .gnb_notice_lyr{display:none;position:absolute;top:26px;right:-7px;width:297px;height:330px;padding:9px 4px 4px;background-position:-2px -584px;z-index:10;overflow:hidden}");
gnb_css_buffer.push(".gnb_notice_li .svc_scroll{height:291px;overflow:scroll;overflow-x:hidden;position:relative;zoom:1}");
gnb_css_buffer.push(".gnb_notice_li .svc_panel{width:100%;height:330px;overflow:hidden}");
gnb_css_buffer.push(".gnb_notice_li .svc_head{position:relative;height:36px;padding-left:15px;line-height:20px;border-bottom:1px solid #eaeaea;zoom:1}");
gnb_css_buffer.push(".gnb_notice_li .svc_head .gnb_tit{color:#6b6d70;margin-right:1px;line-height:36px}");
gnb_css_buffer.push(".gnb_notice_li .svc_head .task_right{position:absolute;right:8px;top:8px;font-size:0}");
gnb_css_buffer.push(".gnb_notice_li .svc_head .task_right button{height:20px;padding:0 6px;margin-left:4px;border:1px solid #ddd;color:#888;background-color:#fff;font-family:'나눔고딕', NanumGothic;font-size:12px;letter-spacing:-1px;line-height:18px;*line-height:16px;overflow:visible}");
gnb_css_buffer.push(".gnb_notice_li .svc_list .gnb_btn_remove i, .gnb_notice_li .svc_list .gnb_btn_remove span, .gnb_notice_li .svc_noti .gnb_ico_mail, .gnb_notice_li .svc_blank .svc_msg_box, .gnb_notice_li .svc_blank .gnb_v_guide{display:inline-block;*display:inline;*zoom:1}");
gnb_css_buffer.push(".gnb_notice_li .svc_list{margin-top:-1px}");
gnb_css_buffer.push(".gnb_notice_li .svc_list li{position:relative;padding:7px 34px 7px 15px;border-top:1px solid #eaeaea;line-height:18px}");
gnb_css_buffer.push(".gnb_notice_li .svc_list .gnb_new{background:#ffffd8}");
gnb_css_buffer.push(".gnb_notice_li .svc_list .gnb_unread .gnb_subject{color:#444}");
gnb_css_buffer.push(".gnb_notice_li .svc_list .gnb_unread .d_cnt{color:#ff630e}");
gnb_css_buffer.push(".gnb_notice_li .svc_list .gnb_unread a:hover .gnb_subject, .gnb_notice_li .svc_list .gnb_unread .gnb_unread a:hover .d_cnt{color:#390}");
gnb_css_buffer.push(".gnb_notice_li .svc_list .gnb_unread .svc_name{color:#444}");
gnb_css_buffer.push(".gnb_notice_li .svc_list a.gnb_list_cover{text-decoration:none !important;display:block;position:relative;zoom:1}");
gnb_css_buffer.push(".gnb_notice_li .svc_list a:hover .gnb_subject{text-decoration:underline}");
gnb_css_buffer.push(".gnb_notice_li .svc_list .gnb_subject{overflow:hidden;text-overflow:ellipsis;white-space:nowrap;width:100%;color:#adadad}");
gnb_css_buffer.push(".gnb_notice_li .svc_list .d_cnt{font-family:tahoma;font-size:10px}");
gnb_css_buffer.push(".gnb_notice_li .svc_list .gnb_info{color:#adadad}");
gnb_css_buffer.push(".gnb_notice_li .svc_list .svc_name{margin-right:3px;color:#adadad}");
gnb_css_buffer.push(".gnb_notice_li .svc_list .cchr{margin-right:3px}");
gnb_css_buffer.push(".gnb_notice_li .svc_list .dona{position:absolute;top:8px;right:34px;text-decoration:underline}");
gnb_css_buffer.push(".gnb_notice_li .svc_list .dona a{color:#adadad}");
gnb_css_buffer.push(".gnb_notice_li .svc_list .dona a:hover{color:#390}");
gnb_css_buffer.push(".gnb_notice_li .svc_list .gnb_ico_mail{width:14px;height:15px;font-size:0;line-height:0;color:#fff;vertical-align:top}");
gnb_css_buffer.push(".gnb_notice_li .svc_list .gnb_ico_mail.gnb_yes{background-position:-245px -17px}");
gnb_css_buffer.push(".gnb_notice_li .svc_list .gnb_ico_mail.gnb_no{background-position:-245px 4px}");
gnb_css_buffer.push(".gnb_notice_li .svc_list .gnb_btn_remove{position:absolute;right:4px;top:50%;z-index:100;margin-top:-13px;padding:10px;line-height:6px;font-size:0;background:none !important;border:0 !important}");
gnb_css_buffer.push(".gnb_notice_li .svc_list .gnb_btn_remove span, .gnb_notice_li .svc_list .gnb_btn_remove i{display:block !important;width:7px;height:7px;font-size:0;line-height:0;color:transparent;white-space:nowrap;overflow:hidden;vertical-align:top;background-position:-175px 0}");
gnb_css_buffer.push(".gnb_notice_li .svc_blank{position:absolute;top:104px;left:0;width:100%;white-space:nowrap;height:100px;font-size:0;text-align:center}");
gnb_css_buffer.push(".gnb_notice_li .svc_blank .svc_msg_box{white-space:normal;font-size:12px;width:100%}");
gnb_css_buffer.push(".gnb_notice_li .svc_blank .gnb_tit{display:block;color:#2f3743;font-size:14px;margin:0 0 15px}");
gnb_css_buffer.push(".gnb_notice_li .svc_blank .gnb_tit strong{font-weight:normal;color:#390}");
gnb_css_buffer.push(".gnb_notice_li .svc_blank .gnb_desc{line-height:19px;color:#2f3743;margin-bottom:7px}");
gnb_css_buffer.push(".gnb_notice_li .svc_blank .gnb_desc a, .gnb_notice_li .svc_blank .gnb_link{color:#390;text-decoration:underline}");
gnb_css_buffer.push(".gnb_notice_li .svc_blank .gnb_v_guide{vertical-align:middle;height:100%;width:0}");
gnb_css_buffer.push(".gnb_notice_li .svc_blank .gnb_link_wrap{text-align:center}");
gnb_css_buffer.push(".gnb_notice_li .svc_blank .gnb_link_wrap .gnb_link{display:block;width:40px;margin:0 auto !important;text-align:center}");
gnb_css_buffer.push(".gnb_notice_li .svc_loading{background:url(https://ssl.pstatic.net/static/www/2014/loading.gif) no-repeat #fff center center;position:absolute;top:33px;left:0;width:100%;height:245px}");
gnb_css_buffer.push(".gnb_notice_li .gnb_error{position:absolute;top:81px;left:2px;width:100%;color:#444;text-align:center}");
gnb_css_buffer.push(".gnb_notice_li .gnb_error .gnb_ico_error{display:inline-block;width:57px;height:57px;background-position:-280px -190px}");
gnb_css_buffer.push(".gnb_notice_li .gnb_error .gnb_tit{font-size:14px;margin:15px 0 11px}");
gnb_css_buffer.push(".gnb_notice_li .gnb_error .gnb_desc{margin-bottom:13px;line-height:18px}");
gnb_css_buffer.push(".gnb_notice_li .gnb_error .gnb_link{text-decoration:underline}");
gnb_css_buffer.push(".gnb_ly_alert{position:absolute;top:110px;left:13px;background-color:#fff;border:1px solid #b7b9bc;width:260px;padding:34px 0 20px;zoom:1;z-index:100}");
gnb_css_buffer.push(".gnb_ly_alert .gnb_msg{text-align:center;line-height:17px;margin-bottom:14px;color:#2f3743}");
gnb_css_buffer.push(".gnb_.ly_alert .gnb_btn_close{position:absolute;right:2px;top:0;*overflow:visible}");
gnb_css_buffer.push(".gnb_ly_alert .gnb_btns{text-align:center}");
gnb_css_buffer.push(".gnb_ly_alert .gnb_btns button{height:27px;line-height:27px;*line-height:22px;font-weight:bold;font-size:12px;padding:0 8px;color:#2f3743;border:1px solid #ddd;background-color:white}");
gnb_css_buffer.push(".gnb_ly_alert .gnb_btns button:first-child{margin-right:4px}");
gnb_css_buffer.push(".gnb_ly_alert .gnb_btn_close{position:absolute;right:2px;top:0;width:35px;border:0;background:none;cursor:pointer;border-radius:0;padding:10px}");
gnb_css_buffer.push(".gnb_ly_alert .gnb_btn_close i{display:block;width:15px;height:15px;font:0/0 a;color:transparent;white-space:nowrap;overflow:hidden;vertical-align:top;background-position:-240px -60px}");
gnb_css_buffer.push(".mail_li a.gnb_mail{display:block;width:20px;height:15px;padding:7px 9px 6px;text-decoration:none !important}");
gnb_css_buffer.push(".mail_li a.gnb_mail .gnb_icon{display:block;width:20px;height:15px;background-position:0px -95px}");
gnb_css_buffer.push(".mail_li a.gnb_mail:hover .gnb_icon{background-position:-35px -95px;text-decoration:none !important}");
gnb_css_buffer.push(".mail_li .gnb_ico_num{left:6px;top:0}");
gnb_css_buffer.push(".gnb_service_li{margin-right:0}");
gnb_css_buffer.push(".gnb_service_li a.gnb_service{display:block;width:16px;height:16px;padding:7px 9px 5px}");
gnb_css_buffer.push(".gnb_service_li a.gnb_service .gnb_icon{display:block;width:16px;height:16px;background-position:-2px -130px}");
gnb_css_buffer.push(".gnb_service_li a.gnb_service:hover .gnb_icon{background-position:-37px -130px;text-decoration:none !important}");
gnb_css_buffer.push(".gnb_service_li .gnb_service_lyr{display:none;position:absolute;top:27px;right:-7px;z-index:10}");
gnb_css_buffer.push(".gnb_favorite_search{width:301px;letter-spacing:-1px}");
gnb_css_buffer.push(".gnb_response .gnb_favorite_search{display:none}");
gnb_css_buffer.push(".gnb_favorite_area{height:93px;padding:8px 4px 0;background-position:0 0}");
gnb_css_buffer.push(".gnb_favorite_lstwrp{position:relative;padding:22px 1px 15px 15px;border-bottom:1px solid #ebebeb}");
gnb_css_buffer.push(".gnb_favorite_lstwrp .gnb_my_interface{top:3px !important;right:3px !important}");
gnb_css_buffer.push(".gnb_first_visit{position:absolute;top:0;left:0;width:293px;height:92px;background-position:0 -310px;z-index:200}");
gnb_css_buffer.push(".gnb_first_visit .gnb_close{position:absolute;top:0;right:0;display:block;width:32px;height:32px}");
gnb_css_buffer.push(".gnb_favorite_lst{zoom:1}");
gnb_css_buffer.push(".gnb_favorite_lst:after{display:block;clear:both;content:''}");
gnb_css_buffer.push(".gnb_favorite_lst li{float:left;width:65px;text-align:center;white-space:nowrap}");
gnb_css_buffer.push(".gnb_favorite_lst a{display:inline-block;text-align:center;font-weight:bold}");
gnb_css_buffer.push(".gnb_favorite_lst .gnb_add a{display:block;test-align:center;}");
gnb_css_buffer.push(".gnb_favorite_lst .gnb_add a span.ic_add{display: block;width: 36px;height: 36px;margin: 0 auto 4px;background-image: url(https://ssl.pstatic.net/static/common/gnb/one/sp_gnb_4b16e6.png);background-position: 0px 0px;background-repeat: no-repeat;width: 36px;height: 36px;vertical-align: top;}");
gnb_css_buffer.push(".gnb_favorite_lst .gnb_add a:hover span.ic_add{background-image: url(https://ssl.pstatic.net/static/common/gnb/one/sp_gnb_4b16e6.png);background-position: -42px 0px;background-repeat: no-repeat;width: 36px;height: 36px;vertical-align: top;}");
gnb_css_buffer.push(".gnb_favorite_lst img{display:block;margin:0 auto 4px;vertical-align:top}");
gnb_css_buffer.push(".gnb_search_area{position:relative;z-index:200;padding:18px 4px 17px;background-position:-301px 0;background-repeat:repeat-y}");
gnb_css_buffer.push(".gnb_search_box{position:relative;z-index:101;margin:0 12px 16px 0;padding-left:10px;display:block;width:270px;height:35px;background-position:10px -190px}");
gnb_css_buffer.push(".gnb_search_box.over{background-position:10px -230px}");
gnb_css_buffer.push(".gnb_search_box.fcs{background-position:10px -270px}");
gnb_css_buffer.push(".gnb_search_box.fcs input{width:200px;font-size:16px;font-weight:bold;color:#444;outline:0}");
gnb_css_buffer.push(".gnb_search_box input{float:left;display:block;width:210px;height:22px;margin-top:6px;padding-left:10px;font-family:'나눔고딕',NamumGothic;letter-spacing:-1px;color:#adadad;font-size:13px;border:0;line-height:22px;background:transparent}");
gnb_css_buffer.push(".gnb_search_box .gnb_del_txt{position:absolute;top:8px;right:32px;display:block;width:17px;height:17px;background-position:-190px 0px}");
gnb_css_buffer.push(".gnb_search_box .gnb_del_txt:hover{background-position:-190px -20px}");
gnb_css_buffer.push(".gnb_search_box .gnb_pop_input{position:absolute;top:34px;left:10px;width:268px;height:170px;*height:172px;border:1px solid #cbc5c5;border-top:0;background:#fff;overflow-x:hidden;overflow-y:scroll;z-index:110}");
gnb_css_buffer.push(".gnb_search_box .gnb_pop_lst{padding:4px 0 2px}");
gnb_css_buffer.push(".gnb_search_box .gnb_pop_lst a{display:block;padding:6px 0 6px 10px;font-weight:bold}");
//gnb_css_buffer.push(".gnb_search_box .gnb_pop_lst a:hover{text-decoration:none;background-color:#f5f5f5}");
gnb_css_buffer.push(".gnb_search_box .gnb_pop_lst .on{background-color:#f5f5f5}");
gnb_css_buffer.push(".gnb_search_lstwrp{zoom:1;height:118px;padding-left:12px}");
gnb_css_buffer.push(".gnb_search_lstwrp:after{display:block;clear:both;content:''}");
gnb_css_buffer.push(".gnb_search_lstwrp .gnb_search_lst{float:left;width:69px;border-left:1px solid #eaeaea}");
gnb_css_buffer.push(".gnb_search_lstwrp .gnb_search_lst.gnb_first{width:64px;border:0}");
gnb_css_buffer.push(".gnb_search_lstwrp li{padding:12px 0 0 8px}");
gnb_css_buffer.push(".gnb_search_lstwrp li.gnb_first{font-weight:bold;padding-top:0}");
gnb_css_buffer.push(".gnb_search_lstwrp li a{display:inline-block;vertical-align:top}");
gnb_css_buffer.push(".gnb_banner{height:47px;margin:0;padding:0 18px;background-position:-301px 0;background-repeat:repeat-y}");
gnb_css_buffer.push(".gnb_banner .gnb_service_event{display:inline-block;border-top:1px solid #ebebeb}");
gnb_css_buffer.push(".gnb_linkwrp{padding:0 4px 4px;background-position:-602px 0}");
gnb_css_buffer.push("a.gnb_service_all:hover, a.gnb_service_all:visited, a.gnb_service_all:active, a.gnb_service_all:focus{text-decoration:none}");
gnb_css_buffer.push(".gnb_svc_more{display:none;position:absolute;top:4px;right:303px;width:589px;overflow:hidden;zoom:1;z-index:1000}");
gnb_css_buffer.push(".gnb_svc_more:after{display:block;clear:both;content:''}");
gnb_css_buffer.push(".gnb_response .gnb_svc_more{right:2px}");
gnb_css_buffer.push(".gnb_bg_top{height:6px;background:url(https://ssl.pstatic.net/static/common/gnb/2014/bg_svclyr1_v2.png) no-repeat}");
gnb_css_buffer.push(".gnb_bg_btm{position:relative;height:6px;background:url(https://ssl.pstatic.net/static/common/gnb/2014/bg_svclyr1_v2.png) no-repeat -1282px 0}");
gnb_css_buffer.push(".gnb_svc_more .gnb_svc_hd{position:relative;padding:0 18px 2px 23px;letter-spacing:-1px;background:url(https://ssl.pstatic.net/static/common/gnb/2014/bg_svclyr1_v2.png) repeat-y -641px 0}");
gnb_css_buffer.push(".gnb_svc_more .gnb_svc_hd .gnb_svc_tit{display:block;padding:12px 0 13px;border-bottom:1px solid #ebebeb;font-size:14px;color:#222}");
gnb_css_buffer.push(".gnb_svc_more .gnb_svc_hd .link{position:absolute;top:14px;right:19px;font-size:12px;color:#444}");
gnb_css_buffer.push(".gnb_svc_more .gnb_svc_hd .link a{color:#444 !important;line-height:16px !important}");
gnb_css_buffer.push(".gnb_svc_more .gnb_svc_lstwrp{position:relative;height:283px;overflow:hidden;padding:15px 15px 0 20px;letter-spacing:-1px;background:url(https://ssl.pstatic.net/static/common/gnb/2014/bg_svclyr1_v2.png) repeat-y -641px 0;zoom:1}");
gnb_css_buffer.push(".gnb_svc_more .gnb_svc_lstwrp:after{display:block;clear:both;content:''}");
gnb_css_buffer.push(".gnb_svc_more .gnb_svc_lstwrp li{height:15px;margin-bottom:5px;color:#6b6d70;white-space:nowrap;line-height:15px}");
gnb_css_buffer.push(".gnb_svc_more .gnb_svc_lstwrp li.gnb_event label{color:#444;font-weight:bold}");
gnb_css_buffer.push(".gnb_svc_more .gnb_svc_lstwrp li.gnb_event em.ic_gnb_new{display:inline-block;width:11px;height:11px;background-position:-215px 0px;margin:2px 0 0 4px;font-size:0;line-height:0;vertical-align:top}");
gnb_css_buffer.push("@media screen and (min-width: 0\\0) { .gnb_svc_more .gnb_svc_lstwrp li.gnb_event em.ic{margin-top:3px} }");
gnb_css_buffer.push(".gnb_svc_more .gnb_svc_lstwrp .gnb_input_check{width:13px;height:13px;margin:2px 3px 0 3px;padding:0;vertical-align:top}");
gnb_css_buffer.push(".gnb_svc_more .gnb_svc_lstwrp label{vertical-align:0px}");
gnb_css_buffer.push(".gnb_svc_more .gnb_svc_lstwrp .gnb_disabled strong{color:#a8acb0}");
gnb_css_buffer.push(".gnb_svc_more .gnb_svc_lstwrp .gnb_disabled li{color:#cbcbcb}");
gnb_css_buffer.push(".gnb_svc_more .gnb_svc_lst1{float:left;width:328px;height:280px}");
gnb_css_buffer.push(".gnb_svc_more .gnb_svc_lst1 ul{float:left;width:102px;min-height:260px;padding:5px 0 0 10px;border-left:1px solid #eee}");
gnb_css_buffer.push(".gnb_svc_more .gnb_svc_lst1 ul.gnb_first{padding-left:0;border:0}");
gnb_css_buffer.push(".gnb_svc_more .svc_lst2{float:left;position:relative;width:221px;border:1px solid #eee;background:#fbfbfb;zoom:1}");
gnb_css_buffer.push(".gnb_svc_more .svc_lst2:after{display:block;clear:both;content:''}");
gnb_css_buffer.push(".gnb_svc_more .svc_spc{float:left;position:relative;width:100px;min-height:254px;padding:9px 0 0 10px}");
gnb_css_buffer.push(".gnb_svc_more .svc_spc.gnb_first{border-right:1px solid #eee}");
gnb_css_buffer.push(".gnb_svc_more .svc_spc strong{height:20px;color:#2f3743;line-height:16px}");
gnb_css_buffer.push(".gnb_svc_more .svc_spc a:visited{color:#2f3743}");
gnb_css_buffer.push(".gnb_svc_more .svc_spc ul{padding:8px 0}");
gnb_css_buffer.push(".gnb_svc_more .svc_spc li{margin-bottom:0;padding-bottom:5px;color:#848689}");
gnb_css_buffer.push(".gnb_svc_more .svc_stroy{width:89px;margin-top:-5px;padding:12px 0 0;border-top:1px solid #eee}");
gnb_css_buffer.push(".gnb_svc_more .svc_btns{position:relative;height:33px;overflow:hidden;padding-top:5px;line-height:normal}");
gnb_css_buffer.push(".gnb_svc_more .svc_btnwrp{position:relative;*height:39px;background:url(https://ssl.pstatic.net/static/common/gnb/2014/bg_svclyr1_v2.png) repeat-y -641px 0;padding:0 2px 0 4px}");
gnb_css_buffer.push(".gnb_svc_more .svc_btnwrp button{display:inline-block;width:60px;height:25px;border:0;vertical-align:top}");
gnb_css_buffer.push(".gnb_svc_more .svc_btnwrp .gnb_save{background-position:0 -160px}");
gnb_css_buffer.push(".gnb_svc_more .svc_btnwrp .gnb_close{margin-left:1px;background-position:-65px -160px}");
gnb_css_buffer.push(".gnb_svc_more .svc_btnwrp .gnb_return{position:absolute;top:5px;left:15px;background-position:-130px -160px}");
gnb_css_buffer.push(".gnb_type2 .gnb_notice_li a.gnb_notice .gnb_icon{background-position:-155px -120px}");
gnb_css_buffer.push(".gnb_type2 .gnb_notice_li a.gnb_notice:hover .gnb_icon{background-position:-155px -140px}");
gnb_css_buffer.push(".gnb_type2 .gnb_service_li .gnb_service .gnb_icon{background-position:-200px -120px}");
gnb_css_buffer.push(".gnb_type2 .gnb_service_li .gnb_service:hover .gnb_icon{background-position:-200px -140px}");
gnb_css_buffer.push(".gnb_type2 .mail_li a.gnb_mail .gnb_icon{background-position:-175px -120px}");
gnb_css_buffer.push(".gnb_type2 .mail_li a.gnb_mail:hover .gnb_icon{background-position:-175px -140px}");
gnb_css_buffer.push(".gnb_dark .gnb_my_li .gnb_my .gnb_name, .gnb_dark .gnb_login_li .gnb_btn_login .gnb_txt{color:#fff}");
gnb_css_buffer.push(".gnb_dark .gnb_notice_li a.gnb_notice .gnb_icon{background-position:-220px -140px}");
gnb_css_buffer.push(".gnb_dark .gnb_notice_li a.gnb_notice:hover .gnb_icon{background-position:-220px -120px}");
gnb_css_buffer.push(".gnb_dark .mail_li a.gnb_mail .gnb_icon{background-position:-238px -141px}");
gnb_css_buffer.push(".gnb_dark .mail_li a.gnb_mail:hover .gnb_icon{background-position:-238px -121px}");
gnb_css_buffer.push(".gnb_dark .gnb_service_li .gnb_service .gnb_icon{background-position:-261px -140px}");
gnb_css_buffer.push(".gnb_dark .gnb_service_li .gnb_service:hover .gnb_icon{background-position:-261px -120px}");
gnb_css_buffer.push(".gnb_dark_type2 .gnb_my_li .gnb_my .gnb_name, .gnb_dark_type2 .gnb_login_li .gnb_btn_login .gnb_txt{color:#fff}");
gnb_css_buffer.push(".gnb_dark_type2 .gnb_notice_li a.gnb_notice .gnb_icon{background-position:-220px -120px}");
gnb_css_buffer.push(".gnb_dark_type2 .gnb_notice_li a.gnb_notice:hover .gnb_icon{background-position:-220px -140px}");
gnb_css_buffer.push(".gnb_dark_type2 .mail_li a.gnb_mail .gnb_icon{background-position:-238px -121px}");
gnb_css_buffer.push(".gnb_dark_type2 .mail_li a.gnb_mail:hover .gnb_icon{background-position:-238px -141px}");
gnb_css_buffer.push(".gnb_dark_type2 .gnb_service_li .gnb_service .gnb_icon{background-position:-261px -120px}");
gnb_css_buffer.push(".gnb_dark_type2 .gnb_service_li .gnb_service:hover .gnb_icon{background-position:-261px -140px}");
gnb_css_buffer.push(".gnb_dark .gnb_notice_li a.gnb_notice, .gnb_dark_type2 .gnb_notice_li a.gnb_notice {width: 17px;height: 19px;padding: 6px 8px 3px;}");
gnb_css_buffer.push(".gnb_dark .gnb_notice_li a.gnb_notice .gnb_icon, .gnb_dark_type2 .gnb_notice_li a.gnb_notice .gnb_icon {width: 17px;height: 19px;}");
gnb_css_buffer.push(".gnb_dark .mail_li a.gnb_mail, .gnb_dark_type2 .mail_li a.gnb_mail {width: 22px;height: 16px;padding: 7px 8px 4px;}");
gnb_css_buffer.push(".gnb_dark .mail_li a.gnb_mail .gnb_icon, .gnb_dark_type2 .mail_li a.gnb_mail .gnb_icon {width: 22px;height: 16px;}");
gnb_css_buffer.push(".gnb_dark .gnb_service_li a.gnb_service, .gnb_dark_type2 .gnb_service_li a.gnb_service {width: 18px;height: 18px;padding: 6px 8px 4px;}");
gnb_css_buffer.push(".gnb_dark .gnb_service_li .gnb_service .gnb_icon, .gnb_dark_type2 .gnb_service_li .gnb_service .gnb_icon {width: 18px;height: 18px;}");

gnb_css_buffer.push("#gnb.gnb_one .gnb_my_li .gnb_my .gnb_name, #gnb.gnb_one_small .gnb_my_li .gnb_my .gnb_name, #gnb.gnb_one .gnb_login_li .gnb_btn_login .gnb_txt, #gnb.gnb_one_small .gnb_login_li .gnb_btn_login .gnb_txt{color:#fff}");

gnb_css_buffer.push("#gnb.gnb_one .gnb_login_li, #gnb.gnb_one_small .gnb_login_li {height: 28px;}");
gnb_css_buffer.push("#gnb.gnb_one .gnb_login_li .gnb_btn_login, #gnb.gnb_one_small .gnb_login_li .gnb_btn_login, #gnb.gnb_one .gnb_login_li .gnb_bg, #gnb.gnb_one_small .gnb_login_li .gnb_bg, #gnb.gnb_one .gnb_login_li .gnb_bdr, #gnb.gnb_one_small .gnb_login_li .gnb_bdr, #gnb.gnb_one .gnb_login_li .gnb_txt, #gnb.gnb_one_small .gnb_login_li .gnb_txt {width: 53px;height: 23px;}");
gnb_css_buffer.push("#gnb.gnb_one .gnb_login_li .gnb_btn_login .gnb_txt, #gnb.gnb_one_small .gnb_login_li .gnb_btn_login .gnb_txt {top: -1px;width: 53px;height: 23px;line-height: 28px;font-size: 11px;}");
gnb_css_buffer.push("#gnb.gnb_one .gnb_login_li, #gnb.gnb_one_small .gnb_login_li, #gnb.gnb_one .gnb_my_li, #gnb.gnb_one_small .gnb_my_li, #gnb.gnb_one .gnb_notice_li, #gnb.gnb_one_small .gnb_notice_li, #gnb.gnb_one .mail_li, #gnb.gnb_one_small .mail_li, #gnb.gnb_one .gnb_service_li, #gnb.gnb_one_small .gnb_service_li{margin-right: 0;margin-left: 0; background: url(https://ssl.pstatic.net/static/common/gnb/bg_one_line.png) repeat-y right 0;}");
gnb_css_buffer.push("#gnb.gnb_one .gnb_login_li a, #gnb.gnb_one_small .gnb_login_li a, #gnb.gnb_one .gnb_my_li a, #gnb.gnb_one_small .gnb_my_li a, #gnb.gnb_one .gnb_notice_li a, #gnb.gnb_one_small .gnb_notice_li a, #gnb.gnb_one .mail_li a, #gnb.gnb_one_small .mail_li a, #gnb.gnb_one .gnb_service_li a, #gnb.gnb_one_small .gnb_service_li a {margin-right: 1px;}");
gnb_css_buffer.push("#gnb.gnb_one .gnb_login_li.hover .gnb_service, #gnb.gnb_one_small .gnb_login_li.hover .gnb_service, #gnb.gnb_one .gnb_login_li.hover .gnb_notice, #gnb.gnb_one_small .gnb_login_li.hover .gnb_notice, #gnb.gnb_one .gnb_login_li.hover .gnb_mail, #gnb.gnb_one_small .gnb_login_li.hover .gnb_mail, #gnb.gnb_one .gnb_login_li.hover .gnb_service, #gnb.gnb_one_small .gnb_login_li.hover .gnb_service, #gnb.gnb_one .gnb_my_li.hover .gnb_service, #gnb.gnb_one_small .gnb_my_li.hover .gnb_service, #gnb.gnb_one .gnb_my_li.hover .gnb_notice, #gnb.gnb_one_small .gnb_my_li.hover .gnb_notice, #gnb.gnb_one .gnb_my_li.hover .gnb_mail, #gnb.gnb_one_small .gnb_my_li.hover .gnb_mail, #gnb.gnb_one .gnb_my_li.hover .gnb_service, #gnb.gnb_one_small .gnb_my_li.hover .gnb_service, #gnb.gnb_one .gnb_notice_li.hover .gnb_service, #gnb.gnb_one_small .gnb_notice_li.hover .gnb_service, #gnb.gnb_one .gnb_notice_li.hover .gnb_notice, #gnb.gnb_one_small .gnb_notice_li.hover .gnb_notice, #gnb.gnb_one .gnb_notice_li.hover .gnb_mail, #gnb.gnb_one_small .gnb_notice_li.hover .gnb_mail, #gnb.gnb_one .gnb_notice_li.hover .gnb_service, #gnb.gnb_one_small .gnb_notice_li.hover .gnb_service, #gnb.gnb_one .mail_li.hover .gnb_service, #gnb.gnb_one_small .mail_li.hover .gnb_service, #gnb.gnb_one .mail_li.hover .gnb_notice, #gnb.gnb_one_small .mail_li.hover .gnb_notice, #gnb.gnb_one .mail_li.hover .gnb_mail, #gnb.gnb_one_small .mail_li.hover .gnb_mail, #gnb.gnb_one .mail_li.hover .gnb_service, #gnb.gnb_one_small .mail_li.hover .gnb_service, #gnb.gnb_one .gnb_service_li.hover .gnb_service, #gnb.gnb_one_small .gnb_service_li.hover .gnb_service, #gnb.gnb_one .gnb_service_li.hover .gnb_notice, #gnb.gnb_one_small .gnb_service_li.hover .gnb_notice, #gnb.gnb_one .gnb_service_li.hover .gnb_mail, #gnb.gnb_one_small .gnb_service_li.hover .gnb_mail, #gnb.gnb_one .gnb_service_li.hover .gnb_service, #gnb.gnb_one_small .gnb_service_li.hover .gnb_service {background: url(https://ssl.pstatic.net/static/common/gnb/bg_one_hover.png) repeat 0 0;}");
gnb_css_buffer.push("#gnb.gnb_one .gnb_my_li .gnb_my .gnb_name, #gnb.gnb_one_small .gnb_my_li .gnb_my .gnb_name {margin: 0 0 0 4px;}");

gnb_css_buffer.push("#gnb.gnb_one .gnb_my_li .gnb_my .gnb_name, #gnb.gnb_one_small .gnb_my_li .gnb_my .gnb_name{margin:0 0 0 4px}"); 
gnb_css_buffer.push("#gnb.gnb_one .gnb_notice_li a.gnb_notice, #gnb.gnb_one_small .gnb_notice_li a.gnb_notice{width:17px;height:19px}"); 
gnb_css_buffer.push("#gnb.gnb_one .gnb_notice_li a.gnb_notice .gnb_icon, #gnb.gnb_one_small .gnb_notice_li a.gnb_notice .gnb_icon{width:17px;height:19px;background-position:-284px -119px}"); 
gnb_css_buffer.push("#gnb.gnb_one .gnb_notice_li a.gnb_notice:hover .gnb_icon, #gnb.gnb_one_small .gnb_notice_li a.gnb_notice:hover .gnb_icon{background-position:-284px -119px}"); 
gnb_css_buffer.push("#gnb.gnb_one .mail_li a.gnb_mail, #gnb.gnb_one_small .mail_li a.gnb_mail{width:21px;height:17px}"); 
gnb_css_buffer.push("#gnb.gnb_one .mail_li a.gnb_mail .gnb_icon, #gnb.gnb_one_small .mail_li a.gnb_mail .gnb_icon{width:21px;height:17px;background-position:-302px -120px}"); 
gnb_css_buffer.push("#gnb.gnb_one .mail_li a.gnb_mail:hover .gnb_icon, #gnb.gnb_one_small .mail_li a.gnb_mail:hover .gnb_icon{background-position:-302px -120px}"); 
gnb_css_buffer.push("#gnb.gnb_one .gnb_service_li .gnb_service, #gnb.gnb_one_small .gnb_service_li .gnb_service{width:17px;height:17px}");
gnb_css_buffer.push("#gnb.gnb_one .gnb_service_li .gnb_service .gnb_icon, #gnb.gnb_one_small .gnb_service_li .gnb_service .gnb_icon{width:17px;height:17px;background-position:-324px -120px}");
gnb_css_buffer.push("#gnb.gnb_one .gnb_service_li .gnb_service:hover .gnb_icon, #gnb.gnb_one_small .gnb_service_li .gnb_service:hover .gnb_icon{background-position:-324px -120px}");
gnb_css_buffer.push("#gnb.gnb_one .gnb_my_lyr, #gnb.gnb_one_small .gnb_my_lyr, #gnb.gnb_one .gnb_notice_lyr, #gnb.gnb_one_small .gnb_notice_lyr, #gnb.gnb_one .gnb_service_lyr, #gnb.gnb_one_small .gnb_service_lyr {right: 7px;}");
gnb_css_buffer.push("#gnb.gnb_one .gnb_ico_num, #gnb.gnb_one_small .gnb_ico_num{width:34px;top:10px;right:3px;left:auto;vertical-align:top}"); 
gnb_css_buffer.push("#gnb.gnb_one .gnb_ico_num .gnb_ico_new, #gnb.gnb_one_small .gnb_ico_num .gnb_ico_new{vertical-align:top;height:13px;background-position:-332px -60px;}");
gnb_css_buffer.push("#gnb.gnb_one .gnb_ico_num .gnb_count, #gnb.gnb_one_small .gnb_ico_num .gnb_count {height: 13px;padding: 0 6px 0 2px;background-position: 100% -60px;font-size: 10px;font-weight: normal;}");

gnb_css_buffer.push("#gnb.gnb_one .gnb_ico_num .plus, #gnb.gnb_one_small .gnb_ico_num .plus{margin:1px 0 0 2px}");
gnb_css_buffer.push("#gnb.gnb_one .ico_arrow{top:48px}");
gnb_css_buffer.push("#gnb.gnb_one .gnb_my_lyr, #gnb.gnb_one .gnb_notice_lyr{top:47px}");
gnb_css_buffer.push("#gnb.gnb_one .gnb_service_lyr{top:48px;}");

gnb_css_buffer.push("#gnb.gnb_one .gnb_login_li{padding:16px 21px 10px 1px}");
gnb_css_buffer.push("#gnb.gnb_one .gnb_my_li{padding:12px 20px 12px 2px}");
gnb_css_buffer.push("#gnb.gnb_one .gnb_my_li .ico_arrow{top:34px}");
gnb_css_buffer.push("#gnb.gnb_one .gnb_notice_li a.gnb_notice{padding:18px 19px 17px 19px}");
gnb_css_buffer.push("#gnb.gnb_one .mail_li a.gnb_mail{padding:19px 17px 18px 17px}");
gnb_css_buffer.push("#gnb.gnb_one .gnb_service_li .gnb_service{padding:19px 19px 18px 19px}");
gnb_css_buffer.push("#gnb.gnb_one_small .ico_arrow{top:33px}");
gnb_css_buffer.push("#gnb.gnb_one_small .gnb_my_lyr, #gnb.gnb_one_small .gnb_notice_lyr{top:32px}");
gnb_css_buffer.push("#gnb.gnb_one_small .gnb_service_lyr{top:33px}");

gnb_css_buffer.push("#gnb.gnb_one_small .gnb_login_li{padding:7px 12px 4px 2px}");
gnb_css_buffer.push("#gnb.gnb_one_small .gnb_my_li{padding:5px 20px 4px 2px}");
gnb_css_buffer.push("#gnb.gnb_one_small .gnb_my_li .ico_arrow{top:27px}");
gnb_css_buffer.push("#gnb.gnb_one_small .gnb_notice_li a.gnb_notice{padding:10px 11px 10px 12px}");
gnb_css_buffer.push("#gnb.gnb_one_small .mail_li a.gnb_mail{padding:11px 10px 11px 9px}");
gnb_css_buffer.push("#gnb.gnb_one_small .gnb_service_li .gnb_service{padding:11px 12px 11px 11px}");
gnb_css_buffer.push("#gnb.gnb_one_small .gnb_ico_num{top:5px;right:6px;width:24px}");

gnb_css_buffer.push("#gnb.gnb_one_flat .gnb_login_li,");
gnb_css_buffer.push("#gnb.gnb_one_flat .gnb_my_li,");
gnb_css_buffer.push("#gnb.gnb_one_flat .gnb_notice_li,");
gnb_css_buffer.push("#gnb.gnb_one_flat .mail_li,");
gnb_css_buffer.push("#gnb.gnb_one_flat .gnb_service_li {border-color: #e0e0e0;}");

gnb_css_buffer.push("#gnb.gnb_one_flat .gnb_notice_li.hover,");
gnb_css_buffer.push("#gnb.gnb_one_flat .mail_li.hover,");
gnb_css_buffer.push("#gnb.gnb_one_flat .gnb_service_li.hover {background-color: rgba(0, 0, 0, 0.04);}");

gnb_css_buffer.push("#gnb.gnb_one_flat .gnb_service_li .gnb_service .gnb_icon,");
gnb_css_buffer.push("#gnb.gnb_one_flat .gnb_service_li .gnb_service:hover .gnb_icon {background-image: url(https://ssl.pstatic.net/static/common/gnb/one/sp_gnb_4b16e6.png);background-position: -84px -24px;background-repeat: no-repeat; width: 16px;height: 16px;vertical-align: top; margin: 0 1px;}");
gnb_css_buffer.push("#gnb.gnb_one_flat .mail_li a.gnb_mail .gnb_icon,");
gnb_css_buffer.push("#gnb.gnb_one_flat .mail_li a.gnb_mail:hover .gnb_icon {background-image: url(https://ssl.pstatic.net/static/common/gnb/one/sp_gnb_4b16e6.png);background-position: 0px -42px;background-repeat: no-repeat;width: 20px;height: 16px;vertical-align: top;margin: 0 1px;}");
gnb_css_buffer.push("#gnb.gnb_one_flat .gnb_notice_li a.gnb_notice .gnb_icon,");
gnb_css_buffer.push("#gnb.gnb_one_flat .gnb_notice_li a.gnb_notice:hover .gnb_icon {background-image: url(https://ssl.pstatic.net/static/common/gnb/one/sp_gnb_4b16e6.png);background-position: -84px 0px;background-repeat: no-repeat;width: 16px;height: 18px;vertical-align: top;margin: 0 1px;}");
gnb_css_buffer.push("#gnb.gnb_one_flat .gnb_my_li .gnb_my .gnb_name,");
gnb_css_buffer.push("#gnb.gnb_one_flat .gnb_login_li .gnb_btn_login .gnb_txt {color: #777;}");

var gnb_style = gnb_css_buffer.join("\n");

gnb_html_buffer = [];
gnb_css_buffer = [];

function gnb$(id) {
	return document.getElementById(id);
}

function gnbGetElementsByClassName(element, name) {
	function find(node, callback) {
		callback(node);
		for (var i=0, len=node.childNodes.length; i<len; i++) {
			find(node.childNodes[i], callback);
		}
	}
	var result = [];
	find(element, function(node){
		if (node.className == name) {
			result.push(node);
		}
	});

	return result;
}

var gnbJsonStringify = function (obj) {
	var t = typeof (obj);
	if (t != "object" || obj === null) {
		if (t == "string") {
			obj = '"'+obj+'"';
		}
		return String(obj);
	} else {
		var n, v, json = [], arr = (obj && obj.constructor == Array);
		for (n in obj) {
			v = obj[n]; t = typeof(v);
			if (t == "string") {
				v = '"'+v+'"';
			} else if (t == "object" && v !== null) {
				 v = gnbJsonStringify(v);
			}
			if(String(v).indexOf("function")==-1){
				json.push((arr ? "" : '"' + n + '":') + String(v));
			}
		}
		return (arr ? "[" : "{") + String(json) + (arr ? "]" : "}");
	}
};

function insertGnbContents(gnb_html, gnb_style) {
	if (gnb$('gnb_style') == null || gnb$('gnb_style') == "undefined") {
		var gnb_style_element = document.createElement('style');
		gnb_style_element.setAttribute('id', 'gnb_style');
		gnb_style_element.setAttribute('type', 'text/css');
		if(gnb_style_element.styleSheet){
			gnb_style_element.styleSheet.cssText = gnb_style;
		} else {
			var textnode = document.createTextNode(gnb_style);
			gnb_style_element.appendChild(textnode);
		}
		document.getElementsByTagName('head')[0].appendChild(gnb_style_element);
	}
	
	try {
		gnb$('gnb').innerHTML = gnb_html;
	} catch (e) {
		var new_gnb = document.createElement('div');
		new_gnb.innerHTML = gnb_html;
		var current_gnb = gnb$('gnb');
		current_gnb.appendChild(new_gnb);
	}
}

insertGnbContents(gnb_html, gnb_style);
loadGnbComponents();

var gnbNaverMeLayer;
var gnbUserLayer;
var gnbMoreLayer;
var gnbFavorite;
var gnb_search;

var gnbJSONP = {
	read : function(elementId, apiUrl) {
		this.loading = true;
		this.padScript(elementId, apiUrl);
	},
	clean : function(elementId) {
		var head = document.getElementsByTagName('head')[0];
		var scriptElement = gnb$(elementId);
		if(scriptElement != null) {
			head.removeChild(scriptElement);
		}
	},
	padScript : function(elementId, apiUrl) {
		var scriptElement = document.createElement('script');
		scriptElement.setAttribute('src', apiUrl);
		scriptElement.setAttribute('id', elementId);
		scriptElement.setAttribute('charset', 'utf-8');
		
		var head = document.getElementsByTagName('head')[0];
		head.appendChild(scriptElement);
	}
};

function showMeCount(totalCount) {
	showNotiCount(totalCount, 'gnb_me_menu', 'gnb_me_count');
}

function showMailCount(countData) {
	if (countData.RESULT !== "SUCCESS") {
			return;
	}
	
	showNotiCount(countData.COUNT, 'gnb_mail_menu', 'gnb_mail_count');
	gnbJSONP.clean("gnb_mail_count_data");
}

function showNotiCount(totalCount, notiAreaId, notiBubbleId) {
	var count = totalCount;
	var countPlus = "";
	var notiArea = gnb$(notiAreaId);
	var notiBubble = gnb$(notiBubbleId);

	if (count > 99) {
		countPlus = "<span class=\"plus\">+</span>";
		count = 99;
	}

	try {
		notiBubble.style.display = "inline-block";

		if (count == 0) {
			notiArea.style.display = "none";
		} else {
			notiArea.style.display = "block";
		}

		if (count > 0) {
			notiBubble.innerHTML = count + countPlus;
		}
	} catch (ex) {
	}
}

function setLoginUrl(loginUrl, isLogin, loginButtonId) {
	var loginAndReturnUrl = "";
	var isGnbLoginDefined = (typeof gnb_options.gnb_login == "string") && (gnb_options.gnb_login != "");
	var isGnbLogoutDefined = (typeof gnb_options.gnb_logout == "string") && (gnb_options.gnb_logout != "");

	try {
		if (isLogin && isGnbLogoutDefined) {
			loginAndReturnUrl = loginUrl + "?returl=" + gnb_options.gnb_logout;
		} else if (!isLogin && isGnbLoginDefined) {
			loginAndReturnUrl = loginUrl + "?url=" + gnb_options.gnb_login;
		} else {
			loginAndReturnUrl = loginUrl;
		}
	} catch(e) {
		loginAndReturnUrl = loginUrl;
	}

	gnbMoreLayer._gnb_login = loginAndReturnUrl;
	gnb$(loginButtonId).href = gnbMoreLayer._gnb_login;
	if(gnb_options.gnb_login_on_top){
		var anchorList = gnb$('gnb').getElementsByTagName('a');
		for (var i = 0; i < anchorList.length; i++) {
			anchorList[i].target = "_top"
		};
	}
}

function showGNB(data) {
	setLoginUrl("https://nid.naver.com/nidlogin.logout", true, "gnb_logout_button");
	setLoginUrl("https://nid.naver.com/nidlogin.login", false, "gnb_login_button");

	var brightness = 1;
	if (typeof gnb_options.gnb_brightness != "undefined") {
		brightness = gnb_options.gnb_brightness;
	}

	var one_naver = 0;
	if (typeof gnb_options.gnb_one_naver != "undefined") {
		one_naver = gnb_options.gnb_one_naver;
	}

	var one_flat = 0;
	if (typeof gnb_options.gnb_one_flat != "undefined") {
		one_flat = gnb_options.gnb_one_flat;
	}

	if (one_naver == 0) {
		if (brightness == 0) {
			gnb$('gnb').className = "gnb_type2";
			gnb$('gnb_my_namebox').style.backgroundImage = "url(https://ssl.pstatic.net/static/common/gnb/2014/ico_arrow_bl1.gif)";
		}else if (brightness == 1) {
			gnb$('gnb').className = "";
			gnb$('gnb_my_namebox').style.backgroundImage = "url(https://ssl.pstatic.net/static/common/gnb/2014/ico_arrow_bl1.gif)";
		}else if (brightness == 2) {
			gnb$('gnb').className = "gnb_dark";
			gnb$('gnb_my_namebox').style.backgroundImage = "url(https://ssl.pstatic.net/static/common/gnb/2014/ico_arrow_wh.gif)";
		}else if (brightness == 3) {
			gnb$('gnb').className = "gnb_dark_type2";
			gnb$('gnb_my_namebox').style.backgroundImage = "url(https://ssl.pstatic.net/static/common/gnb/2014/ico_arrow_wh.gif)";
		}
	} else {
		if (one_naver == 1) {
			if (one_flat == 1) {
				gnb$('gnb').className = "gnb_one gnb_one_flat";
				gnb$('gnb_my_namebox').style.backgroundImage = "url(https://ssl.pstatic.net/static/common/gnb/2014/ico_arrow_bl1.gif)";
			} else {
				gnb$('gnb').className = "gnb_one";
				gnb$('gnb_my_namebox').style.backgroundImage = "url(https://ssl.pstatic.net/static/common/gnb/2014/ico_arrow_wh.gif)";
			}
			gnb$('gnb_notice_lyr_iframe').style.top = "55px";
			gnb$('gnb_service_lyr_iframe').style.top = "55px";
			gnb$('gnb_svc_more_iframe').style.top = "55px";
			gnb$('gnb_my_lyr_iframe').style.top = "55px";

			gnb$('gnb_notice_lyr_iframe').style.right = "10px";
			gnb$('gnb_service_lyr_iframe').style.right = "311px";
			gnb$('gnb_svc_more_iframe').style.right = "10px";
			gnb$('gnb_my_lyr_iframe').style.right = "10px";
		} else if (one_naver == 2) {
			if (one_flat == 1) {
				gnb$('gnb').className = "gnb_one_small gnb_one_flat";
				gnb$('gnb_my_namebox').style.backgroundImage = "url(https://ssl.pstatic.net/static/common/gnb/2014/ico_arrow_bl1.gif)";
			} else {
				gnb$('gnb').className = "gnb_one_small";
				gnb$('gnb_my_namebox').style.backgroundImage = "url(https://ssl.pstatic.net/static/common/gnb/2014/ico_arrow_wh.gif)";
			}
			gnb$('gnb_notice_lyr_iframe').style.top = "40px";
			gnb$('gnb_service_lyr_iframe').style.top = "40px";
			gnb$('gnb_svc_more_iframe').style.top = "40px";
			gnb$('gnb_my_lyr_iframe').style.top = "40px";

			gnb$('gnb_notice_lyr_iframe').style.right = "10px";
			gnb$('gnb_service_lyr_iframe').style.right = "311px";
			gnb$('gnb_svc_more_iframe').style.right = "10px";
			gnb$('gnb_my_lyr_iframe').style.right = "10px";
		}
	}

	var itemHideOption = 0
	if (typeof gnb_options.gnb_item_hide_option != "undefined") {
		itemHideOption = gnb_options.gnb_item_hide_option;
	};

	if (data.loginStatus == 'Y') {
		gnbJSONP.read('gnb_mail_count_data', "https://mail.naver.com/external/mailCount?callback=showMailCount&svc=gnb");
		showMeCount(data.meCount + data.talkCount);
		
		var isGroupId = ((typeof data.loginGroupId != "undefined") && (0 < data.loginGroupId.length));
		if(isGroupId){
			gnbNaverMeLayer.isGroupId = true;
		}
		gnb$('gnb_login_layer').style.display = "none";
		if((gnb_options.gnb_item_hide_option & 2) != 0) {
			gnb$('gnb_my_layer').style.display = "none";
		}else {
			gnb$('gnb_my_layer').style.display = "inline-block";;
		}
		if((gnb_options.gnb_item_hide_option & 4) != 0) {
			gnb$('gnb_notice_layer').style.display = "none";	
		}else {
			gnb$('gnb_notice_layer').style.display = "inline-block";;	
		}
		if((gnb_options.gnb_item_hide_option & 8) != 0) {
			gnb$('gnb_mail_layer').style.display = "none";	
		}else {
			gnb$('gnb_mail_layer').style.display = "inline-block";;	
		}
		if((gnb_options.gnb_item_hide_option & 16) != 0) {
			gnb$('gnb_profile_img').style.display = "none";	
			gnb$('gnb_profile_filter_mask').style.display = "none";
		}else {
			gnb$('gnb_profile_img').style.display = "inline-block";;	
			gnb$('gnb_profile_filter_mask').style.display = "inline-block";
		}
		if((gnb_options.gnb_item_hide_option & 32) != 0) {
			gnb$('gnb_emp').href = gnb_options.gnb_emp_url;
			gnb$('gnb_emp').style.display = "inline-block";	
		}else {
			gnb$('gnb_emp').style.display = "none";;	
		}
		if((gnb_options.gnb_item_hide_option & 64) != 0) {
			gnb$('gnb_service_layer').style.display = "none";	
		}else {
			gnb$('gnb_service_layer').style.display = "inline-block";;	
		}

		var isGroupId = (data.loginGroupId != "") ? true : false;
		var isNotNewGroupId = (data.loginGroupId != data.loginId);

		if (isGroupId && isNotNewGroupId) {
			gnb$('gnb_secure_lnk').style.display = "none";
			gnb$('gnb_pay_check').style.display = "none";
			gnbAddClassName(gnb$('gnb_my_lyr'), 'gnb_groupid');
			gnb$('gnb_my_lyr_iframe').style.height = "146px"
		}

		gnbUserLayer.callback(data);
		gnbUserLayer.callback2(data);
	} else {
		if((gnb_options.gnb_item_hide_option & 1) != 0) {
			gnb$('gnb_login_layer').style.display = "none";
		}else {
			gnb$('gnb_login_layer').style.display = "inline-block";;	
		}
		if((gnb_options.gnb_item_hide_option & 64) != 0) {
			gnb$('gnb_service_layer').style.display = "none";	
		}else {
			gnb$('gnb_service_layer').style.display = "inline-block";;	
		}
		gnb$('gnb_my_layer').style.display = "none";
		gnb$('gnb_notice_layer').style.display = "none";
		gnb$('gnb_mail_layer').style.display = "none";
		gnb$('gnb_lst').style.display="block";
	}
	if(data.date != "" && data.date.length == 4 ){
		gnb$('gnb_promo').src = "https://ssl.pstatic.net/static/common/gnb/banner/promo_npay_" + data.date + ".png";
	}

	gnbJSONP.clean("gnb_user_data");

	gnbNClicks.installNClicks();
	gnbNClicks.registerNClicksEvent('gnb');
}

function showGNBReload(data) {
	insertGnbContents(gnb_html, gnb_style);
	loadGnbComponents();

	showGNB(data);
}

function gnbAllLayerClose() {
	gnbUserLayer.show = false;
	gnbUserLayer.hideLayer();
	gnbNaverMeLayer.show = false;
	gnbNaverMeLayer.hideLayer();
	gnbMoreLayer.show = false;
	gnbFavorite.cancel();
	gnbMoreLayer.hideLayer();
}

function gnbAddClassName(element, clsName) {
	element.className = (element.className.indexOf(clsName) == -1 ? [element.className, clsName].join(' ') : element.className);
}

function gnbRemoveClassName(element, clsName) {
	if (element.className.indexOf(" " + clsName) != -1) {
		element.className = element.className.replace(" " + clsName, "");	
	};
}

function gnbShortNick(nickName, num){
	if (nickName.length > num) {
		return nickName.substr(0, num-1) + "..";
	}else {
		return nickName;
	}
}

function gnbResponseSetting(){
	if (gnb_options.gnb_response) {
		gnbMoreLayer.resp = true;
		return false;
	};
	if (window.innerWidth < 1000) {
		gnbMoreLayer.resp = true;
	}else{
		gnbMoreLayer.resp = false;
	}
}

var gnb_options = {
	gnb_service : "",
	gnb_template : "",
	gnb_login : "",
	gnb_logout : "",
	gnb_brightness : 1,
	gnb_one_naver : 0,
	gnb_one_flat : 0,
	gnb_item_hide_option : 0,
	gnb_login_on_top : false,
	gnb_emp_url : "",
	gnb_response : false
};

function initGNBOptions() {
	if (typeof(gnb_option) != "undefined") {
		try{ gnb_options=gnb_option;} catch(e) {}
	};

	try{ gnb_options.gnb_service=gnb_service;} catch(e) {}
 	try{ gnb_options.gnb_template=gnb_template;} catch(e) {}
 	try{ gnb_options.gnb_login=gnb_login;} catch(e) {}
 	try{ gnb_options.gnb_logout=gnb_logout;} catch(e) {}
 	try{ gnb_options.gnb_brightness=gnb_brightness;} catch(e) {}
 	try{ gnb_options.gnb_one_naver=gnb_one_naver;} catch(e) {}
 	try{ gnb_options.gnb_one_flat=gnb_one_flat;} catch(e) {}
 	try{ gnb_options.gnb_item_hide_option=gnb_item_hide_option;} catch(e) {}
 	try{ gnb_options.gnb_login_on_top=gnb_login_on_top;} catch(e) {gnb_options.gnb_login_on_top=false;}
 	try{ gnb_options.gnb_emp_url=gnb_emp_url;} catch(e) {}
 	try{ gnb_options.gnb_response=gnb_response;} catch(e) {}
}

function getGNB(isReload) {
	initGNBOptions();

	var gnb_url = "";

	if (isReload == true) {
		var gnb_url = "https://static.nid.naver.com/getLoginStatus.nhn?callback=showGNBReload&charset=utf-8&svc=" + gnb_options.gnb_service +
			"&template=" + gnb_options.gnb_template + "&one_naver=" + gnb_options.gnb_one_naver;
	} else {
		var gnb_url = "https://static.nid.naver.com/getLoginStatus.nhn?callback=showGNB&charset=utf-8&svc=" + gnb_options.gnb_service +
			"&template=" + gnb_options.gnb_template + "&one_naver=" + gnb_options.gnb_one_naver;
	}

	gnbJSONP.read('gnb_user_data', gnb_url);
}

var gnbHangul={search:function(a,b){"use strict";var c=gnbHangul.getCode(a),d=gnbHangul.getCode(b);return c.indexOf(d)},getCode:function(a){"use strict";var b,d,e,f,g,c="";for(b=0;b<a.length;b+=1)d=a.charCodeAt(b),d>=44032&&55203>=d?(d-=44032,g=parseInt(d%28,10),f=parseInt((d-g)/28%21,10),e=parseInt((d-g)/28/21,10),c+=gnbHangul.match[e+4352]+",",c+=gnbHangul.match[f+4449]+",",0!==g&&(c+=gnbHangul.match[g+4520-1]+",")):c+=gnbHangul.match[d]+",";return","===c.charAt(c.length-1)&&(c=c.substring(0,c.length-1)),c},match:{4352:[12593],4353:[12594],4354:[12596],4355:[12599],4356:[12600],4357:[12601],4358:[12609],4359:[12610],4360:[12611],4361:[12613],4362:[12614],4363:[12615],4364:[12616],4365:[12617],4366:[12618],4367:[12619],4368:[12620],4369:[12621],4370:[12622],4449:[12623],4450:[12624],4451:[12625],4452:[12626],4453:[12627],4454:[12628],4455:[12629],4456:[12630],4457:[12631],4458:[12631,12623],4459:[12631,12624],4460:[12631,12643],4461:[12635],4462:[12636],4463:[12636,12627],4464:[12636,12628],4465:[12636,12643],4466:[12640],4467:[12641],4468:[12641,12643],4469:[12643],4520:[12593],4521:[12594],4522:[12593,12613],4523:[12596],4524:[12596,12616],4525:[12596,12622],4526:[12599],4527:[12601],4528:[12601,12593],4529:[12601,12609],4530:[12601,12610],4531:[12601,12613],4532:[12601,12620],4533:[12601,12621],4534:[12601,12622],4535:[12609],4536:[12610],4537:[12610,12613],4538:[12613],4539:[12613],4540:[12615],4541:[12616],4542:[12618],4543:[12619],4544:[12620],4545:[12621],4546:[12622],114:[12593],82:[12593],115:[12596],101:[12599],69:[12599],102:[12601],97:[12609],113:[12610],81:[12610],116:[12613],84:[12613],100:[12615],119:[12616],87:[12617],99:[12618],122:[12619],120:[12620],118:[12621],103:[12622],107:[12623],111:[12624],105:[12625],79:[12624],106:[12627],112:[12628],117:[12629],80:[12628],104:[12631],121:[12635],110:[12636],98:[12640],109:[12641],108:[12643],78:[12636],86:[12621],73:[12625],77:[12641],85:[12629],76:[12643],83:[12596],12593:[12593],12594:[12594],12595:[12595],12596:[12596],12597:[12597],12598:[12598],12599:[12599],12600:[12600],12601:[12601],12602:[12602],12603:[12603],12604:[12604],12605:[12605],12606:[12606],12607:[12607],12608:[12608],12609:[12609],12610:[12610],12611:[12611],12612:[12612],12613:[12613],12614:[12614],12615:[12615],12616:[12616],12617:[12617],12618:[12618],12619:[12619],12620:[12620],12621:[12621],12622:[12622],12623:[12623],12624:[12624],12625:[12625],12626:[12626],12627:[12627],12628:[12628],12629:[12629],12630:[12630],12631:[12631],12632:[12632],12633:[12633],12634:[12634],12635:[12635],12636:[12636],12637:[12637],12638:[12638],12639:[12639],12640:[12640],12641:[12641],12642:[12642],12643:[12643]}};

var gnbNClicks = {
	idNClicksNamePair : [
		[ "gnb_login_button", "gnb.login" ],
		[ "gnb_logout_button", "prl.logout" ],
		[ "gnb_pay_point", "prl.mynpay" ],
		[ "gnb_service_all", "mor.sitemap" ]
	],
	classNClicksNamePair : [
		[ "gnb_service_event", "mor.banner" ],
		[ "gnb_change", "prl.imgmodify" ],
		[ "gnb_nick", "prl.nick" ],
		[ "gnb_mail_address", "prl.mail" ],
		[ "gnb_mail", "gnb.mail" ],
		[ "gnb_blog", "prl.myblog" ],
		[ "gnb_cafe", "prl.mycafe" ],
		[ "gnb_pay", "prl.npay" ],
		[ "gnb_notice_all", "alr.meall" ],
		[ "gnb_notice", "gnb.alert" ],
		[ "gnb_my_interface", "mor.set" ],
		[ "gnb_my", "gnb.profile" ],
		[ "gnb_service_all", "mor.sitemap" ],
		[ "gnb_service", "gnb.more" ],
		[ "gnb_Mlist", "alr.Mlist" ],
		[ "gnb_Mdel", "alr.Mdel" ],
		[ "gnb_mlist", "alr.mlist" ],
		[ "gnb_mdel", "alr.mdel" ],
		[ "gnb_blist", "alr.blist" ],
		[ "gnb_bdel", "alr.bdel" ],
		[ "gnb_clist", "alr.clist" ],
		[ "gnb_cdel", "alr.cdel" ],
		[ "gnb_klist", "alr.klist" ],
		[ "gnb_kdel", "alr.kdel" ],
		[ "gnb_hlist", "alr.hlist" ],
		[ "gnb_hdel", "alr.hdel" ],
		[ "gnb_Clist", "alr.Clist" ],
		[ "gnb_Cdel", "alr.Cdel" ],
		[ "gnb_Dlist", "alr.Dlist" ],
		[ "gnb_Ddel", "alr.Ddel" ],
		[ "gnb_Klist", "alr.Klist" ],
		[ "gnb_Kdel", "alr.Kdel" ],
		[ "gnb_Blist", "alr.Blist" ],
		[ "gnb_Bdel", "alr.Bdel" ],
		[ "gnb_Llist", "alr.Llist" ],
		[ "gnb_Ldel", "alr.Ldel" ],
		[ "gnb_Plist", "alr.Plist" ],
		[ "gnb_Pdel", "alr.Pdel" ],	
		[ "gnb_Tlist", "alr.Tlist" ],
		[ "gnb_Tdel", "alr.Tdel" ],
		[ "gnb_ilist", "alr.ilist" ],
		[ "gnb_idel", "alr.idel" ],
		[ "gnb_Olist", "alr.Olist" ],
		[ "gnb_Odel", "alr.Odel" ],
		[ "gnb_Flist", "alr.Flist" ],
		[ "gnb_Fdel", "alr.Fdel" ],
		[ "gnb_fav0", "mor.fav1" ],
		[ "gnb_fav1", "mor.fav2" ],
		[ "gnb_fav2", "mor.fav3" ],
		[ "gnb_fav3", "mor.fav4" ]
	],
	anchorTextNClicksNamePair : [
		[ "프로필 수정", "prl.prfmodify" ],
		[ "내정보", "prl.info" ],
		[ "보안설정", "prl.securityset" ],
		[ "내 알림 전체보기", "alr.meall" ],
		[ "카페", "mor.cafe" ],
		[ "뉴스", "mor.news" ],
		[ "사전", "mor.dic" ],
		[ "지식iN", "mor.kin" ],
		[ "날씨", "mor.weather" ],
		[ "블로그", "mor.blog" ],
		[ "증권", "mor.finance" ],
		[ "부동산", "mor.land" ],
		[ "뮤직", "mor.music" ],
		[ "책", "mor.book" ],
		[ "메일", "mor.mail" ],
		[ "웹툰", "mor.comic" ],
		[ "영화", "mor.movie" ],
		[ "클라우드", "mor.ndrive" ],
		[ "자동차", "mor.auto" ],
		[ "쇼핑", "mor.shopping" ],
		[ "지도", "mor.map" ],
		[ "스포츠", "mor.sports" ],
		[ "게임", "mor.game" ],
		[ "포스트", "mor.post" ]
	],
	installNClicks : function() {
		if (typeof ncd != 'undefined') {
			return;
		}
		
		gnbJSONP.padScript("gnb_clickcrD", "https://ssl.pstatic.net/static.gn/js/clickcrD.js");
	},
	registerNClicksEvent : function(rootElementId) {
		var anchorTags = document.getElementById(rootElementId).getElementsByTagName('A');
	
		for(var i = 0, len = anchorTags.length; i < len; i++) {
			if(anchorTags[i].attachEvent) {
				anchorTags[i].attachEvent("onclick",	gnbNClicks.nClicksEventHandler);
			} else if(anchorTags[i].addEventListener) {
				anchorTags[i].addEventListener("click",	gnbNClicks.nClicksEventHandler, false);
			}
		}
	},
	registerButtonNClicksEvent : function(rootElementId) {
		var buttonTags = document.getElementById(rootElementId).getElementsByTagName('button');
	
		for(var i = 0, len = buttonTags.length; i < len; i++) {
			buttonTags[i].href = "";
			if(buttonTags[i].attachEvent) {
				buttonTags[i].attachEvent("onclick",	gnbNClicks.nClicksEventHandler);
			} else if(buttonTags[i].addEventListener) {
				buttonTags[i].addEventListener("click",	gnbNClicks.nClicksEventHandler, false);
			}
		}
	},
	registerSearchNClicksEvent : function(rootElementId) {
		var anchorTags = document.getElementById(rootElementId).getElementsByTagName('A');
	
		for(var i = 0, len = anchorTags.length; i < len; i++) {
			if(anchorTags[i].attachEvent) {
				anchorTags[i].attachEvent("onclick",	gnbNClicks.nClicksSearchEventHandler);
			} else if(anchorTags[i].addEventListener) {
				anchorTags[i].addEventListener("click",	gnbNClicks.nClicksSearchEventHandler, false);
			}
		}
	},
	nClicksEventHandler : function(e){
		try {
			var anchorText = null;
			var isMSIE = window.navigator.userAgent.indexOf("MSIE ") != -1;
			var eventSrcElement = null;
		
			if(isMSIE) {
				eventSrcElement = e.srcElement;
				anchorText = eventSrcElement.innerHTML;
			} else {
				eventSrcElement = this;
				anchorText = this.firstChild.wholeText;
			}
	
			var eventSrcAnchorElement = gnbNClicks.getClickedAnchorElement(eventSrcElement);
			var nvl = function(arg) { return arg == null ? "" : arg; };
			
			var elementId = nvl(eventSrcAnchorElement.getAttribute("id"));
			var elementClass = nvl(eventSrcAnchorElement.className);
			var nClicksCode = gnbNClicks.getNClicksCode(anchorText, elementId, elementClass);
			if(nClicksCode != null) {	
				ncd.clickcrD('gnb.v2', eventSrcAnchorElement, nClicksCode, '', 1, e);
			}
		} catch(ex) {
		}
	},
	nClicksSearchEventHandler : function(e){
		try {
			var anchorText = null;
			var isMSIE = window.navigator.userAgent.indexOf("MSIE ") != -1;
			var eventSrcElement = null;
		
			if(isMSIE) {
				eventSrcElement = e.srcElement;
				anchorText = eventSrcElement.innerHTML;
			} else {
				eventSrcElement = this;
				anchorText = this.firstChild.wholeText;
			}
	
			var eventSrcAnchorElement = gnbNClicks.getClickedAnchorElement(eventSrcElement);
			var nvl = function(arg) { return arg == null ? "" : arg; };
			
			var elementId = nvl(eventSrcAnchorElement.getAttribute("id"));
			var elementClass = nvl(eventSrcAnchorElement.className);
			var clickCd = nvl(eventSrcAnchorElement.className.substr(6));
			var nClicksCode = "mor.search";
			if(nClicksCode != null) {	
				ncd.clickcrD('gnb.v2', eventSrcAnchorElement, nClicksCode, clickCd, 1, e);
			}
		} catch(ex) {
		}
	},
	getClickedAnchorElement : function(eventElement) {
		if(eventElement.tagName == "A") {
			return eventElement;
		}
		
		var limitDepth = 3;
		var currentElement = eventElement
		for(var i = 0; i < limitDepth; i++) {
			if(currentElement.parentElement.tagName == "A") {
				return currentElement.parentElement;
			}
			currentElement = currentElement.parentElement;
		}

		return eventElement;
	},
	getNClicksCode : function(anchorText, elementId, elementClass) {
		var nClicksCode = null;
		
		nClicksCode = gnbNClicks.findValue(gnbNClicks.classNClicksNamePair, elementClass);
		if(nClicksCode != null) {
			return nClicksCode;
		}	
	
		var nClicksCode = gnbNClicks.findValue(gnbNClicks.idNClicksNamePair, elementId);
		if(nClicksCode != null) {
			return nClicksCode;
		}
	
		return gnbNClicks.findValue(gnbNClicks.anchorTextNClicksNamePair, anchorText);
	},
	findValue : function(dataMap, dataKey) {
		var KEY_INDEX = 0;
		var VALUE_INDEX = 1;

		for(var i = 0, len = dataMap.length; i < len; i++) {
			if(dataKey.indexOf(dataMap[i][KEY_INDEX])!=-1) {
				return dataMap[i][VALUE_INDEX];
			}
		}

		return null;
	}
};

function gnb_svc(name, iconurl, url, index){
	this.name = name;
	this.iconurl = iconurl;
	this.url = url;
	this.index = index;
}
gnb_svc.prototype.toString = function(){
	return this.name;
}

function reloadGnbVariables() {
    if (typeof(gnb_option) != "undefined") {
        try{ gnb_options=gnb_option;} catch(e) {}
    };

    try{ gnb_options.gnb_login=gnb_login;} catch(e) {}
    try{ gnb_options.gnb_logout=gnb_logout;} catch(e) {}

    setLoginUrl("https://nid.naver.com/nidlogin.logout", true, "gnb_logout_button");
    setLoginUrl("https://nid.naver.com/nidlogin.login", false, "gnb_login_button");
}

function loadGnbComponents() {
	gnbNaverMeLayer = {
		show : false,
		isGroupId : false,
		isLoading : false,
		callbackFlag: false,
		meNotiListScriptId : "gnb_naverme_data",
		meReadNotiScriptId : "gnb_naverme_read_noti",
		meLayerElement : gnb$('gnb_notice_lyr'),
		meLayerIframeElement : gnb$('gnb_notice_lyr_iframe'),
		meAppenderElement : gnbGetElementsByClassName(gnb$('gnb'), 'svc_scroll')[0],
		meFavoriteElement : gnb$('gnb_naverme_layer'),
		clickToggle : function () {
			if(!this.show) {
				gnbAllLayerClose();
				this.requestNoti();
				this.showProgressLayer();
				showMeCount(0);
			} else {
				this.hideLayer();
			}
		},
		showLayer : function() {
			this.show = true;
			//this.meLayerElement.style.display = "block";
			gnbAddClassName(this.meLayerElement.parentElement, "gnb_lyr_opened");
			this.meLayerIframeElement.style.display = "block";
		},
		callback : function(naverMeData) {
			this.hideDeleteAlert();
			try{
				this.validateApiResult(naverMeData);
				naverMeData.noti = naverMeData.noti
					.replace(/http:\/\/gnb.me.naver.com\/gnb\/noti\/delete\/utf-8.nhn/gi, "https://static.nid.naver.com/gnbMeNoti/gnb/noti/delete/utf-8.nhn")
					.replace(/http:\/\/gnb.me.naver.com\/gnb\/noti\/read\/utf-8.nhn/gi, "https://static.nid.naver.com/gnbMeNoti/gnb/noti/read/utf-8.nhn");

				if (naverMeData.readCount == 0) {
					gnb$('gnb_btn_read_noti_del').disabled = true;
				}else {
					gnb$('gnb_btn_read_noti_del').disabled = false;
				}
				if (naverMeData.listCount == 0) {
					gnb$('gnb_btn_all_noti_del').disabled = true;
				}else {
					gnb$('gnb_btn_all_noti_del').disabled = false;
				}
				this.appendMeLayer(naverMeData);
			} catch (e) {
				this.showErrorLayer();
			}
			this.cleanNotiJSONP();
			if (typeof(ncd)!="undefined") {
				gnbNClicks.registerNClicksEvent('gnb_naverme_layer');
				gnbNClicks.registerButtonNClicksEvent('gnb_naverme_layer');
			};
		},
		hideLayer : function() {
			this.show = false;
			//this.meLayerElement.style.display = "none";
			gnbRemoveClassName(this.meLayerElement.parentElement, "gnb_lyr_opened");
			this.meLayerIframeElement.style.display = "none";
			//this.closeCallback();
		},
		showDeleteAlert : function() {
			gnb$('gnb_ly_alert').style.display = "block";
		},
		hideDeleteAlert : function() {
			gnb$('gnb_ly_alert').style.display = "none";
		},
		requestNoti : function() {
			gnbJSONP.read(this.meNotiListScriptId, "https://static.nid.naver.com/gnbMeNoti/gnb/noti/utf-8.nhn?callback=gnbNaverMeLayer.callback");
		},
		getNotiListToJson : function(drawList){
			var result = [];
			for (var i = 0; i < drawList.length; i++) {
				var message = {};
				message.messageTimeKey = drawList[i].getAttribute("data-messagetimekey");
				message.serviceId = drawList[i].getAttribute("data-serviceid");
				message.catId = drawList[i].getAttribute("data-catid");
				result.push(message);
			};
			if(result.length == 0){
				return "[]";
			}
			return gnbJsonStringify(result);
		},
		deleteReadList : function(element, event) {
			if(typeof(ncd)!="undefined"){
				element.href = "";
				ncd.clickcrD('gnb.v2', element, 'alr.delread', '', 1, event);
			}
			var elementList = gnbGetElementsByClassName(gnb$("gnb_naverme_layer"), '_read_noti');
			gnbJSONP.read(this.meNotiListScriptId, "https://static.nid.naver.com/gnbMeNoti/gnb/noti/delete/multi/utf-8.nhn?callback=gnbNaverMeLayer.callback&notiInfoList=" + encodeURIComponent(this.getNotiListToJson(elementList)));
		},
		deleteAllList : function(element, event) {
			if(typeof(ncd)!="undefined"){
				element.href = "";
				ncd.clickcrD('gnb.v2', element, 'alr.delall', '', 1, event);
			}
			gnbJSONP.read(this.meNotiListScriptId, "https://static.nid.naver.com/gnbMeNoti/gnb/noti/delete/all/utf-8.nhn?callback=gnbNaverMeLayer.callback");
			this.hideDeleteAlert();
		},
		drawList : function(element, apiUrl) {
			gnbJSONP.read(this.meNotiListScriptId, apiUrl + "&callback=gnbNaverMeLayer.callback");
		},
		appendMeLayer : function(naverMeData) {
			this.appendNaverMeLayerInnerHtml(naverMeData);
		},
		showProgressLayer : function() {
			var progressDivHTML = "<div class=\"svc_blank\"><div class=\"svc_msg_box\"><span class=\"gnb_tit\"><img width=\"17\" height=\"17\" alt=\"\" title=\"로딩중\" src=\"https://ssl.pstatic.net/static/common/gnb/loading_green.gif\"></span><p class=\"gnb_desc\">목록을 가져오는 중입니다</p><div class=\"gnb_link_wrap\"><a class=\"gnb_link\" href=\"#\" onclick=\"gnbNaverMeLayer.hideLayer(); return false;\">닫기</a></div></div><span class=\"gnb_v_guide\"></span></div>";
			this.meFavoriteElement.innerHTML = progressDivHTML;
			//this.registerCloseButtonEvent();
			this.showLayer();
		},
		cleanNotiJSONP : function() {
			gnbJSONP.clean(this.meNotiListScriptId);
		},
		appendNaverMeLayerInnerHtml : function(naverMeData) {
			this.meFavoriteElement.innerHTML = naverMeData.noti;
		},
		appendEmptyNaverMeLayerInnerHtml : function() {
			this.meFavoriteElement.innerHTML = "<div class=\"svc_blank\"><div class=\"svc_msg_box\"><h4 class=\"gnb_tit\">새로운 알림 없습니다.</h4><p class=\"gnb_desc\">네이버me에서<br>나의 활동 소식, 친구들의 새 소식을<br>한번에 받아 보세요.</p><a class=\"gnb_link\">알림 설정하기</a></div><span class=\"gnb_v_guide\"></span></div>";
		},
		appendGroupIdNotSupportHtml : function() {
			this.meFavoriteElement.innerHTML = "<div class=\"svc_blank\"><div class=\"svc_msg_box\"><p class=\"gnb_desc\">죄송합니다.<br>네이버me 서비스는 <em>단체아이디</em>를<br>지원하지 않습니다.</p><p>개인아이디로 다시 로그인해주세요.</p></p><a class=\"gnb_link\" onclick=\"gnbNaverMeLayer.hideLayer(); return false;\">닫기</a></div><span class=\"gnb_v_guide\"></span></div>";
		},
		showLogoutNotiLayer : function() {
			this.showNotiLayer("<div class=\"me_cclist_groupid\"><div class=\"me_groupid\"><p class=\"group_message\"><em>로그아웃</em> 되었습니다.</p><p>로그인 후 다시 이용해 주세요.</p></div><div class=\"me_layer_cclist_page\"><a class=\"me_layer_btn_close\" id=\"gnb_me_layer_btn_close\">닫기</a></div></div>");
		},
		showErrorLayer : function() {
			this.showNotiLayer("<div class=\"gnb_error\"><div class=\"gnb_ico_error\"></div><h4 class=\"gnb_tit\">알림을 확인할 수 없습니다.</h4><p class=\"gnb_desc\">현재 알림 접속이 원할하지 않습니다.<br> 잠시 후 다시 시도해 주세요.</p><div class=\"gnb_link_wrap\"><a class=\"gnb_link\" href=\"#\" onclick=\"gnbNaverMeLayer.hideLayer(); return false;\">닫기</a></div><span class=\"gnb_v_guide\"></span></div>");
		},
		showNotiLayer : function(html) {
			this.meFavoriteElement.innerHTML = html;
			this.showLayer();
		},
		validateApiResult : function(naverMeData) {
			var check0 = naverMeData.hasMore;
			var check1 = naverMeData.listCount;
			var check2 = naverMeData.meCount;
			if("success" ==  naverMeData.result || "logout" == naverMeData.result) {
				return;
			} else {
				throw "api fail.";
			}
		}
	};

	gnbUserLayer = {
		show : false,
		nidInfoScriptId : "gnb_nid_data",
		nidInfoScriptId2 : "gnb_prof_data",
		payPointScriptId : "gnb_pay_point_data",
		nidInfoJson : null,
		myLayerElement : gnb$('gnb_my_lyr'),
		myLayerIframeElement : gnb$('gnb_my_lyr_iframe'),
		gnbNick : "",
		longId1 : false,
		longId2 : false,
		clickToggle : function () {
			if(!this.show) {
				gnbAllLayerClose();
				this.showLayer();
			} else {
				this.hideLayer();
			}
		},
		showLayer : function() {
			this.getPayPoint();
			this.show = true;
			//this.myLayerElement.style.display = "block";
			gnbAddClassName(this.myLayerElement.parentElement, "gnb_lyr_opened");
			this.myLayerIframeElement.style.display = "block";
		},
		hideLayer : function() {
			this.show = false;
			//this.myLayerElement.style.display = "none";
			gnbRemoveClassName(this.myLayerElement.parentElement, "gnb_lyr_opened");
			this.myLayerIframeElement.style.display = "none";
		},
		getPayPoint : function() {
			gnbJSONP.read(this.payPointScriptId, "https://static.nid.naver.com/getPayPoint.nhn?callback=gnbUserLayer.payCallback");
		},
		cleanInfoJSONP : function(elementId) {
			gnbJSONP.clean(elementId);
		},
		callback : function(nidData) {
			this.nidInfoJson = nidData;
			try{
				if (nidData.loginId.length > 15) {
					this.longId2 = true;
					gnbAddClassName(gnb$('gnb_my_lyr'), 'gnb_longid2');
					this.myLayerIframeElement.style.width = "350px";
				}else if(nidData.loginId.length > 11){
					this.longId1 = true;
					gnbAddClassName(gnb$('gnb_my_lyr'), 'gnb_longid1');
					this.myLayerIframeElement.style.width = "320px";
				};
				gnbGetElementsByClassName(gnb$('gnb'), 'gnb_mail_address')[0].innerHTML = nidData.loginId + "@naver.com";
			} catch (e) {
			}
		},
		callback2 : function(data) {
			try{
				if (data.imageUrl != null && data.imageUrl != "N") {
					gnbGetElementsByClassName(gnb$('gnb'), "gnb_img_area")[0].children[1].src = data.imageUrl;
					gnbGetElementsByClassName(gnb$('gnb'), "gnb_my")[0].children[0].src = data.imageUrl.replace("s160", "s80");
				}else{
					//내정보에서 사용하는 디폴트 이미지
					gnbGetElementsByClassName(gnb$('gnb'), "gnb_img_area")[0].children[1].src = "https://ssl.pstatic.net/static/common/myarea/myInfo.gif";
					gnbGetElementsByClassName(gnb$('gnb'), "gnb_my")[0].children[0].src = "https://ssl.pstatic.net/static/common/myarea/myInfo.gif";
				}
			} catch (e) {
				//this.showErrorLayer();
			}
			try{
				if (data.nickName != "") {
					this.gnbNick = data.nickName;
				};
				gnb$('gnb_name1').innerHTML = gnbShortNick(this.gnbNick, 6);
				if (this.longId1) {
					gnb$('gnb_name2').children[0].innerHTML = gnbShortNick(this.gnbNick, 8);
				}else if(this.longId2){
					gnb$('gnb_name2').children[0].innerHTML = gnbShortNick(this.gnbNick, 10);
				}else{
					gnb$('gnb_name2').children[0].innerHTML = gnbShortNick(this.gnbNick, 6);
				}
			}catch (e){}
			this.cleanInfoJSONP(this.nidInfoScriptId2);
			gnb$('gnb_lst').style.display = "block";
		},
		numberWithCommas : function(x) {
			return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
		},
		payCallback : function(data) {
			try{
				if (data.agree == 'true') {
					gnb$('gnb_pay_point').innerHTML = "<span>내 페이포인트</span><strong>" + this.numberWithCommas(data.payPoint) + "원</strong>";
				}else{
					gnb$('gnb_pay_point').innerHTML = "<span>내 페이포인트 확인</span>";
				}
			} catch (e) {

			}
			this.cleanInfoJSONP(this.payPointScriptId);
		}
	};

	gnbMoreLayer = {
		resp : false,
		show : false,
		wholeShow : false,
		moreLayerElement : gnb$('gnb_service_lyr'),
		moreLayerIframeElement : gnb$('gnb_svc_more_iframe'),
		wholeLayerElement : gnb$('gnb_svc_more'),
		wholeLayerIframeElement : gnb$('gnb_service_lyr_iframe'),
		clickToggle : function () {
			if(!this.show) {
				gnbAllLayerClose();
				if (!gnbFavorite.initialized) {
					gnbFavorite.getCookie();
				}
				this.showLayerAfterProfileInit();
			} else {
				this.hideLayer();
			}
		},
		clickToggleWhole : function () {
			if(!this.wholeShow) {
				this.showMoreLayer();
			} else {
				this.hideMoreLayer();
			}
		},
		showLayerAfterProfileInit : function() {
			if (gnbFavorite.initialized) {
				gnbMoreLayer.showLayer();
			} else {
				setTimeout(gnbMoreLayer.showLayerAfterProfileInit, 200);
			}
		},
		showLayer : function() {
			gnbResponseSetting();
			this.show = true;
			//this.moreLayerElement.style.display = "block";
			gnbAddClassName(this.moreLayerElement.parentElement, "gnb_lyr_opened");
			this.moreLayerIframeElement.style.display = "block";
			setTimeout(function(){gnb$('gnb_favorite_search').style.zoom = "1";}, 50);
			gnb$('gnb_svc_search_input').focus();
		},
		hideLayer : function() {
			this.show = false;
			if (gnb$('gnb_favorite_search')) {
				gnb$('gnb_favorite_search').style.zoom = "";
			}
			//this.moreLayerElement.style.display = "none";
			this.hideMoreLayer();
			gnbRemoveClassName(this.moreLayerElement.parentElement, "gnb_lyr_opened");
			this.moreLayerIframeElement.style.display = "none";
		},
		showMoreLayer : function() {
			if(this.resp){
				gnbAddClassName(gnb$("gnb_lst"), "gnb_response");

				if (gnb_options.gnb_one_naver == 1) {
					gnb$('gnb_service_lyr_iframe').style.right = "10px";
				} else {
					gnb$('gnb_service_lyr_iframe').style.right = "-4px";
				}
			}
			this.wholeShow = true;
			this.wholeLayerElement.style.display = "block";
			this.wholeLayerIframeElement.style.display = "block";
		},
		hideMoreLayer : function() {
			if(this.resp){
				gnbRemoveClassName(gnb$("gnb_lst"), "gnb_response");

				if (gnb_options.gnb_one_naver == 1) {
					gnb$('gnb_service_lyr_iframe').style.right = "311px";
				} else {
					gnb$('gnb_service_lyr_iframe').style.right = "297px";
				}
			}
			this.wholeShow = false;
			this.wholeLayerElement.style.display = "none";
			this.wholeLayerIframeElement.style.display = "none";
		}
	};

	gnbFavorite = {
		gnbCookieScriptId : "gnbCookie",
		selectedSvcArr : [],
		initialized : false,
		init : function(data){
			if (typeof(data) != "undefined" && typeof(data.gnbFav) != "undefined") {
				var savedSvcIdList = data.gnbFav;
				for (var i=0, len = savedSvcIdList.length; i<len; i++) {
					var element = savedSvcIdList[i];
					try{
						gnb$("nsvc_" + element).checked = true;
					}catch(e){}
				}
			};
			this.addService();
			gnbJSONP.clean(this.gnbCookieScriptId);
			this.initialized = true;
		},
		addService : function(){
			//선택된 서비스 즐겨찾기에 추가
			var tempSelectedSvcArr = [];
			var gnbSvcArr = gnbGetElementsByClassName(gnb$('gnb'), 'gnb_svc_lstwrp')[0].getElementsByTagName('input');
			var onTop = "";
			if(gnb_options.gnb_login_on_top){
				onTop = " target='_top'";
			}
			for (var i=0, len=gnbSvcArr.length; i<len; i++) {
				var element = gnbSvcArr[i];
				if (element.checked == true) {
					tempSelectedSvcArr.push(element);
				};
			};
			if(tempSelectedSvcArr.length > 4){
				alert("최대 4개까지 선택 가능합니다.");
				return false;
			}else{
				this.selectedSvcArr = [];
				for (var j = 0; j < tempSelectedSvcArr.length; j++) {
					this.selectedSvcArr.push(tempSelectedSvcArr[j]);
				};
			}

			var gnbFavoriteListArr = gnb$('gnb_favorite_lst').getElementsByTagName('li');
			for (var i = 0; i < gnbFavoriteListArr.length; i++) {
				if(this.selectedSvcArr[i]){
					var svc = gnbSvcFromId(this.selectedSvcArr[i].id.split("_")[1]);
					gnbFavoriteListArr[i].className = "";
					gnbFavoriteListArr[i].innerHTML = "<a href=\"" + svc.link + "\" class=\"gnb_fav" + i + "\"" + onTop + "><img src=\"https://ssl.pstatic.net/static/common/gnb/2018/service_logo/" + svc.id + ".png\" width=\"36\" height=\"36\" alt=\"\">" + svc.sname + "</a>";
				}else{
					gnbFavoriteListArr[i].className = "gnb_add";
					gnbFavoriteListArr[i].innerHTML = "<a onclick=\"gnbMoreLayer.showMoreLayer(); return false;\"><span class=\"ic_add\"></span>추가</a>";
				}
			};
			if (typeof(ncd)!="undefined") {
				gnbNClicks.registerNClicksEvent('gnb_favorite_lst');
			};
			this.setCookie(this.getSelectecSvcIds(this.selectedSvcArr));
			return true;
		},
		getSelectecSvcIds : function(selectedSvcArr){
			var result = {};
			result.gnbFav = [];
			for (var i = 0; i < selectedSvcArr.length; i++) {
				result.gnbFav.push(selectedSvcArr[i].id.split("_")[1]);
			};
			return gnbJsonStringify(result);
		},
		cancel : function(){
			var elem = gnbGetElementsByClassName(gnb$('gnb'), 'gnb_svc_lstwrp');
			var gnbSvcArr = { };
			if (elem && elem.length > 0) {
				gnbSvcArr = elem[0].getElementsByTagName('input');
			}
			for (var i=0, len=gnbSvcArr.length; i<len; i++) {
				gnbSvcArr[i].checked = false;
			}
			for (var i=0, len=this.selectedSvcArr.length; i<len; i++) {
				this.selectedSvcArr[i].checked = true;
			}
			gnbMoreLayer.hideMoreLayer();
		},
		resetService : function(){
			var gnbSvcArr = gnbGetElementsByClassName(gnb$('gnb'), 'gnb_svc_lstwrp')[0].getElementsByTagName('input');
			for (var i=0, len=gnbSvcArr.length; i<len; i++) {
				gnbSvcArr[i].checked = false;
			}
		},
		clickToggle : function(){
			//gnbMoreLayer에 있는 clickToggleWhole 옮겨오기
		},
		setCookie : function(json){
			gnbJSONP.read(this.gnbCookieScriptId, "https://static.nid.naver.com/gnbConfig.nhn?callback=gnbFavorite.callback&config=" + encodeURIComponent(json));
		},
		getCookie : function(){
			if (this.initialized) {
				return;
			}
			gnbJSONP.read(this.gnbCookieScriptId, "https://static.nid.naver.com/gnbConfig.nhn?callback=gnbFavorite.init");
		},
		callback : function(){
			gnbJSONP.clean(this.gnbCookieScriptId);
		}
	};

	gnb_search = {
		keyToggle : false,
		searchPopOnMouse : false,
		search : function(){
			var index = 0;
			var viewbox = gnbGetElementsByClassName(gnb$('gnb'), 'gnb_pop_lst')[0];

			viewbox.innerHTML = "";
			var key = gnb$('gnb_svc_search_input').value;
			var keyLength = 0;
			var keys = gnbHangul.getCode(key).split(',');
			keyLength = keys.length;
			var resultArr = [];
			if(keyLength == 1 && keys[0] != ""){
				gnbGetElementsByClassName(gnb$('gnb'), 'gnb_pop_input')[0].style.display = "block";
				for (var i = 0; i < gnbWholeSvc.length; i++) {
					var listIndex = -1;
					for (var j = 0; j < gnbWholeSvc[i].query.length; j++) {
						listIndex *= gnbHangul.search(gnbWholeSvc[i].query[j].replace(/ |\//gi, ""), key.replace(/ |\//gi, ""))
					};
					if (listIndex == 0) {
						viewbox.innerHTML += this.getitem(gnbWholeSvc[i], index++);
					}
				}
			} else if(keyLength > 1 ){
				gnbGetElementsByClassName(gnb$('gnb'), 'gnb_pop_input')[0].style.display = "block";
				for (var i = 0; i < gnbWholeSvc.length; i++) {
					var listIndex = -1;
					for (var j = 0; j < gnbWholeSvc[i].query.length; j++) {
						listIndex = Math.max(gnbHangul.search(gnbWholeSvc[i].query[j].replace(/ |\//gi, ""), key.replace(/ |\//gi, "")), listIndex);
					};
					if (listIndex >= 0) {
						resultArr.push([gnbWholeSvc[i],listIndex]);
					}
				}
				var indexes = this.getMinIndexArr(resultArr);
				for (var i = 0; i < indexes.length; i++) {
					viewbox.innerHTML += this.getitem(resultArr[indexes[i]][0], index++);
				};
			} else {
				gnbGetElementsByClassName(gnb$('gnb'), "gnb_pop_input")[0].scrollTop = 0;
				gnbGetElementsByClassName(gnb$('gnb'), 'gnb_pop_input')[0].style.display = "none";
				this.scrollPos = 0;
			}
			if (typeof(ncd) != "undefined") {
				gnbNClicks.registerSearchNClicksEvent('gnb_pop_input');
			};
		},
		getMinIndexArr : function(array){
			var tempArr = [];
			for (var i = 0; i < array.length; i++) {
			    tempArr.push([array[i],i]);
			}
			tempArr.sort();
			var indexes = [];
			for (var j = 0; j < tempArr.length; j++) {
			    indexes.push(tempArr[j][1]);
			}
			return indexes;
		},
		clearInput : function(element){
			element.parentElement.className = (element.parentElement.className.indexOf("fcs") == -1 ? [element.parentElement.className, "fcs"].join(' ') : element.parentElement.className);
			gnb$('gnb_del_txt').style.display = "block";
			var inputBox = gnb$('gnb_svc_search_input');
			inputBox.value = "";
		},
		resetInput : function(element){
			if (element.parentElement.className.indexOf(" fcs") != -1) {
				element.parentElement.className = element.parentElement.className.replace(" fcs", "");
			};
			gnb$('gnb_del_txt').style.display = "none";
			if(this.searchPopOnMouse == false){
				var inputBox = gnb$('gnb_svc_search_input');
				inputBox.value = "";
				this.search();
				//inputBox.value = "더 많은 서비스를 간편하게 시작하세요!";
			}
		},
		getitem : function(svc, index){
			var item = "";
			var onTop = "";
			var nvl = function(arg) { return arg == null ? "" : arg; };
			if(gnb_options.gnb_login_on_top){
				onTop = " target='_top'";
			}
			if (index == 0) {
				item = "<li onmouseover=\"gnb_search.removeActiveAll(); gnb_search.setActive(this);\" index=\"" + index.toString() + "\" class=\"on\"><a class=\"" + nvl(svc.clickCd) + "\" href=\"" + svc.link + "\"" + onTop + ">";
			}else{
				item = "<li onmouseover=\"gnb_search.removeActiveAll(); gnb_search.setActive(this);\" index=\"" + index.toString() + "\"><a class=\"" + nvl(svc.clickCd) + "\" href=\"" + svc.link + "\"" + onTop + ">";
			}
			item += svc.name;
			item += "</a></li>"
			return item;
		},
		mouseOver : function(element){
			element.className = (element.className.indexOf("over") == -1 ? [element.className, "over"].join(' ') : element.className);
		},
		mouseOut : function(element){
			if (element.className.indexOf(" over") != -1) {
				element.className = element.className.replace(" over", "");
			};
		},
		keyDown : function(e){
			var nvl = function(arg) { return arg == null ? "" : arg; };
			var ENTER_KEY = 13;
			var event = e ? e : window.event;
			if (event.keyCode == ENTER_KEY && ! gnb_options.gnb_login_on_top) {
				var focused = gnbGetElementsByClassName(gnbGetElementsByClassName(gnb$('gnb'), 'gnb_pop_lst')[0], 'on');
				if (focused.length > 0) {
					var focusedAnchor = focused[0].children[0];
					if(typeof(ncd)!="undefined"){
						ncd.clickcrD('gnb.v2', focusedAnchor, 'mor.search', nvl(focusedAnchor.className.substr(6)), 1, e);
					}
					location.href = focusedAnchor.href;
				};
			} else if (event.keyCode == 27) {
				var inputBox = gnb$('gnb_svc_search_input');
				inputBox.value = "";
				this.search();
			};
			this.keyToggle = true;
		},
		scrollPos : 0,
		keyUp : function(e){
			if (!this.keyToggle) {
				return false;
			};
			var event = e ? e : window.event;
			var scrollWrapper = gnbGetElementsByClassName(gnb$('gnb'), "gnb_pop_input")[0];
			if(event.keyCode == 38){
				var focused = gnbGetElementsByClassName(gnbGetElementsByClassName(gnb$('gnb'), 'gnb_pop_lst')[0], 'on');
				if (focused.length > 0) {
					if (focused[0].previousSibling != null) {
						this.setActive(focused[0].previousSibling);
						this.removeActive(focused[0]);
						var index = parseInt(focused[0].getAttribute('index'));
						if (index > this.scrollPos + 4){
							this.scrollPos = index -4;
						}
						if (index <= this.scrollPos) {
							this.scrollPos = index;
							scrollWrapper.scrollTop = gnbGetElementsByClassName(gnb$('gnb'), 'gnb_pop_lst')[0].children[index-1].offsetTop;
						};
					}else{
						this.removeActive(focused[0]);
					};
				};
			}else if(event.keyCode == 40){
				var focused = gnbGetElementsByClassName(gnbGetElementsByClassName(gnb$('gnb'), 'gnb_pop_lst')[0], 'on');
				if (focused.length == 0) {
					if(gnbGetElementsByClassName(gnb$('gnb'), 'gnb_pop_lst')[0].getElementsByTagName('li').length != 0){
						gnbGetElementsByClassName(gnb$('gnb'), 'gnb_pop_lst')[0].getElementsByTagName('li')[0].className = "on";
					}
				}else if (focused[0].nextSibling != null) {
					this.setActive(focused[0].nextSibling);
					this.removeActive(focused[0]);
					var index = parseInt(focused[0].getAttribute('index'));
					if (index > this.scrollPos + 4) {
						this.scrollPos = index -4;
						scrollWrapper.scrollTop = gnbGetElementsByClassName(gnb$('gnb'), 'gnb_pop_lst')[0].children[index-4].offsetTop;
					};
				};
			}else{
				this.search();
			}
			this.keyToggle = false;
		},
		removeActiveAll : function(){
			var activeElements = gnbGetElementsByClassName(gnbGetElementsByClassName(gnb$('gnb'), 'gnb_pop_lst')[0], 'on');
			for (var i = 0; i < activeElements.length; i++) {
				activeElements[i].className = "";
			};
		},
		setActive : function(element){
			element.className = "on";
		},
		removeActive : function(element){
			element.className = "";
		}
	};
}

function reloadGNB() {
	var isReload = true;
	getGNB(isReload);
}
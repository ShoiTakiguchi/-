function connecttext( textid, ischecked ) {
	document.getElementById(textid).disabled = true;
   if( ischecked == true ) {
      // チェックが入っていたら有効化
      document.getElementById(textid).disabled = false;
   }
   else {
      // チェックが入っていなかったら無効化
      document.getElementById(textid).disabled = true;
   }
}

function connectradio( radioname, ischecked ) {

	var list = document.getElementsByName(radioname);

	for( i=0; i<list.length; i++){
		if( ischecked == true ) {
			   list[i].disabled = false;
		   } else {
			   list[i].disabled = true;
		   }
	}
}

function connectdate( id1,id2,id3,id4,id5,id6,ischecked ) {

		var list = [id1,id2,id3,id4,id5,id6];

		for( i=0; i<list.length; i++){
			   if( ischecked == true ) document.getElementById(list[i]).disabled = false;
			   else document.getElementById(list[i]).disabled = true;
		}
}
function booktext( ischecked ) {

   if( ischecked == true ) {
      // チェックが入っていたら有効化
      document.getElementById('author').required = true;
      document.getElementById('isbn').required = true;
      document.getElementById('publisher').required = true;
      document.getElementById('keyword').required = true;

      document.getElementById('author').disabled = false;
      document.getElementById('isbn').disabled = false;
      document.getElementById('publisher').disabled = false;
      document.getElementById('keyword').disabled = false;

   }
   else {
      // チェックが入っていなかったら無効化
	    document.getElementById('author').required = false;
	      document.getElementById('isbn').required = false;
	      document.getElementById('publisher').required = false;
	      document.getElementById('keyword').required = false;

	      document.getElementById('author').disabled = true;
	      document.getElementById('isbn').disabled = true;
	      document.getElementById('publisher').disabled = true;
	      document.getElementById('keyword').disabled = true;
   }
}

function anothertext( ischecked ) {

	   if( ischecked != true ) {

	      document.getElementById('author').required = true;
	      document.getElementById('isbn').required = true;
	      document.getElementById('publisher').required = true;
	      document.getElementById('keyword').required = true;

	      document.getElementById('author').disabled = false;
	      document.getElementById('isbn').disabled = false;
	      document.getElementById('publisher').disabled = false;
	      document.getElementById('keyword').disabled = false;

	   }
	   else {

		    document.getElementById('author').required = false;
		      document.getElementById('isbn').required = false;
		      document.getElementById('publisher').required = false;
		      document.getElementById('keyword').required = false;

		      document.getElementById('author').disabled = true;
		      document.getElementById('isbn').disabled = true;
		      document.getElementById('publisher').disabled = true;
		      document.getElementById('keyword').disabled = true;
	   }
	}


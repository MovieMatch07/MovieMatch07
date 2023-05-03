package com.suraj.moviematch.data


val jsonAdvenchureMovies = """
{
  "movies": [
   
     {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAdventure%2FMovies%2FAquaman.mkv?alt=media&token=f26a87dc-f828-44c8-b413-2bbd876512ed",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAnimation%2Fimages%2FCoco.jpg?alt=media&token=2b6a9956-d6b0-447e-9c99-633e34212c83",
      "movieName": "Aquaman",
      "categories": [ "Adventure","Action"],
      "length": "1h 45m"
    },   
    
     {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAdventure%2FMovies%2FDora%20the%20Explorer%20Lost%20City.mkv?alt=media&token=68282e4e-463b-45af-a0a0-337319ff5661",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAnimation%2Fimages%2FFrozen.jpg?alt=media&token=7664f438-d05c-4f8e-b233-4af0086491f2",
      "movieName": "Dora and the lost city",
      "categories": ["Adventure", "Musical"],
      "length": "1h 42m
"
    },
         
     {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAdventure%2FMovies%2FJack.the.Giant.Slayer.mkv?alt=media&token=544f049a-04b1-41b1-9f6c-bd50dd520e63",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAnimation%2Fimages%2FPussInBoots.jpg?alt=media&token=6091ed8e-675b-45e8-a461-471c034e9c13",
      "movieName": "Jack the Giant Slayer",
      "categories": ["Adventure", "Fantacy"],
      "length": "1h 42m"
    },
         
     {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAnimation%2FMovies%2FIceAge4.mkv?alt=media&token=123c44ca-b730-414f-b863-da2a72dd1ced",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAnimation%2Fimages%2FiceAge.jpg?alt=media&token=96839186-1bc7-4f33-bf96-cf0aacf6b2d6",
      "movieName": "Ice Age",
      "categories": ["Adventure", "Comedy"],
      "length": "1h 28m"
    },
         
     {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAnimation%2FMovies%2FRango.mkv?alt=media&token=c9269860-998f-4d81-bf5c-166663670497",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAnimation%2Fimages%2FRango.jpg?alt=media&token=3ea249a9-ca08-4eda-88b7-47dfa80d998b",
      "movieName": "Rango",
      "categories": ["Adventure", "Western"],
      "length": "1h 47m"
    },
         
     {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAnimation%2FMovies%2FTangled.mkv?alt=media&token=95e78f99-71f3-483e-8d84-ee53cdcc74d3",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAnimation%2Fimages%2FTangled.jpg?alt=media&token=5448fecb-fa73-40ec-a7c8-0d74b157d3ee",
      "movieName": "Tangled",
      "categories": ["Family", "Musical"],
      "length": "1h 40m"
    },
         
     {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAnimation%2FMovies%2FTheCroods.mkv?alt=media&token=dc4f78d6-e4d1-4fa9-9975-5c1554a24aed",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAnimation%2Fimages%2Fcroods.jpg?alt=media&token=54703574-71fa-4476-aee7-7361fc7aa456",
      "movieName": "The Croods  ",
      "categories": ["Adventure", "Comedy"],
      "length": "1h 38m"
    },
         
     {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAnimation%2FMovies%2FUp.mkv?alt=media&token=1f1d6424-7c6f-45cb-a78f-e5d1aadeb630",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAnimation%2Fimages%2Fup.jpg?alt=media&token=bb073c28-f248-4aa3-a9dc-4b361dfab64c",
      "movieName": "Up",
      "categories": ["Adventure", "Family"],
      "length": "1h 36m"
    },
         
     {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAnimation%2FMovies%2FToyStory.mkv?alt=media&token=9efe7d69-561e-4bc9-bff8-2d979319a1a7",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAnimation%2Fimages%2FtoyStory.jpg?alt=media&token=63332de6-054e-4980-9b8e-96dcc132c449",
      "movieName": "Toy Story",
      "categories": ["Adventure", "Family"],
      "length": "1h 21m"
    },
         
     {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAnimation%2FMovies%2FYourName.mkv?alt=media&token=04dff79c-0bc4-4456-acd8-758a858eb4b1",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAnimation%2Fimages%2FyourName.jpg?alt=media&token=c5b1675b-a519-494f-8fac-60faee922190",
      "movieName": "Your Name",
      "categories": ["Adventure", "Romance"],
      "length": "1h 52m"
    },
     
  ]
}
"""

fun getAdventureMovieJsonData(): String {
    return jsonAnimatinMovies
}

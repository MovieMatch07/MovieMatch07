package com.suraj.moviematch.data


val jsonActionMovies = """
{
  "movies": [
 
       {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAction%2FMovie%2F6_Underground.mkv?alt=media&token=1f4b83bd-91d2-4bb2-899a-488100d0a4a6",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAction%2Fimage%2F6_Underground.jpg?alt=media&token=88b9e150-fc24-4b6c-8367-b98762e1463c",
      "movieName": "6 Underground",
      "categories": [ "Action","Comedy"],
      "length": "1h 45m"
    },   
    
       {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAction%2FMovie%2FExtraction.mkv?alt=media&token=eac4cd3c-8f32-4732-833c-dcec155f6324",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAction%2Fimage%2Fextraction.jpg?alt=media&token=b5ba961d-88e5-4c5f-8eae-8080b13c148a",
      "movieName": "Extraction",
      "categories": [ "Action","Drama"],
      "length": "1h 45m"
    },   
    
       {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAction%2FMovie%2FJohnWick.mkv?alt=media&token=6c639b79-c28f-4477-acd2-969a402a3d38",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAction%2Fimage%2FjohnWick.jpg?alt=media&token=208a6fe8-fcc4-4f94-a76f-6b37a66afd82",
      "movieName": "John Wick",
      "categories": [ "Action","Family"],
      "length": "1h 45m"
    },   
    
       {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAction%2FMovie%2FMadMaxFuryRoad.mkv?alt=media&token=6002af93-2312-4e30-be52-4418f9357a55",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAction%2Fimage%2FmadmaxFuryRoad.jpg?alt=media&token=0579af46-d476-4d04-964a-08a4ecc87b52",
      "movieName": "Mad Max : Fury Road",
      "categories": [ "Action","Adventure"],
      "length": "1h 45m"
    },   
    
       {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAction%2FMovie%2FNobody.mkv?alt=media&token=203d4a4a-eef6-434e-bde1-30ae343195c0",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAction%2Fimage%2Fnobody.jpg?alt=media&token=b2078db7-d41e-4f15-9960-6f76231e9b19",
      "movieName": "Nobody",
      "categories": [ "Action","Drama"],
      "length": "1h 45m"
    },   
    
       {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAction%2FMovie%2FRampage.mkv?alt=media&token=f3a834a1-b178-45a9-8bbe-eec4ea162c43",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAction%2Fimage%2Frampage.jpg?alt=media&token=04f85365-9452-405a-a6cd-cee9474ae24e",
      "movieName": "Rampage",
      "categories": [ "Action","Comedy"],
      "length": "1h 45m"
    },   
    
       {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAction%2FMovie%2FTheAdamProject.mkv?alt=media&token=9a679c1e-02aa-46d1-b9e5-b016dcb5f0f0",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAction%2Fimage%2FtheAdamProject.jpg?alt=media&token=bf3d8365-ed09-4876-a027-61066d5e6815",
      "movieName": "The Adam Project",
      "categories": [ "Action","Sci-Fi"],
      "length": "1h 45m"
    },   
    
       {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAction%2FMovie%2FTheGrayMan.mkv?alt=media&token=06cb91ff-7fbb-4218-b172-8c8d2c16b142",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAction%2Fimage%2FtheGrayMan.jpg?alt=media&token=f92ca144-a2fa-47bb-9d1f-2c9efc85d5ec",
      "movieName": "The Gray Man",
      "categories": [ "Action","Drama"],
      "length": "1h 45m"
    },   
    
       {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAction%2FMovie%2FTheMummyReturns.mkv?alt=media&token=c6a70308-38ad-4ac1-85a4-dff974a00b6d",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAction%2Fimage%2FtheMummyReturns.jpg?alt=media&token=066ef32a-9ba1-4f68-870c-aa0f7f80e4d8",
      "movieName": "The Mummy Returns",
      "categories": [ "Action",""],
      "length": "1h 45m"
    },   
    
       {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAction%2FMovie%2FTheTomarrowWar.mkv?alt=media&token=5cd1911c-9bd4-463f-9577-b69ff7771cb0",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAction%2Fimage%2FtheTomarrowWar.jpg?alt=media&token=bfe098dc-2b93-415b-93a5-9dd31991c625",
      "movieName": "The Tomorrow War",
      "categories": [ "Action","Sci-Fi"],
      "length": "1h 45m"
    },   
    
  ]
}
"""

fun getActionMovieJsonData(): String {
    return jsonActionMovies
}

package com.suraj.moviematch.data


val jsonAllMovies = """
{
  "movies": [
    {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/netflix-6cfee.appspot.com/o/Movies%2FKhuda%20Haafiz%20.mkv?alt=media&token=7937a70f-f536-4da0-8de2-17f150c76156",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/netflix-6cfee.appspot.com/o/Images%2FKhudaHaafiz.jpg?alt=media&token=c416a9a2-7f94-425f-a176-8da5bb00991d",
      "movieName": "Khuda Haafiz",
      "categories": ["Action", "Adventure"],
      "length": "1h 20m"
    },
     {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/netflix-6cfee.appspot.com/o/Movies%2Fdobaaraa.mkv?alt=media&token=7dfa1dd2-cab5-4de4-a802-8d9a7d70a26b",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/netflix-6cfee.appspot.com/o/Images%2FDoBaaraa.jpg?alt=media&token=ada7ad42-9dc6-4e95-8424-8ed57104be7f",
      "movieName": "Do Baaraa",
      "categories": ["Drama", "Thriller"],
      "length": "1h 30m"
    },
     {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/netflix-6cfee.appspot.com/o/Movies%2FMonicaOMyDarling%20.mkv?alt=media&token=4ba6081e-721a-468b-b340-0439429d3125",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/netflix-6cfee.appspot.com/o/Images%2FMOMD.jpg?alt=media&token=e7ef98b5-a8ca-4fa6-96ec-7ba6196d4f27",
      "movieName": "Monica Oh My Darling",
      "categories": ["Comedy", "Mystery"],
      "length": "1h 45m"
    },
     {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/netflix-6cfee.appspot.com/o/Movies%2FQala.mkv?alt=media&token=ff3e2490-b843-4f4e-b367-4ebb12713326",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/netflix-6cfee.appspot.com/o/Images%2FQala.jpg?alt=media&token=1e585a99-bcb4-4e52-a8ff-c6a728b80c0e",
      "movieName": "Qala",
      "categories": ["Musical", "Drama"],
      "length": "1h 50m"
    },
     {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/netflix-6cfee.appspot.com/o/Movies%2FBlurr.mkv?alt=media&token=108edcae-cec6-493e-9bb7-9faddb1d479d",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/netflix-6cfee.appspot.com/o/Images%2Fblurr.jpg?alt=media&token=b736745f-d048-4f28-b756-6a0a85780030",
      "movieName": "Blurr",
       "categories": ["Horror", "Thriller"],
      "length": "1h 25m"
    },
    
     {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/netflix-6cfee.appspot.com/o/Movies%2FChup.mkv?alt=media&token=93cd85bc-7ad7-4ee9-addc-a6d6af3c36a8",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/netflix-6cfee.appspot.com/o/Images%2Fchup.jpg?alt=media&token=bc6c8617-2432-49bf-8d4a-e36644192bf7",
      "movieName": "Chup",
       "categories": ["Mystery", "Thriller"],
      "length": "1h 15m"
    },
    {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/netflix-6cfee.appspot.com/o/Movies%2FFreddy.mkv?alt=media&token=33efe9e2-4495-4ddc-9f8b-6e4ac81e4bd9",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/netflix-6cfee.appspot.com/o/Images%2Ffreddy.jpg?alt=media&token=f2637618-3ed1-4f09-b8d6-1137c9c40293",
      "movieName": "Freddy",
      "categories": ["Mystery", "Thriller"],
      "length": "1h 35m"
    },
    {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/netflix-6cfee.appspot.com/o/Movies%2FHit.mkv?alt=media&token=776e7c6f-7486-4ed7-9f95-c0b6cc56e2eb",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/netflix-6cfee.appspot.com/o/Images%2Fhit.jpg?alt=media&token=fe73ff64-6807-4816-83b6-cbc5f2c2301a",
      "movieName": "Hit",
      "categories": ["Action", "Adventure"],
      "length": "1h 23m"
    }, {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/netflix-6cfee.appspot.com/o/Movies%2FTadka.mkv?alt=media&token=1c05e5f0-a018-4011-831c-20b310dae48d",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/netflix-6cfee.appspot.com/o/Images%2Ftadka.jpg?alt=media&token=6843780e-6655-4db8-99fa-4539f846b627",
      "movieName": "Tadka",
      "categories": ["Romance", "Comedy"],
      "length": "1h 37m"
    },
    {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/netflix-6cfee.appspot.com/o/Movies%2FGoodBye.mkv?alt=media&token=06573c7f-b76b-4788-9c27-44347e95b464",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/netflix-6cfee.appspot.com/o/Images%2FGoodBye.jpg?alt=media&token=dfa80f6f-8fa9-4237-bfaf-e0cb9eb4eed0",
      "movieName": "Good Bye",
      "categories": ["Family", "Drama"],
      "length": "1h 42m"
    },
    {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/netflix-6cfee.appspot.com/o/Movies%2FAvtar.mkv?alt=media&token=5398d132-304e-4552-a554-47674a9225a0",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/netflix-6cfee.appspot.com/o/Images%2Favatar.jpg?alt=media&token=9da3f9a9-ff2c-4469-aee1-d2ace990e84c",
      "movieName": "Avatar",
      "categories": ["Adventure", "Fantasy"],
      "length": "1h 72m"
    },
     {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/netflix-6cfee.appspot.com/o/Movies%2FJumanji2.mkv?alt=media&token=8bde7851-663c-40e6-8f32-1d945d77ac6c",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/netflix-6cfee.appspot.com/o/Images%2Fjumanji.jpg?alt=media&token=2e9e0931-32e4-464d-af2b-27599ef53c18",
      "movieName": "Jumanji 2",
      "categories": ["Adventure", "Comedy"],
      "length": "1h 52m"
    },
     {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/netflix-6cfee.appspot.com/o/Movies%2FRedNotice.mkv?alt=media&token=d7633f04-0bd7-4cdc-b12f-3e1479dce076",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/netflix-6cfee.appspot.com/o/Images%2FRedNotice.jpg?alt=media&token=af172d11-0bae-41aa-9246-ed65bf7d3aa6",
      "movieName": "Red Notice",
      "categories": ["Adventure", "Comedy"],
      "length": "1h 42m"
    },
     {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/netflix-6cfee.appspot.com/o/Movies%2FHobbsAndShows.mkv?alt=media&token=3e94b7ef-fff7-4641-a3f6-158358fccb47",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/netflix-6cfee.appspot.com/o/Images%2FhobsAndShows.jpg?alt=media&token=1a81db64-dbac-4a08-a2ac-67e348568928",
      "movieName": "Hobbs And Shows",
      "categories": ["Adventure", "Action"],
      "length": "1h 56m"
    },
     {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/netflix-6cfee.appspot.com/o/Movies%2FWarcraft.mkv?alt=media&token=60e76791-b0fa-4851-82d6-1e0963ced7ef",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/netflix-6cfee.appspot.com/o/Images%2Fwarcraft.jpg?alt=media&token=33e17a11-2ad5-4787-95b2-df5f6ab75501",
      "movieName": "Warcraft",
      "categories": ["Adventure", "Fantasy"],
      "length": "1h 48m"
    },

 
      {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAnimation%2FMovies%2FCoco.mkv?alt=media&token=27c44af8-0a45-464b-a41b-bca8eae8f6a1",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAnimation%2Fimages%2FCoco.jpg?alt=media&token=2b6a9956-d6b0-447e-9c99-633e34212c83",
      "movieName": "COCO",
      "categories": ["Family", "Adventure"],
      "length": "1h 45m"
    },   
    
     {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAnimation%2FMovies%2FFrozen.mkv?alt=media&token=ac70463d-2965-408b-ba13-50451c088e8a",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAnimation%2Fimages%2FFrozen.jpg?alt=media&token=7664f438-d05c-4f8e-b233-4af0086491f2",
      "movieName": "Frozen",
      "categories": ["Family", "Musical"],
      "length": "1h 42m
"
    },
         
     {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAnimation%2FMovies%2FPussInBoots.mkv?alt=media&token=f92ddb32-34cc-4ab6-a00b-646016bd9fa3",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAnimation%2Fimages%2FPussInBoots.jpg?alt=media&token=6091ed8e-675b-45e8-a461-471c034e9c13",
      "movieName": "Puss In Boots",
      "categories": ["Adventure", "Comedy"],
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
      "categories": ["Family", "Western"],
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
      "categories": ["Fantasy", "Romance"],
      "length": "1h 52m"
    },
         {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAdventure%2FMovies%2FAquaman.mkv?alt=media&token=f26a87dc-f828-44c8-b413-2bbd876512ed",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAdventure%2FImages%2Faquaman.jpg?alt=media&token=5eed3612-b91e-4656-85ea-1b8e868a0785",
      "movieName": "Aquaman",
      "categories": [ "Adventure","Action"],
      "length": "1h 45m"
    },   
    
     {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAdventure%2FMovies%2FDora%20the%20Explorer%20Lost%20City.mkv?alt=media&token=68282e4e-463b-45af-a0a0-337319ff5661",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAdventure%2FImages%2FDoraAndLostCity.jpg?alt=media&token=7f8cc040-b848-4479-b572-9ceaa30a672d",
      "movieName": "Dora and the lost city",
      "categories": ["Adventure", "Musical"],
      "length": "1h 42m"
    },
         
     {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAdventure%2FMovies%2FJack.the.Giant.Slayer.mkv?alt=media&token=544f049a-04b1-41b1-9f6c-bd50dd520e63",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAdventure%2FImages%2FjackAndGiant.jpg?alt=media&token=2f097610-ad62-4be2-8a8f-104d20c82256",
      "movieName": "Jack the Giant Slayer",
      "categories": ["Adventure", "Fantacy"],
      "length": "1h 42m"
    },
         
     {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAdventure%2FMovies%2FJumanji.WelcomeToTheJungle.mkv?alt=media&token=81d14887-1792-45b7-acf6-67b55dd87c8e",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAdventure%2FImages%2Fjumanji2.jpg?alt=media&token=15b57c1c-47e9-4835-bd82-29b400900c1a",
      "movieName": "Jumanji : Welcome to the jungle",
      "categories": ["Adventure", "Comedy"],
      "length": "1h 28m"
    },
         
    {
    
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAdventure%2FMovies%2FJumanjiNextLevel.mkv?alt=media&token=2c5ecc5f-3385-47ab-9036-ac8eb0327de2",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAdventure%2FImages%2Fjumanji3.jpg?alt=media&token=d5e4669d-8392-4e2e-9e96-8c1e250ef888",
      "movieName": "Jumanji : Next Level",
      "categories": ["Adventure", "Comedy"],
      "length": "1h 28m"
    },
         
         {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAdventure%2FMovies%2FJungleCruise.mkv?alt=media&token=3717b873-c8c0-458e-ba20-cdae9e95fdff",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAdventure%2FImages%2FjungleCruice.jpg?alt=media&token=04233b44-ab36-4881-acba-c65a8494efb8",
      "movieName": "Jungle Cruise",
      "categories": ["Adventure", "Comedy"],
      "length": "1h 28m"
    },
         
             {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAdventure%2FMovies%2FpiratesOfCaribbean4.mkv?alt=media&token=5187b27a-c1fd-4bbe-b87d-53d7d61ae5f9",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAdventure%2FImages%2Fpirates4.jpg?alt=media&token=64023073-32e9-4443-ac94-24d32f8bddb7",
      "movieName": "Pirates 4",
      "categories": ["Adventure", "Comedy"],
      "length": "1h 28m"
    },
         
             {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAdventure%2FMovies%2FPiratesOftheCaribbean%206.mkv?alt=media&token=e19c3425-20d1-4511-8d82-cd782d8d4822",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAdventure%2FImages%2Fpirates5.jpg?alt=media&token=b35a99ef-8d74-44d8-8dc0-5d3c8241ac57",
      "movieName": "Pirates 5",
      "categories": ["Adventure", "Comedy"],
      "length": "1h 28m"
    },
         
             {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAdventure%2FMovies%2FThe.Jungle.Book.mkv?alt=media&token=3508cece-93fc-45dc-88fd-820c25cde8d4",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAdventure%2FImages%2FtheJungleBook.jpg?alt=media&token=ccb08c9f-62d7-4538-873f-cb4761e7b610",
      "movieName": "The Jungle Book",
      "categories": ["Adventure", "Family"],
      "length": "1h 28m"
    },
         
             {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAdventure%2FImages%2FLostCityZ.jpg?alt=media&token=3b04bfd6-b795-4481-a127-b09269c74474",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FAdventure%2FImages%2FLostCityZ.jpg?alt=media&token=3b04bfd6-b795-4481-a127-b09269c74474",
      "movieName": "Lost City Z",
      "categories": ["Adventure", "Thriller"],
      "length": "1h 28m"
    },
      {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FComedy%2Fmovies%2FDueDate.mkv?alt=media&token=0682f5f9-7173-4eef-8709-700bb998de89",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FComedy%2Fimages%2FdueDate.jpg?alt=media&token=3676cf97-3a7f-4627-93d6-a5565ff4c6a0",
      "movieName": "Due Date",
      "categories": [ "Comedy","Adventure"],
      "length": "1h 45m"
    },   
    
    
     {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FComedy%2Fmovies%2FFatherhood.mkv?alt=media&token=7b9494e5-e5a1-464a-93f4-9fa598d0805d",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FComedy%2Fimages%2Ffatherhood.jpg?alt=media&token=edf4acc4-64f2-4e0b-868b-ad86ccdc1480",
      "movieName": "Fatherhood",
      "categories": [ "Comedy","Family"],
      "length": "1h 45m"
    },   
    
    
    {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FComedy%2Fmovies%2FFreeGuy.mkv?alt=media&token=5ee07d6d-f924-4fcb-9192-04f1cd52f098",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FComedy%2Fimages%2FfreeGuy.jpg?alt=media&token=78a387d1-8973-41a6-a661-62d502dd5195",
      "movieName": "Free Guy",
      "categories": [ "Comedy","Sci-Fi"],
      "length": "1h 45m"
    },   
    
    
    {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FComedy%2Fmovies%2FHitmanWife'sBodyguard.mkv?alt=media&token=1bcda950-9e30-479d-b25d-03c08b067227",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FComedy%2Fimages%2FhitmanWifsBodyguard.jpg?alt=media&token=18163886-a29e-4829-99ed-29783ebd4596",
      "movieName": "Hitman's Wife's Bodyguard",
      "categories": [ "Comedy","Action"],
      "length": "1h 45m"
    },   
    
    
    {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FComedy%2Fmovies%2FInstantFamily.mkv?alt=media&token=59667dc4-1295-4494-b550-6c07a005fe56",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FComedy%2Fimages%2FinstanFamily.jpg?alt=media&token=ab480792-f6f6-4913-80e1-8a37c9a8c6ef",
      "movieName": "Instant Family",
      "categories": [ "Comedy","Family"],
      "length": "1h 45m"
    },   
    
    
    
    {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FComedy%2Fmovies%2FPaul.mkv?alt=media&token=324676bf-e797-42db-9799-632ee27a1167",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FComedy%2Fimages%2Fpaul.jpg?alt=media&token=4b7ac740-abd7-44e9-a7db-266a23e16f9f",
      "movieName": "Paul",
      "categories": [ "Comedy","Adventure"],
      "length": "1h 45m"
    },   
    
    
    
    {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FComedy%2Fmovies%2FShaunOfTheDead.mkv?alt=media&token=57ea6426-eca2-4d87-9055-30d7900b4d0d",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FComedy%2Fimages%2FshaunOfTheDead.jpg?alt=media&token=037f1c2b-8c0b-40ca-ac80-b736c4122d45",
      "movieName": "Shaun Of The Dead",
      "categories": [ "Comedy","Zombie"],
      "length": "1h 45m"
    },   
    
    
    
    {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FComedy%2Fmovies%2FTheNiceGuys.mkv?alt=media&token=3482eccc-f698-4842-8f66-95a8144f4df2",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FComedy%2Fimages%2FtheNiceGuys.jpg?alt=media&token=0757ca18-2a2d-4af9-a755-97b762e834ad",
      "movieName": "The Nice Guys",
      "categories": [ "Comedy","Action"],
      "length": "1h 45m"
    },   
    
    
    
    {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FComedy%2Fmovies%2FTropicThunder.mkv?alt=media&token=115e882b-3fda-4c4f-80d5-ebed7dbb761b",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FComedy%2Fimages%2FtropicThunder.jpg?alt=media&token=6c0a8933-df7e-4ad0-86f8-77d3e8abbf7e",
      "movieName": "Tropic Thunder",
      "categories": [ "Comedy","War"],
      "length": "1h 45m"
    },   
    
    
    
    {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FComedy%2Fmovies%2Foutih.mkv?alt=media&token=afa2a151-a0d1-4383-a619-3f9127129007",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FComedy%2Fimages%2Foutih.jpg?alt=media&token=c7d43ccf-dfae-4cb5-93cd-dd4eecb24827",
      "movieName": "One Upon A Time In Hollywood",
      "categories": [ "Comedy","Drama"],
      "length": "1h 45m"
    },   
    
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
   

       {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FThriller%2FMovie%2F127_Hours.mkv?alt=media&token=ccddbb3d-4e63-4e78-bd8d-7878eb46565e",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FThriller%2Fimage%2F127_hours.jpg?alt=media&token=0440464c-ce01-4cdc-9d62-d63afcd585e6",
      "movieName": "127 Hours",
      "categories": [ "Thriller","Survival"],
      "length": "1h 45m"
    },
        
       {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FThriller%2FMovie%2FDontBreath.mkv?alt=media&token=76bc47ea-5699-41d5-aa37-b9d987acec0d",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FThriller%2Fimage%2FdontBreathe.jpg?alt=media&token=b8bdbab0-a980-4964-8fc0-1e5f4465040a",
      "movieName": "Don't Breath",
      "categories": [ "Thriller","Action"],
      "length": "1h 45m"
    },
     
       {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FThriller%2FMovie%2FFall.mkv?alt=media&token=50483da5-7164-406a-bd6e-690cc183d5c4",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FThriller%2Fimage%2Ffall.jpg?alt=media&token=e88aefcd-da5c-4599-bf07-09939764a1e8",
      "movieName": "Fall",
      "categories": [ "Thriller","Survival"],
      "length": "1h 45m"
    },
     
       {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FThriller%2FMovie%2FGravity.mkv?alt=media&token=d67d42ce-8b61-4375-915c-f7c5f4079116",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FThriller%2Fimage%2Ffravity.jpg?alt=media&token=b96ac523-c654-4753-b021-a53224a9e1c5",
      "movieName": "Gravity",
      "categories": [ "Thriller","Survival"],
      "length": "1h 45m"
    },
     
       {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FThriller%2FMovie%2FHush.mkv?alt=media&token=2e4e6bda-4ae0-4644-96f3-3ee0012f359e",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FThriller%2Fimage%2Fhush.jpg?alt=media&token=b2a28719-0926-4587-aa16-3ce861a59246",
      "movieName": "Hush",
      "categories": [ "Thriller","Suspense"],
      "length": "1h 45m"
    },
     
       {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FThriller%2FMovie%2FMenOnLedge.mkv?alt=media&token=08e43152-1cb8-447d-bb51-fdc484d02751",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FThriller%2Fimage%2FmanOnLedge.jpg?alt=media&token=30b45e0a-929b-478d-b4b1-4d917f132e8a",
      "movieName": "Man On Ledge",
      "categories": [ "Thriller","Mystery"],
      "length": "1h 45m"
    },
     
       {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FThriller%2FMovie%2FShutterIsland.mkv?alt=media&token=5debb44b-be09-47e4-bfcb-09e5f30d61f3",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FThriller%2Fimage%2FshutterIsland.jpg?alt=media&token=3d0c54a8-0076-4e61-9b64-efa5911cc02f",
      "movieName": "Shutter Island",
      "categories": [ "Thriller","Fantasy"],
      "length": "1h 45m"
    },
     
       {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FThriller%2FMovie%2FTheRevenant.mkv?alt=media&token=5e5e3eea-e0a0-43c5-aec0-1cf12c3f528a",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FThriller%2Fimage%2FtheRevenant.jpg?alt=media&token=c944bbd8-a9a4-4ead-9456-09d6e059a4e4",
      "movieName": "The Revenant",
      "categories": [ "Thriller","Action"],
      "length": "1h 45m"
    },
     
       {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FThriller%2FMovie%2FTheRuins.mkv?alt=media&token=49691b99-cb2e-4ca1-bca2-3e7b15a3802c",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FThriller%2Fimage%2FtheRuins.jpg?alt=media&token=74cd2f4a-81e8-44af-9cdf-6c5ad910f6ac",
      "movieName": "The Ruins",
      "categories": [ "Thriller","Mystery"],
      "length": "1h 45m"
    },
     
       {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FThriller%2FMovie%2FTrainToBusan.mkv?alt=media&token=98825eff-4fbc-4288-a98c-b7becad322da",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FThriller%2Fimage%2FtrainToBusan.jpg?alt=media&token=013fa6fd-d332-4a9e-ac3d-c75a29b3966f",
      "movieName": "Train To Busan",
      "categories": [ "Thriller","Horror"],
      "length": "1h 45m"
    },
     {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FHorror%2FBarbarian.mkv?alt=media&token=2205c0d8-c7bb-4e5e-b895-a01874cdd5ac",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FHorror%2FImage%2Fbarbarian.jpg?alt=media&token=0e8320a6-957c-4946-ad78-5dce3d92dc29",
      "movieName": "Barbarian",
      "categories": [ "Horror","Thriller"],
      "length": "1h 45m"
    },   
    
    
       {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FHorror%2FLightsOut.mkv?alt=media&token=fab1326e-bd09-4dad-8b31-130605125fe2",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FHorror%2FImage%2FlightsOut.jpg?alt=media&token=6bb8478d-95fa-479b-9ba1-402f71d5b730",
      "movieName": "Lights Out",
      "categories": [ "Horror","Mystery"],
      "length": "1h 45m"
    },   
    
    
       {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FHorror%2FMegan.mkv?alt=media&token=804e83e3-945d-4353-b3e6-1a7cc229217b",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FHorror%2FImage%2Fmegan.jpg?alt=media&token=cb25f174-0017-48a6-9f65-c80ede299d98",
      "movieName": "Megan",
      "categories": [ "Horror","Sci-Fi"],
      "length": "1h 45m"
    },   
    
    
       {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FHorror%2FSmile.mkv?alt=media&token=e7e0c5a1-d91f-457c-aac9-332f350dcb2e",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FHorror%2FImage%2Fsmile.jpg?alt=media&token=2b1fd7ee-f4e1-4650-8a5d-a5c69d545486",
      "movieName": "Smile",
      "categories": [ "Horror","Thriller"],
      "length": "1h 45m"
    },   
    
    
       {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FHorror%2FRings.mkv?alt=media&token=8b187dae-e9fd-47b8-a8b7-e96d1ef660b7",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FHorror%2FImage%2FtheRings.jpg?alt=media&token=d8726e25-0acd-4ade-8c5e-43b775f0dd1a",
      "movieName": "The Rings",
      "categories": [ "Horror","Mystery"],
      "length": "1h 45m"
    },   
    
    
       {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FHorror%2FTheConjuring2.mkv?alt=media&token=43f00664-5ae0-4263-997b-ca877751cbd4",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FHorror%2FImage%2FtheConjuring2.jpg?alt=media&token=137a6ede-7197-461c-b4b0-308bd9d410b6",
      "movieName": "The Conjuring 2",
      "categories": [ "Horror","Family"],
      "length": "1h 45m"
    },   
    
    
       {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FHorror%2FTheDescent2.mkv?alt=media&token=da93dfec-6236-465d-9540-0a2815d0d4f8",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FHorror%2FImage%2FtheDescent2.jpg?alt=media&token=063c8e1f-55f9-4f92-99b0-0d58a72cf5ae",
      "movieName": "The Descent 2",
      "categories": [ "Horror","Survival"],
      "length": "1h 45m"
    },   
    
    
       {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FHorror%2FTheShallows.mkv?alt=media&token=4833e4f6-6fb0-4096-8b69-03779d63823c",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FHorror%2FImage%2FtheShallows.jpg?alt=media&token=1e3a28cd-85f8-4547-afc6-9c984dc7ad56",
      "movieName": "The Shallow",
      "categories": [ "Horror","Survival"],
      "length": "1h 45m"
    },   
    
    
       {
      "movieUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FHorror%2FWinnieThePoo.mkv?alt=media&token=491d9c32-de3c-4963-ad17-e57f59c689ce",
      "imageUrl": "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Movies%2FHorror%2FImage%2FwinnieThePoo.jpg?alt=media&token=1bc1eb2a-10a1-4441-84eb-5ede92ba0e36",
      "movieName": "Winnie The Poo",
      "categories": [ "Horror","Mystery"],
      "length": "1h 45m"
    },   
    
  ]
}
"""

fun getAllMovieJsonData(): String {
    return jsonAllMovies
}

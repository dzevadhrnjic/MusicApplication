# MusicApplication

This is a spring boot rest api for managing songs.

Song is a model with following fields (id, songname, artistname, songurl, songrating, created, lastupdatedat).
I have build restApi for managing this song model and for database access i used spring data library.

RestApi endpoints:
- POST /api/songs + song request body -> returns 201 + created song object
- GET /api/songs -> returns 200 + list of songs 
  - available query parameters for get: (search, artistname, ratingFrom, ratingTo)
- GET /api/songs/pagination -> returns 200 + list of songs
  -available query parameters for get: (size)
- PUT /api/songs/id + song request body -> returns 204 
- DELETE /api/songs/id -> returns 204
- POST /api/user/login + request body -> returns 200 + access token

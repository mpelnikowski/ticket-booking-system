#!/bin/sh
# This is a comment! 
curl --header "Content-Type: application/json" \
  --request POST \
  --verbose \
  --silent \
  --data '@add_auditorium_request_body.json' \
  http://localhost:8080/auditorium/add
echo
echo
echo  "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" 
echo
echo  
curl --header "Content-Type: application/json" \
  --request POST \
  --verbose \
  --silent \
  --data '@add_movie_request_body.json' \
  http://localhost:8080/movie/add
echo
echo
echo  "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" 
echo
echo  
curl --header "Content-Type: application/json" \
  --request POST \
  --verbose \
  --silent \
  --data '@add_screening_request_body.json' \
	http://localhost:8080/screening/add
echo
echo
echo  "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" 
echo
echo 
curl --header "Content-Type: application/json" \
  --request GET \
  --verbose \
  --silent \
  --data '@find_all_movies_request_body.json' \
  http://localhost:8080/movie/findAllMovies
echo
echo 
echo  "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"
echo
echo 
curl --header "Content-Type: application/json" \
  --request GET \
  --verbose \
  --silent \
  http://localhost:8080/screening/getScreening?screeningId=1
echo
echo
echo  "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"
echo
echo 
curl --header "Content-Type: application/json" \
  --request POST \
  --verbose \
  --silent \
  --data '@reservation_request_body_no_seat_selected.json' \
  http://localhost:8080/reservation/create
echo
echo
echo  "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"
echo
echo 
curl --header "Content-Type: application/json" \
  --request POST \
  --verbose \
  --silent \
  --data '@reservation_request_body.json' \
  http://localhost:8080/reservation/create
echo
echo
echo  "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" 
echo
echo 
curl --header "Content-Type: application/json" \
  --request POST \
  --verbose \
  --silent \
  --data '@reservation_request_body_without_discount_code_space_left.json' \
  http://localhost:8080/reservation/create
echo
echo
echo  "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" 
echo
echo 
curl --header "Content-Type: application/json" \
  --request POST \
  --verbose \
  --silent \
  --data '@reservation_request_body_without_discount_code_no_space_left.json' \
  http://localhost:8080/reservation/create
# This is a comment, too!



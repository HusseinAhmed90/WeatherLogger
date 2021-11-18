# WeatherLogger

Android project using clean architecture

##### The application simply gets the current weather data of Cairo Egypt form backend api service then cache it locally in a Room database and shows the all fetched data previously in a friendly and high performance list.

##### The app scenario is too simple: simple splash screen then a list of past fetched weather data and a floating action button to fetch the most recent weather data from the backend API also we can remove the unwanted cached weather data by clicking on the delete icon of targeted item

<img src="https://github.com/HusseinAhmed90/WeatherLogger/blob/docs/1.jpg" width="30%" height="30%">     <img src="https://github.com/HusseinAhmed90/WeatherLogger/blob/docs/2.jpg" width="30%" height="30%">     <img src="https://github.com/HusseinAhmed90/WeatherLogger/blob/docs/3.jpg" width="30%" height="30%">
<img src="https://github.com/HusseinAhmed90/WeatherLogger/blob/docs/4.jpg" width="30%" height="30%">     <img src="https://github.com/HusseinAhmed90/WeatherLogger/blob/docs/5.jpg" width="30%" height="30%">

#### This project created using MVVM design pattern with clean architecture to make it clean, readable, extendable and testable.

#### Some of the used libraries in this project:

##### - Android JetPack libraries( Navigation - androidx.lifecycle: livedata & viewmodel - Room)
##### - Coroutines to handle the async tasks
##### - Retrofit2 to make network request
##### - androidx.lifecycle: livedata & viewmodel

#### The navigation is handled using androidx.navigation library


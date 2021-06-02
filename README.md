# MarvelBook
Mobile Code challenge
## Highlights
  - Retreive Marvel Heroes list
  - See Hero details
  - Pagination implemented
  - Add hero favorite
  - Error handling
  - MVVM Architectural pattern
## Dependencies
* Architecture components
  * [LiveData]: observable data holder class that allows to communicate between the viewModel and the view
  * [Room]: to handle SQLite databases in a more secure way
  * [ViewModel]: manage user interface data within a lifecycle
  * [Dagger Hilt]: dependency injection framework that performs compile-time operations for Android
  * [Coroutines]: Concurrency design pattern to simplify code that runs asynchronously
* UI
  * [Glide]: image loading framework that wraps media decoding, memory and disk caching among other things
  * [ExpandableLayout]: layout class that handles the expansion and collapse of its child views
* Network
	* [OkHttp]: an efficient HTTP client
	* [Retrofit]: library to make network calls and obtain the structured result at once
* Testing
	* [Espresso]: to write concise, efficient, and reliable Android UI tests
	* [Mockk]: to set dummy objects to show some specific value when invoked

[LiveData]: <https://developer.android.com/topic/libraries/architecture/livedata>
[Room]: <https://developer.android.com/jetpack/androidx/releases/room>
[ViewModel]: <https://developer.android.com/reference/android/arch/lifecycle/ViewModel>
[Dagger Hilt]: <https://developer.android.com/training/dependency-injection/hilt-android>
[Coroutines]: <https://github.com/Kotlin/kotlinx.coroutines>

[Glide]: <https://github.com/bumptech/glide>
[ExpandableLayout]: <https://github.com/cachapa/ExpandableLayout>

[OkHttp]: <https://square.github.io/okhttp/>
[Retrofit]: <https://square.github.io/retrofit/>

[Espresso]: <https://developer.android.com/training/testing/espresso>
[Mockk]: <https://github.com/mockk/mockk>
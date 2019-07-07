# HC Verma Vol1 and 2 Solutions
#### The project is an implementation of Grid Layout in MainActivity and varoius lists in corresponding Chapters in the two volumes of HC Verma Book.
The project also uses .json file to extract the marketing banners above the MainActivity and ChapterActivity.
The Navigation bar of MainActivity implements dialog box to get Rating for the app, using a RatingBar.
The project is a simple content viewing application for viewing pdfs and does that with help of a github directory.

---
## Author and Contributors List

### Ashish Batra  

*All the bug reports can be sent to ashish.extraclass@gmail.com*

---

## ScreenShots of the Project application
#### MainActivity
![2](https://user-images.githubusercontent.com/44803205/60772460-6e181280-a114-11e9-99b4-4041cfd38b0c.png)&nbsp;&nbsp;

The Activity supports a Navigation Drawer Menu having options of Sharing the app and Rating it in a dialog box with RatingBar in its Layout file.
The Layout file of MainActivity has a ViewPager for Slider Banner above the GridLayout which has CardView for each Volume of the Book.


#### ChapterActivity
![3](https://user-images.githubusercontent.com/44803205/60772476-ab7ca000-a114-11e9-8f07-4672f235df82.png)&nbsp;&nbsp;

The Activity supports a back button to go back to the previous activity.
The Layout file of ChapterActivity has a ViewPager for Slider Banner above the ListView which picks up the data for each volume of the book from the ChapterAdapter.java file of Models folder.
The adapter uses a format of chapter from java class book also present in Models folder.
The list items have a layout specified in layout folder by list_item_layout.


#### PdfActivity
![4](https://user-images.githubusercontent.com/44803205/60772484-dd8e0200-a114-11e9-8a39-c66daa53fce3.png)&nbsp;&nbsp;

The Activity supports a back button to go back to the previous activity.
The Layout file of PdfActivity has a PdfViewer covering match_parent x match_parent.
The .java file of the Activity uses a function to load pdf files saved in assets folder of the project.
The activity imports a github library implemented in build.gradle(Module:app) file of project.

---

## Gradle Changes
Include the following library implementations for opening pdf and for opening banners in activities from .json file.

```
dependencies {
    ...
    
    implementation 'com.squareup.picasso:picasso:2.5.2'
    implementation 'com.github.barteksc:android-pdf-viewer:2.8.2'
    implementation 'com.google.code.gson:gson:2.8.2'
    implementation 'com.google.android.gms:play-services-auth:16.0.1'
    implementation 'com.google.android.libraries.places:places:1.1.0'
}
 ```
 
Click on Sync Now on Top Right corner to include the above dependencies in your Project.

---
## Acknowledgements
* ExtraClass.com
* Github Barteksc Library for PDFViewer

package com.example.iproceed

object setData {
    fun SetCourses():List<CourseData>{
        var Courselist= mutableListOf<CourseData>()

        Courselist.add(
            CourseData(
                1,
                "Android",
                "Free Content",
                "Documentation",
                "Easy",
                "Android software development is the process by which applications are created for devices running the Android operating system.\n" +
                        "Google states that \"Android apps can be written using Kotlin, Java, and C++ languages\" using the Android software development kit (SDK), while using other languages is also possible. \n" +
                        "Android OS has been developed using Linux Kernel. Because of the ability of easily modifiable (as its open source), most of the android developers have used different GUIs even when all of them use the same basic operating system. \n" +
                        "The open source code used for the development of android applications is Android Open Source Project."

            )
        )

        Courselist.add(
            CourseData(
                2,
                "Kotlin",
                "Free Content",
                "Documentation",
                "Easy",
                "Here’s what developers appreciate about writing in Kotlin:\n" +
                        "\n" +
                        "Expressive and concise: You can do more with less. Express your ideas and reduce the amount of boilerplate code. 67% of professional developers who use Kotlin say Kotlin has increased their productivity.\n" +
                        "Safer code: Kotlin has many language features to help you avoid common programming mistakes such as null pointer exceptions. Android apps that contain Kotlin code are 20% less likely to crash.\n" +
                        "Interoperable: Call Java-based code from Kotlin, or call Kotlin from Java-based code. Kotlin is 100% interoperable with the Java programming language, so you can have as little or as much of Kotlin in your project as you want.\n" +
                        "Structured Concurrency: Kotlin coroutines make asynchronous code as easy to work with as blocking code. Coroutines dramatically simplify background task management for everything from network calls to accessing local data."
            )
        )
        Courselist.add(
            CourseData(
                3,
                "Syntax Basics",
                "Free Content",
                "Documentation",
                "Medium",
                "Kotlin is a programming language widely used by Android developers everywhere. This topic serves as a Kotlin crash-course to get you up and running quickly.\n" +
                        "You should get familiar with : \n" +
                        "Variable declaration\n" +
                        "Type inference\n" +
                        "Null safety\n" +
                        "Conditionals\n" +
                        "Functions\n" +
                        "Simplifying function declarations\n" +
                        "Anonymous functions\n" +
                        "Higher-order functions\n" +
                        "Classes\n" +
                        "Class functions and encapsulation\n" +
                        "Interoperability"
            )
        )
        Courselist.add(
            CourseData(
                4,
                "Android Studio",
                "Free Content",
                "Documentation",
                "Medium",
                "Android Studio is the official Integrated Development Environment (IDE) for Android app development, based on IntelliJ IDEA . On top of IntelliJ's powerful code editor and developer tools, Android Studio offers even more features that enhance your productivity when building Android apps, such as:\n" +
                        "\n" +
                        "A flexible Gradle-based build system\n" +
                        "A fast and feature-rich emulator\n" +
                        "A unified environment where you can develop for all Android devices\n" +
                        "Apply Changes to push code and resource changes to your running app without restarting your app\n" +
                        "Code templates and GitHub integration to help you build common app features and import sample code\n" +
                        "Extensive testing tools and frameworks\n" +
                        "Lint tools to catch performance, usability, version compatibility, and other problems\n" +
                        "C++ and NDK support\n" +
                        "Built-in support for Google Cloud Platform, making it easy to integrate Google Cloud Messaging and App Engine"
            )
        )

        Courselist.add(
            CourseData(
                5,
                "Layout Material Design",
                "Free Content",
                "Documentation",
                "Medium",
                "Layouts In material design has principals : \n" +
                        "Layout anatomy\n" +
                        "Layout regions are the foundation for interactive experiences. They’re a layout’s building blocks and are composed of elements and components that share a similar function. Layout regions can also group smaller containers such as cards.\n" +
                        "Body region\n" +
                        "The body region is used for displaying most of the content in an app.\n" +
                        "The body region is used for displaying most of the content in an app. It typically contains components such as lists, cards, buttons, and images.\n" +
                        "Responsive column grid\n" +
                        "The responsive column grid is made up of columns, gutters, and margins, providing a convenient structure for the layout of elements within the body region. Components, imagery, and text align with the column grid to ensure a logical and consistent layout across screen sizes and orientations.\n" +
                        "And a lot of others principals that you have to discover with us !! \n"
            )
        )
        Courselist.add(
            CourseData(
                6,
                "Android Lifecycle",
                "Free Content",
                "Documentation",
                "Hard",
                "As a user navigates through, out of, and back to your app, the Activity instances in your app transition through different states in their lifecycle. The Activity class provides a number of callbacks that allow the activity to know that a state has changed: that the system is creating, stopping, or resuming an activity, or destroying the process in which the activity resides.\n" +
                        "\n" +
                        "Within the lifecycle callback methods, you can declare how your activity behaves when the user leaves and re-enters the activity. For example, if you're building a streaming video player, you might pause the video and terminate the network connection when the user switches to another app. When the user returns, you can reconnect to the network and allow the user to resume the video from the same spot. In other words, each callback allows you to perform specific work that's appropriate to a given change of state. Doing the right work at the right time and handling transitions properly make your app more robust and performant. For example, good implementation of the lifecycle callbacks can help ensure that your app avoids:\n" +
                        "\n" +
                        "Crashing if the user receives a phone call or switches to another app while using your app.\n" +
                        "Consuming valuable system resources when the user is not actively using it.\n" +
                        "Losing the user's progress if they leave your app and return to it at a later time.\n" +
                        "Crashing or losing the user's progress when the screen rotates between landscape and portrait orientation.\n" +
                        "This course explains the activity lifecycle in detail. \n" +
                        "Go furthur for more informations !\n"
            )
        )
        Courselist.add(
            CourseData(
                7,
                "Adapters And Recyclers",
                "Free Content",
                "Documentation",
                "Hard",
                "The RecyclerView is a ViewGroup that renders any adapter-based view in a similar way. It is supposed to be the successor of ListView and GridView. One of the reasons is that RecyclerView has a more extensible framework, especially since it provides the ability to implement both horizontal and vertical layouts. Use the RecyclerView widget when you have data collections whose elements change at runtime based on user action or network events.\n" +
                        "\n" +
                        "If you want to use a RecyclerView, you will need to work with the following:\n" +
                        "RecyclerView.Adapter : To handle the data collection and bind it to the view\n" +
                        "LayoutManager : Helps in positioning the items\n" +
                        "ItemAnimator : Helps with animating the items for common operations such as Addition or Removal of item\n" +
                        "Furthermore, it provides animation support for RecyclerView items whenever they are added or removed, which had been extremely difficult to do with ListView. RecyclerView also begins to enforce the ViewHolder pattern too, which was already a recommended practice but now deeply integrated with this new framework.\n" +
                        "\n" +
                        "For more details, see this detailed course."
            )
        )
        Courselist.add(
            CourseData(
                8,
                "Data Persistance",
                "Free Content",
                "Documentation",
                "Hard",
                "Android uses a file system that's similar to disk-based file systems on other platforms. The system provides several options for you to save your app data:\n" +
                        "\n" +
                        "App-specific storage: Store files that are meant for your app's use only, either in dedicated directories within an internal storage volume or different dedicated directories within external storage. Use the directories within internal storage to save sensitive information that other apps shouldn't access.\n" +
                        "Shared storage: Store files that your app intends to share with other apps, including media, documents, and other files.\n" +
                        "Preferences: Store private, primitive data in key-value pairs.\n" +
                        "Databases: Store structured data in a private database using the Room persistence library."
            )
        )
        Courselist.add(
            CourseData(
                9,
                "Threads",
                "Free Content",
                "Documentation",
                "Hard",
                "Every Android developer, at one point or another, needs to deal with threads in their application.\n" +
                        "\n" +
                        "When an application is launched in Android, it creates the first thread of execution, known as the “main” thread. The main thread is responsible for dispatching events to the appropriate user interface widgets as well as communicating with components from the Android UI toolkit.\n" +
                        "\n" +
                        "To keep your application responsive, it is essential to avoid using the main thread to perform any operation that may end up keeping it blocked.\n" +
                        "\n" +
                        "In Android, you can categorize all threading components into two basic categories:\n" +
                        "\n" +
                        "Threads that are attached to an activity/fragment: These threads are tied to the lifecycle of the activity/fragment and are terminated as soon as the activity/fragment is destroyed.\n" +
                        "Threads that are not attached to any activity/fragment: These threads can continue to run beyond the lifetime of the activity/fragment (if any) from which they were spawned."
            )
        )
        Courselist.add(
            CourseData(
                10,
                "Android Databases",
                "Free Content",
                "Documentation",
                "Hard",
                "\n" +
                        "The database is the most common way of storing and managing data. For quite some time now,  databases are handled on server-side or cloud and mobile devices only communicate with them through the network. However, to make applications more responsive and less dependent on network connectivity, the trend of offline usage or less dependency on the network is gaining popularity. Nowadays, applications keep DB locally or make a copy of DB over the cloud onto local devices and sync with it once in a day or whenever there is network connectivity. \n" +
                        "This will help in faster and responsive applications that are functional even when there is no or limited internet connectivity. \n" +
                        "There is a lot of databases like SQLite,Realm DB,ORMLite Berkeley DB and Couchbase Lite \n"+
                        "Go In Depth To Learn more ! "
            )
        )
        return Courselist
    }
}
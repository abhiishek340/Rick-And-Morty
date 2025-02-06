# Rick and Morty Character Viewer

A modern Android application that displays characters from the Rick and Morty universe with a clean **Material Design 3** interface.

---

## 🚀 Features

✅ **Character List** – Scrollable list of Rick and Morty characters  
✅ **Character Details** – View detailed character information in a beautiful dialog  
✅ **Visual Status Indicators** – Color-coded indicators (🟢 Alive, 🔴 Dead, ⚪ Unknown)  
✅ **Responsive Design** – Adapts to different screen sizes and orientations  
✅ **Material Design 3** – Modern UI components and animations  

---

## 🎬 Demo


## 📸 Screenshots

![Screenshot 1](ClassApp2025/demo/demo.png) ![Screenshot 2](ClassApp2025/demoo/demo.png)  

![Screenshot 3](ClassApp2025/demo/demooo.png) ![Screenshot 4](ClassApp2025/demoooo/demo.png)



---

## 🔧 Technical Details

### 📌 Architecture
- **Language**: Kotlin
- **Pattern**: MVVM (Model-View-ViewModel) with Repository
- **Dependency Injection**: Hilt
- **Jetpack Components**: ViewModel, LiveData, Navigation

### 🏗️ Key Components

#### **📝 RickAndMortyCharacter** (Data Class)
Defines character properties:
- **id** – Unique identifier
- **name** – Character name
- **status** – (Alive/Dead/Unknown)
- **species** – Character species
- **type** – Additional type info
- **gender** – Character gender
- **origin** – Origin location
- **location** – Current location
- **image** – Character image URL
- **episode** – List of episodes featuring the character
- **isFavorite** – Favorite status

#### **📄 MainActivity**
- Entry point of the application
- Manages the **RecyclerView** for character display
- Handles **navigation** and UI state

#### **🎨 RickAndMortyCharacterAdapter**
- Custom **RecyclerView** adapter
- Handles character item display
- Manages **character detail dialog**
- Implements click interactions

---

## 🎨 UI Components

### **🖼️ Character List Item**
- Displays **circular** character image
- Shows **name, status, and species**
- Uses **MaterialCardView** for elevation and touch feedback
- Implements **color-coded status indicators**

### **📜 Character Detail Dialog**
- **Full-screen dialog** with character details
- **Large header image** with gradient overlay
- **Status, species, and gender chips**
- **Detailed information section**
- **Close button** for easy navigation

---

## 🎨 Styling

### **🎨 Colors**
- **Status Colors:**
  - 🟢 **Alive** – `#4CAF50` (Green)
  - 🔴 **Dead** – `#F44336` (Red)
  - ⚪ **Unknown** – `#9E9E9E` (Gray)
- **Theme Colors:**
  - **Primary:** Material Purple
  - **Background:** Dark theme optimized
  - **Text:** High contrast for readability

### **🛠️ Components Used**
- **MaterialCardView** – List items
- **ShapeableImageView** – Circular images
- **MaterialChips** – Status indicators
- **Custom gradients** – Enhancing visual appeal

---

## 📦 Setup and Installation

1️⃣ **Clone the repository:**
```bash
 git clone https://github.com/yourusername/RickAndMortyCharacterViewer.git
```
2️⃣ **Open in Android Studio**
3️⃣ **Sync Gradle and install dependencies**
4️⃣ **Run on an emulator or physical device (Minimum SDK 26)**

---

## 📜 Dependencies

```kotlin
// Core Android
implementation("androidx.core:core-ktx:1.12.0")
implementation("androidx.appcompat:appcompat:1.6.1")
implementation("com.google.android.material:material:1.11.0")

// Image Loading
implementation("io.coil-kt:coil:2.5.0")

// Dependency Injection
implementation("com.google.dagger:hilt-android:2.50")

// View Binding
implementation("androidx.recyclerview:recyclerview:1.3.2")
```

---

## 🤝 Contributing

We welcome contributions! Follow these steps:

1. **Fork** the repository
2. **Create a feature branch** (`feature-new-ui`)
3. **Commit your changes** (`git commit -m "Added new UI animations"`)
4. **Push to the branch** (`git push origin feature-new-ui`)
5. **Create a Pull Request**

---

## 📄 License



## 🙌 Acknowledgments

- **Rick and Morty API** for character data
- **Material Design 3 guidelines**
- **Android development community** for continuous support

---

## 📧 Contact

📩 [abhiishek340@gmail.com]


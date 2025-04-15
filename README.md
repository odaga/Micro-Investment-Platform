# 📱 Micro-Investment Platform – Android App

A simplified micro-investment app built as part of a take-home assignment for Ensibuuko. This Android application allows users to register, view predefined investment plans, invest, and manage their portfolio with interest accrual and lock-in periods.

---

## 🚀 Features

### 🔐 Authentication
- User registration and login
- Basic session handling

### 💼 Investment Plans
- Predefined investment plans seeded in the Room database
- Each plan includes:
    - Name (e.g., **SaveDaily**)
    - Return rate (e.g., **1.5% daily**)
    - Lock period (e.g., **7 days**)

### 📈 Make an Investment
- Users can invest in available plans
- Investment details stored include:
    - Plan name
    - Amount
    - Start date
    - Lock period
    - Return rate

### 🧾 User Portfolio
- View active and past investments
- Track interest accrued over time
- Check if investments are eligible for withdrawal

### 💸 Withdraw Funds
- Withdraw funds after the lock period ends
- Users receive total returns (initial + interest)

### 🔔 Notifications
- Local notifications triggered on:
    - Registration
    - New investment
    - Withdrawal

---

## 🛠️ Tech Stack

- **Kotlin**
- **Android Jetpack Components** (ViewModel, LiveData, Room)
- **SQLite** via Room Persistence Library
- **Material Design UI**
- **MVVM Architecture**

---

## ✅ Bonus Features
- Simple and clean UI/UX
- Separation of concerns using MVVM
- Modular code structure for scalability

---

## 📦 Getting Started

1. **Clone the repo**
   ```bash
   git clone https://github.com/your-username/micro-investment-app.git

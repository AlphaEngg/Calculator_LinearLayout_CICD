# Calculator App CI/CD
# 📱 Calculator App with CI/CD Pipeline using Jenkins & App Center

## 📝 Project Overview

This is a simple Android Calculator App integrated with a **CI/CD pipeline** using **Jenkins**. It demonstrates automated build, test, and deployment to **Microsoft App Center** after every code change committed to GitHub.

---

## 🚀 Technologies Used

- **Java** (Android)
- **Git & GitHub** – Source Code Management
- **Jenkins** – CI/CD Tool
- **JUnit** – Unit Testing Framework
- **App Center (Microsoft)** – Deployment Platform

---

## 🔁 CI/CD Pipeline Workflow

### Step-by-step Process:

1. **Code Push to GitHub**
    - Developer commits & pushes code to the `main` branch.

2. **Jenkins Triggers Build**
    - A Jenkins job (freestyle or pipeline) is triggered via webhook or polling.
    - Jenkins pulls the latest code from GitHub.

3. **Stages in Jenkins Pipeline**:
    - `Clean Workspace`: Removes old build artifacts.
    - `Checkout`: Gets the latest code from GitHub.
    - `Build APK`: Uses Gradle to build the APK.
    - `Run JUnit Tests`: Automatically runs unit tests.
    - `Upload to App Center`: Uses `curl` command to deploy APK.

4. **App Center Deployment**
    - The APK is uploaded to App Center and can be downloaded for testing.

---

## 🧪 Testing Strategy

- We used **JUnit** for unit testing core logic like mathematical operations.
- Tests are triggered automatically in the Jenkins pipeline.
- Example:
  ```java
  @Test
  public void testAddition() {
      assertEquals(4, Calculator.add(2, 2));
  }

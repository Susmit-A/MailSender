# MailSender
A very basic e-mail sending library for android. One line code to send an email.
Currently does not support attachments, text based mail only.
Integration with existing project
---

### Setup

##### build.gradle (project)
```groovy
allprojects {
    repositories {
        ...
        maven {
            url 'https://jitpack.io'
        }
    }
}
```

#### build.gradle (app)
```groovy
dependencies {
    ...
    compile 'com.github.Susmit-A:MailSender:1.0.1'
}
```

### Basic Usage

#### Java
```java
new MailSender(sendersAddress, sendersAccPassword).sendMailAsync(receiversAddr, subject, content);
```

Firebase Cloud Messaging (FCM)
Caractéristiques principales :

*Notifications Push : Envoi de messages push aux appareils utilisateurs, ce qui est utile pour les rappels d'enregistrement de performances, les encouragements, et les notifications de progression.
*Messagerie en Amont : Permet aux utilisateurs de votre application d'envoyer des messages au serveur.
*Gestion de Topics : Les utilisateurs peuvent s'abonner à des topics spécifiques pour recevoir des notifications pertinentes.
*Condition-based Messaging : Envoi de messages basé sur des conditions spécifiques (comme des attributs d'utilisateur définis par Firebase Analytics).
*Programmation et Automatisation : Avec Firebase Functions, vous pouvez automatiser l'envoi de notifications basées sur des déclencheurs en temps réel.
Comment Fonctionne FCM





////Intégration de FCM dans l'application :

Ajout du SDK Firebase à votre projet.
Configuration des autorisations et des clés d'API nécessaires.
Enregistrement de l'application auprès de FCM pour obtenir un token unique pour chaque appareil.
/////Envoi de Notifications :

Utilisation de la console Firebase pour envoyer des messages de test ou planifiés.
Utilisation de l'API FCM pour envoyer des messages personnalisés depuis le backend de l'application.
/////Réception de Notifications :

Configuration des récepteurs dans l'application pour gérer les messages entrants.
Personnalisation des notifications pour inclure des actions spécifiques, des sons, et des icônes.

1. Ajouter le SDK Firebase :
dependencies {
    implementation platform('com.google.firebase:firebase-bom:26.8.0')
    implementation 'com.google.firebase:firebase-messaging'
}


2. Configuration de l'application :
// Dans votre service FirebaseMessagingService
@Override
public void onMessageReceived(RemoteMessage remoteMessage) {
    super.onMessageReceived(remoteMessage);

    // Créez une notification
    NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "CHANNEL_ID")
            .setSmallIcon(R.drawable.notification_icon)
            .setContentTitle(remoteMessage.getNotification().getTitle())
            .setContentText(remoteMessage.getNotification().getBody())
            .setPriority(NotificationCompat.PRIORITY_DEFAULT);

    // Affichez la notification
    NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
    notificationManager.notify(0, builder.build());
}


3. Envoi de notifications depuis le serveur :
// Utilisation de l'API FCM pour envoyer des messages
const admin = require('firebase-admin');
admin.initializeApp();

const message = {
    notification: {
        title: 'Rappel d\'entraînement',
        body: 'N\'oubliez pas d\'enregistrer votre performance aujourd\'hui!'
    },
    token: 'user-device-token'
};

admin.messaging().send(message)
    .then((response) => {
        console.log('Message sent successfully:', response);
    })
    .catch((error) => {
        console.log('Error sending message:', error);
    });



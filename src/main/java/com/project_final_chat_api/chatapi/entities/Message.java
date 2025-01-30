package com.project_final_chat_api.chatapi.entities;

public class Message {

    public class Mеssage {

        private int id;
        private String sender;
        private String receiver;
        private String content;
        private String date;
        private StatusMessages statusMessages;

        public Mеssage(int id, String sender, String receiver, String content, String date, StatusMessages statusMessages) {
            this.id = id;
            this.sender = sender;
            this.receiver = receiver;
            this.content = content;
            this.date = date;
            this.statusMessages = statusMessages;

        }

        @Override
        public String toString() {
            return "Mеssage{" +
                    "id=" + id +
                    ", sender='" + sender + '\'' +
                    ", receiver='" + receiver + '\'' +
                    ", content='" + content + '\'' +
                    ", date='" + date + '\'' +
                    ", statusMessages=" + statusMessages +
                    '}';

        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getSender() {
            return sender;
        }

        public void setSender(String sender) {
            this.sender = sender;
        }

        public String getReceiver() {
            return receiver;
        }

        public void setReceiver(String receiver) {
            this.receiver = receiver;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public StatusMessages getStatusMessages() {
            return statusMessages;
        }

        public void setStatusMessages(StatusMessages statusMessages) {
            this.statusMessages = statusMessages;
        }
    }

}

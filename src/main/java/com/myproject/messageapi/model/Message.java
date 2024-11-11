package com.myproject.messageapi.model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Message {
   
    private static final Logger logger = LoggerFactory.getLogger(Message.class);  
     //Static counter for unique messageIDs; beware it resets when application restarts    
    private static int nextId = 1;
    // Unique identifier for each Message instance
    private  final int id;   
    private String sender;
    private String receiver;
    private String content;

    /**
    * Constructs a new Message instance with a unique ID, sender, receiver, and content.
    * @param sender The sender of the message.
    * @param receiver The receiver of the message.
    * @param content The message content.
    * @throws IllegalArgumentException if sender or receiver is null or empty.
    */    
    public Message(String sender, String receiver, String content){

      
        this.id = nextId;

       
        //Validate sender and log errors
        if (sender == null || sender.isEmpty()){
            logger.error("Invalid 'sender' value: '{}'. Sender can not be null or empty", sender);
            throw new IllegalArgumentException("Sender can not be null or empty");
        }

        //Validate receiver and log errors
        if (receiver == null || receiver.isEmpty()){
            logger.error("Invalid 'receiver' value: '{}'. Receiver can not be null or empty", receiver);
            throw new IllegalArgumentException("Receiver can not be null or empty");
        }

        
        //Handle content. If null or empty assign it to empty string and log warn
        if(content == null || content.isEmpty()){
            logger.warn("Content is missing for MessageID: '{}'", id);
            this.content = "";
        } else{
            this.content = content;  
            
        }  

        //Assign validated fields
        this.sender = sender;
        this.receiver = receiver; 

        //Increment static nextId for the next Message instance      
        nextId += 1; 

        //Log successful creation of Message object.
        logger.info("Message object with id: '{}' is created", id);
        
    }

    //Getter for ID
    public int getId(){
        return this.id;
    }

    //Getter and setter for Sender
    public String getSender(){
        return this.sender;
    }    
    public void setSender(String sender){
        if (sender == null || sender.isEmpty()){
            logger.error("Invalid 'sender' value: '{}'. Sender can not be null or empty", sender );
            throw new IllegalArgumentException("Sender can not be null or empty");
        }

        this.sender = sender;
        logger.info("Sender updated for MessageID: '{}' ", id);
       
    }

    //Getter and setter for Receiver
    public String getReceiver(){
        return this.receiver;
    }
    public void setReceiver(String receiver){

        if (receiver == null || receiver.isEmpty()){
            logger.error("Invalid 'receiver' value: '{}' . Receiver can not be null or empty", receiver);
            throw new IllegalArgumentException("Receiver can not be null or empty");
        }

        this.receiver = receiver;
        logger.info("Receiver updated for MessageID: '{}'", id);
    }


    //Getter and setter for Content
    public String getContent(){
        return this.content;
    }    
    
    public void setContent(String content){
        if (content == null || content.isEmpty()){
            logger.warn("Content is missing for MessageID: '{}' ", id);
            this.content = "";
        }else {        
        this.content = content;
        }

        logger.info("Content updated for MessageID: '{}' ", id);
    }
}

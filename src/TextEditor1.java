import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

// Added Action Listener Interface to our textEditor class to use its methods
public class TextEditor1 implements ActionListener {
    // Create a frame for text editor
    JFrame frame;
    // Creates a menuBar for containing the menus of the frame
    JMenuBar menuBar;
    // Create Menus for the frame
    JMenu file,edit;
    // Create MenuItems for the file Menu
    JMenuItem newFile, openFile, saveFile;
    // Create MenuItems for the edit Menu
    JMenuItem cut, copy, paste, selectAll, close;

    // Create TextArea for the frame
    JTextArea textarea;

    // Constructor for text editor
    TextEditor1(){
        // Initialize a frame
        frame = new JFrame();
        // Initialize TextArea for frame
        textarea = new JTextArea();
        // Initialize a menuBar for the frame
        menuBar = new JMenuBar();
        // Initialize menus
        file = new JMenu("File");
        edit = new JMenu("Edit");
        // Initialize MenuItems for file Menu
        newFile = new JMenuItem("New");
        openFile = new JMenuItem("Open");
        saveFile = new JMenuItem("Save");

        // Add action Listeners for file Menu Items
        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);

        // Add MenuItems to file Menu
        file.add(newFile);
        file.add(openFile);
        file.add(saveFile);

        // Initialize MenuItems for edit Menu
        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        selectAll = new JMenuItem("Select All");
        close = new JMenuItem("Close Window");

        // Add MenuItems to edit Menu
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        edit.add(close);

        // Add ActionListeners for edit Menu Items
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);
        close.addActionListener(this);

        // Set dimensions and location for the frame
        frame.setBounds(100,100, 550, 500);
        // Mark frame to be unhidden
        frame.setVisible(true);
        // Add a menuBar to the frame
        frame.setJMenuBar(menuBar);
        // Add Text Area to the frame
        frame.add(textarea);
        // Add menus to the menuBar
        menuBar.add(file);
        menuBar.add(edit);



    }

    @Override
    public void actionPerformed(ActionEvent actionEvent){
        // Action source of the performed Action Event is cut
        if(actionEvent.getSource()==cut){
            // Perform cut action in textarea
            textarea.cut();
        }
        // Action source of the performed Action Event is copy
        if(actionEvent.getSource()==copy){
            // Perform the copy action in the textarea
            textarea.copy();
        }
        // Action source of the performed Action Event is paste
        if(actionEvent.getSource()==paste){
            // Perform the paste action in the textarea
            textarea.paste();
        }
        // Action source of the performed Action Event is select All
        if(actionEvent.getSource()==selectAll){
            // Perform the select All action in the textarea
            textarea.selectAll();
        }
        // Action source of the performed Action Event is close
        if(actionEvent.getSource()==close){
            // Perform the close application action
            System.exit(0);
        }
        // Action source of the performed Action Event is newFile
        if(actionEvent.getSource()==newFile){
            // Create a new text editor window
            TextEditor1 newText = new TextEditor1();
        }
        // Action source of the performed Action Event is openFile
        if(actionEvent.getSource()==openFile){
            // Open a file in TextEditor

            // Initialize a fileChooser window
            JFileChooser fileChooser = new JFileChooser("C:");
            // Get Choose option from the file Chooser
            int chooseOption = fileChooser.showOpenDialog(null);
            // If the choose Option is equal to the approved option
            if(chooseOption==JFileChooser.APPROVE_OPTION){
                // Get the Selected file
                File file = fileChooser.getSelectedFile();
                // Get the selected file path
                String filePath = file.getPath();

                try {
                    // Buffered Reader to read the contents of the file in buffered Manner
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    // Create Strings to store the contents of the file
                    String intermediate = "", output = "";
                    // Read the file contents line by line
                    while((intermediate = reader.readLine() ) !=null){
                        // Store the file content in output line by line
                        output+=intermediate+ "\n";
                    }
                    // Open the output file contents in the textarea
                    textarea.setText(output);

                }
                catch(Exception exception){
                    exception.getStackTrace();
                }
            }
        }
        // Action source of the performed Action Event is saveFile
        if(actionEvent.getSource()==saveFile){
            // Save the file

            // Initialize the JFileChooser window
            JFileChooser fileChooser = new JFileChooser("C:");
            // Get the choose option from fileChooser
            int chooseOption = fileChooser.showSaveDialog(null);
            // If the choose Option is Approve
            if(chooseOption == JFileChooser.APPROVE_OPTION){
                // Create a file in selected path with given name
                File file1 = new File(fileChooser.getSelectedFile().getAbsolutePath()+".txt");
                try{
                    // Initialize a Buffered Writer to write contents to file1
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file1));
                    // Get content from textarea to the buffered writer
                    textarea.write(writer);
                }
                catch(Exception exception){
                    exception.getStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) {
        // Initialize a new text editor
        TextEditor1 textEdit = new TextEditor1();


    }
}
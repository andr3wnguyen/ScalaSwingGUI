import scala.swing._
import scala.swing.event._
import java.awt.Color
import scala.swing.Swing.LineBorder


object AppGui extends SimpleSwingApplication {
  def top = new MainFrame() {
    title = "My first app"

    val container = new BorderPanel
    container.preferredSize = new Dimension(1000,800)
    val appTitle = new Label {
      text = "Sneaky Hangman"
      preferredSize = new Dimension(200,50)
      border = LineBorder(Color.black)
    }
    container.layout(appTitle) = BorderPanel.Position.North

    //create container for the letters
    //new button with reactions added to the box, the button prints text
    val alphabet = Seq('a' to 'z')
    val letterChoices = new GridPanel(10,20) {
      for (i <- alphabet; j <- i) {
        contents += new Button {
          reactions += {
            case ButtonClicked(_) => println(text)
          }
          text = j.toString
        }
      }
      contents += new Button {
        text = "New Game"
        reactions += {
          case ButtonClicked(_) => println(text)
        }
      }
    }
    //add letters to container
    container.layout(letterChoices) = BorderPanel.Position.South


    val hangman = new BoxPanel(Orientation.Horizontal) {
      val hangmanLabel = new Label {
        text = "this is where the hangman diagram is implemented"
      }
      contents += hangmanLabel
      background = Color.white

    }
    hangman.preferredSize = new Dimension(10,10)
    container.layout(hangman) = BorderPanel.Position.Center



    val currentBoard = new BoxPanel(Orientation.Horizontal) {
      val currentBoardLabel = new Label {
        text = "Current Board"
      }
      preferredSize = new Dimension(400,200)
      contents += currentBoardLabel
      currentBoardLabel.xLayoutAlignment = 0.5f
    }

    container.layout(currentBoard) = BorderPanel.Position.East



    contents = container





  }

}

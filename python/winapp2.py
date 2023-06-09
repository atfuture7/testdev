from PyQt6.QtWidgets import QApplication, QWidget, QLabel, QLineEdit, QPushButton, QTextEdit
from PyQt6.QtGui import QIcon, QFont
from PyQt6.QtCore import Qt
import sys
from xlsxLoc import xlsxLoc

class Window(QWidget):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("FindCell")
        self.setWindowIcon(QIcon('icon.jpg'))

        label = QLabel("Load file", self)
        label.setFont(QFont('Arial', 16))
        label.setAlignment(Qt.AlignmentFlag.AlignLeft & Qt.AlignmentFlag.AlignTop)
        label.move(10, 10)

        self.input = QLineEdit(self)
        self.input.move(10, 40)
        self.input.resize(200, 24)
        self.input.setText("Book.xlsx")
        self.input.setFont(QFont('Arial', 12))

        button = QPushButton("Load", self)
        button.clicked.connect(self.doLoad)
        button.move(220, 40)

        label = QLabel("Find Value(precise)", self)
        label.setAlignment(Qt.AlignmentFlag.AlignLeft & Qt.AlignmentFlag.AlignTop)
        label.setFont(QFont('Arial', 16))
        label.move(10, 80)

        self.input1 = QLineEdit(self)
        self.input1.move(10, 120)
        self.input1.resize(200, 24)
        self.input1.setFont(QFont('Arial', 12))

        button = QPushButton("Seek", self)
        button.clicked.connect(self.doSeek)
        button.move(220, 120)

        self.input2 = QTextEdit(self)
        self.input2.setText("No file loaded yet.\nFind the first occurrence in each column")
        self.input2.move(10, 160)
        self.input2.setFont(QFont('Arial', 16))
        self.input2.resize(280, 120)
       # self.label1.setAlignment(Qt.AlignmentFlag.AlignLeft & Qt.AlignmentFlag.AlignTop)
        self.setGeometry(300, 300, 300, 300)
        self.show()

        self.oXlsxSearch = xlsxLoc()


    def doLoad(self):
        self.input2.setText(self.input.text())
        self.oXlsxSearch.loadFile(self.input.text())

    def doSeek(self):
        self.oXlsxSearch.cellSearch(self.input1.text().strip())
        self.input2.setText(', '.join(self.oXlsxSearch.getResult()))


app = QApplication(sys.argv)
window = Window()
window.show()
sys.exit(app.exec())
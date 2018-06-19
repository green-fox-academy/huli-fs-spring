Feature: CcmbrTsts

  Scenario: read file
    Given a file, in the local filesystem, at path:readthis.txt
    When the file contains readFile
    Then there a file exists, in the local filesystem, at path: readthis.txt, containing:readFile


  Scenario: update file
    Given a file, in the local filesystem, at path:updateThis.txt
    When the file contains updatingThis
    Then there a file exists, in the local filesystem, at path: updateThis.txt, containing:updatingThis

  Scenario: its a file
    Given a file, in the local filesystem, at path:src/fajl.txt
    Then there is a file, in the local filesystem, at path: src/fajl.txt

  Scenario: delete file
    Given a file, in the local filesystem, at path:deleteFile.yml
    When a file is deleted at path: deleteFile.yml, from the filesystem
    Then there is no file, in the local filesystem, at path: deleteFile.yml

  Scenario: move file
    Given a file, in the local filesystem, at path:src/move.txt
    When a file, in the local filesystem, is moved from src/move.txt to move.txt
    Then there is a file, in the local filesystem, at path: move.txt

  Scenario: copy file
    Given a file, in the local filesystem, at path:src/copy.txt
    When a file, in the local filesystem, is copied from src/copy.txt to copy.txt
    Then there is a file, in the local filesystem, at path: copy.txt

  Scenario: list directory
    Given a directory, in the local filesystem, at path:<string>
    When the directory conatins:
      | apple.txt |
      | fruits.yml   |
    Then the directory at path: "dirname/" should contain these items:
      | apple.txt |
      | fruits.yml   |

  Scenario: its a directory
    Given a directory, in the local filesystem, at path:itsDir
    Then there is a directory, in the local filesystem, at path: itsDir


  Scenario: delete directory
    Given a directory, in the local filesystem, at path:deleteDir
    When a directory is deleted at path: deleteDir, from the filesystem
    Then there is no directory, in the local filesystem, at path: deleteDir

#  Scenario: move directory
#    Given a directory, in the local filesystem, at path: dirMove
#    When a directory, in the local filesystem, is moved from dirMove to src/dirMove
#    Then there is a directory, in the local filesystem, at path: src/dirMove

  Scenario: copy directory
    Given a directory, in the local filesystem, at path:dirCopy
    When a directory, in the local filesystem, is copied from dirCopy to src/dirCopy
    Then there is a directory, in the local filesystem, at path: src/dirCopy
#
#Given a file, in the local filesystem, at path: "dirname/apple.txt", containing:
#  """
#  Hello, world!
#  """
#Given a directory, in the local filesystem, at path: "dirname/"
#When a file, in the local filesystem, is created at path: "dirname/apple.txt", containing:
#  """
#  Hello, world!
#  """
#When a file, in the local filesystem, is edited at path: "dirname/apple.txt", containing:
#
#  """
#  Hello, world!
#  """
#When a file is deleted at path: "dirname/apple.txt", from the filesystem
#When a directory is create at path: "dirname/"
#When a directory is deleted at path: "dirname/"
#
#Then there is a file, in the local filesystem, at path: "dirname/apple.txt", containing:
#  """
#  Hello, world!
#  """
#
#Then the directory at path: "dirname/" should contain these items:
#| apple.txt |
#| fruits    |

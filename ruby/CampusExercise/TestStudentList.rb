require './studentList'
class TestStudentList
  newList = StudentList.new()
  newList.load_all_files()
  puts "Display List by Campus"
  newList.display_list_by_campus()
  puts "Display List by Date of Birth"
  newList.display_list_by_dob()
  puts "Display List by Last Name Desc"
  newList.display_list_by_last_name()
end
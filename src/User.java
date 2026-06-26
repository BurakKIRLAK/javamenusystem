public class User {

        private String   userName;
        private char     adminValue;
        private boolean  isAdmin;

        public  User(String userName, char adminValue, boolean isAdmin) {
                this.userName = userName;
                this.adminValue = adminValue;
                this.isAdmin = isAdmin;
        }

        public char getAdminValue() {
                return adminValue;
                }
        public boolean isAdmin(){
                return isAdmin;
                }
        }





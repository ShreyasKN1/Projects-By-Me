package JavaExamples.DesignPatterns.BuilderPattern;

public class User {
    private  final int age;
     private  final String name;

     private final String address;
     private final String college;


     public User(Builder builder) {
        this.age = builder.age;
        this.name = builder.name;
        this.address = builder.address;
        this.college = builder.college;

    }

    

    public static class Builder{
        private  final int age;
        private  final String name;
        private String address;
        private String college;
         public Builder(int age, String name) {
            this.age = age;
            this.name = name;
        }
        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }
        public Builder setCollege(String college) {
            this.college = college;
            return this;
        }

        public User build(){
            return new User(this);
        }

        

    }
      @Override
        public String toString() {
        return "User [age=" + age + ", name=" + name + ", address=" + address + ", college=" + college + "]";
         }


     public static void main(String[] args) {
        User user=new User.Builder(25,"Shreyas")
        .setAddress("bengaluru")
        .setCollege("MVJ College ")
        .build();

        System.out.println(user);
     }

}

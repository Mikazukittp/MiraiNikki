class CreateUsers < ActiveRecord::Migration
  def change
    create_table :users do |t|
      t.string :username, unique: true
      t.string :email
      t.date :birthday
      t.string :password
      t.string :salt
      t.string :token

      t.timestamps null: false
    end
  end
end

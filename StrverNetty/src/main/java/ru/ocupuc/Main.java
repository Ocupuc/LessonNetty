package ru.ocupuc;

public class Main {

    public static void main(String[] args) {

        int port = args.length > 0
                ? Integer.parseInt(args[0])
                : 8001;
        new NettyServer(port);
    }
}

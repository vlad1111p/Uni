package priorityqueue;

import org.junit.Assert;
import org.junit.runner.RunWith;
import smallcheck.SmallCheckRunner;
import smallcheck.annotations.Property;
import smallcheck.annotations.StaticFactory;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;
import java.util.function.Function;


/**
 * Hier werden die Implementierungen systematisch mit kleinen Beispielen getestet.
 */
@RunWith(SmallCheckRunner.class)
public class PriorityQueueSmallcheck {

    @Property(maxDepth = 30, maxInvocations = 1000000)
    @StaticFactory(CommandFactory.class)
    public void testSingleLinkedList(List<Command> commands) {
        simulate(SingleLinkedList::new, commands);
    }

    @Property(maxDepth = 30, maxInvocations = 1000000)
    @StaticFactory(CommandFactory.class)
    public void testSingleLinkedSortedList(List<Command> commands) {
        simulate(SingleLinkedSortedList::new, commands);
    }

    @Property(maxDepth = 30, maxInvocations = 1000000)
    @StaticFactory(CommandFactory.class)
    public void testLeftistTree(List<Command> commands) {
        simulate(LeftistTree::new, commands);
    }

    private void simulate(Function<Comparator<Integer>, PriorityQueue<Integer>> ag, List<Command> commands) {
        PriorityQueue<Integer> a = ag.apply(Comparator.naturalOrder());
        PriorityQueue<Integer> b = ag.apply(Comparator.naturalOrder());
        Model am = new Model();
        Model bm = new Model();

        for (int i = 0; i < commands.size(); i++) {
            Command command = commands.get(i);
            Object res;
            try {
                res = command.execute(a, b);
            } catch (Exception e) {
                StringBuilder msg = errorMessage(a, b, commands, i, command);
                msg.append("Exception when executing ");
                command.print(msg);
                msg.append(":\n");
                printException(e, msg);
                Assert.fail(msg.toString());
                return;
            }
            Object mres = command.execute(am, bm);
            if (!Objects.equals(res, mres)) {
                StringBuilder msg = errorMessage(a, b, commands, i, command);
                msg.append("// Expected ").append(mres).append(" but got ").append(res);
                Assert.fail(msg.toString());
            }
        }

    }

    private void printException(Exception e, StringBuilder msg) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        msg.append(sw.toString());
    }

    private StringBuilder errorMessage(PriorityQueue<Integer> a, PriorityQueue<Integer> b, List<Command> commands, int i, Command command) {
        StringBuilder msg = new StringBuilder();
        msg.append("// Failing test:\n");
        msg.append("PriorityQueue<Integer> a = new ").append(a.getClass().getSimpleName()).append("<>(Comparator.naturalOrder());\n");
        msg.append("PriorityQueue<Integer> b = new ").append(b.getClass().getSimpleName()).append("<>(Comparator.naturalOrder());\n");
        for (int j = 0; j < i; j++) {
            commands.get(j).print(msg);
            msg.append(";\n");
        }
        command.print(msg);
        msg.append("\n");
        return msg;
    }

    public static class CommandFactory {
        public static Command insert(boolean f, int v) {
            return new Command() {
                @Override
                Object execute(PriorityQueue<Integer> a, PriorityQueue<Integer> b) {
                    if (f) {
                        return b.insert(v);
                    } else {
                        return a.insert(v);
                    }

                }

                @Override
                void print(StringBuilder sb) {
                    sb.append(f ? "b" : "a");
                    sb.append(".insert(").append(v).append(")");
                }
            };
        }

        public static Command merge() {
            return new Command() {
                @Override
                Object execute(PriorityQueue<Integer> a, PriorityQueue<Integer> b) {
                    a.merge(b);
                    return null;
                }

                @Override
                void print(StringBuilder sb) {
                    sb.append("a.merge(b)");
                }
            };
        }

        public static Command deleteMin(boolean f) {
            return new Command() {
                @Override
                Object execute(PriorityQueue<Integer> a, PriorityQueue<Integer> b) {
                    PriorityQueue<Integer> q = f ? b : a;
                    if (q.isEmpty()) {
                        return null;
                    } else {
                        return q.deleteMin();
                    }
                }

                @Override
                void print(StringBuilder sb) {
                    sb.append(f ? "b" : "a");
                    sb.append(".deleteMin()");
                }
            };
        }

        public static Command getMin() {
            return new Command() {
                @Override
                Object execute(PriorityQueue<Integer> a, PriorityQueue<Integer> b) {
                    if (a.isEmpty()) {
                        return null;
                    } else {
                        return a.getMin();
                    }
                }

                @Override
                void print(StringBuilder sb) {
                    sb.append("a.getMin()");
                }
            };
        }

        public static Command isEmpty(boolean f) {
            return new Command() {
                @Override
                Object execute(PriorityQueue<Integer> a, PriorityQueue<Integer> b) {
                    if (f) {
                        return a.isEmpty();
                    } else {
                        return b.isEmpty();
                    }
                }

                @Override
                void print(StringBuilder sb) {
                    sb.append(f ? "a" : "b");
                    sb.append(".isEmpty()");
                }
            };
        }
    }

    static abstract class Command {
        abstract Object execute(PriorityQueue<Integer> a, PriorityQueue<Integer> b);

        abstract void print(StringBuilder sb);

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            print(sb);
            return sb.toString();
        }
    }


    private static class Model implements PriorityQueue<Integer> {
        private java.util.PriorityQueue<Integer> jq = new java.util.PriorityQueue<>();

        @Override
        public boolean insert(Integer integer) {
            return jq.add(integer);
        }

        @Override
        public void merge(PriorityQueue<Integer> q) {
            while (!q.isEmpty()) {
                jq.add(q.deleteMin());
            }
        }

        @Override
        public Integer deleteMin() {
            return jq.poll();
        }

        @Override
        public Integer getMin() {
            return jq.peek();
        }

        @Override
        public boolean isEmpty() {
            return jq.isEmpty();
        }

        @Override
        public String toString() {
            return jq.toString();
        }
    }


}
